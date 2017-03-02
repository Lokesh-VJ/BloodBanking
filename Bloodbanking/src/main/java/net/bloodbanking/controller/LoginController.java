package net.bloodbanking.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.constants.ErrorConstants;
import net.bloodbanking.constants.SuccessConstants;
import net.bloodbanking.constants.ViewConstants;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.dto.UserTypeMappingDTO;
import net.bloodbanking.dto.UserTypeMstDTO;
import net.bloodbanking.exception.ApplicationException;
import net.bloodbanking.exception.ApplicationMessage;
import net.bloodbanking.service.LoginService;

@Controller("loginController")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login.html")
	public String login(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("loginPageActive", "active");
		map.put("baseDTO", registrationDTO);
		return ViewConstants.LOGIN;
	}

	@RequestMapping("/processLogin.html")
	public String processLogin(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		RegistrationDTO registrationDTO = new RegistrationDTO();
		try{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			registrationDTO.setUserName(authentication.getName());
			registrationDTO = loginService.loadRegistration(registrationDTO);
			if(null != registrationDTO && registrationDTO.getStatusMstDTO().getStatus() != AppConstants.ACTIVE){
				throw new ApplicationException(ErrorConstants.USER_NOT_ACTIVE);
			}
			UserTypeMstDTO userTypeMstDTO = new UserTypeMstDTO();
			userTypeMstDTO.setUsertypeId(registrationDTO.getUsertypeId().intValue());
			userTypeMstDTO = loginService.loadUserType(userTypeMstDTO);
			List<UserTypeMappingDTO> userPrivileges = loginService.loadPrivileges(userTypeMstDTO);
			setValueInSession(request, AppConstants.USER_NAME, registrationDTO.getUserName());
			setValueInSession(request, AppConstants.USER_PRIVILEGES, userPrivileges);
			setValueInSession(request, AppConstants.USERTYPENAME, userTypeMstDTO.getUsertypeName());
			setValueInSession(request, AppConstants.SUBMENUVIEWNAME, AppConstants.SUBMENUVIEW);
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			return login(registrationDTO, request, response, map);
		}
		return "redirect:welcome.html";
	}

	@RequestMapping("/forgotPassword.html")
	public String forgotPassword(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("securityQuestionList", loginService.listSecurityQuestions(new SecurityQuestionDTO()));
		map.put("baseDTO", registrationDTO);
		return ViewConstants.VERIFYSECURITYQUESTION;
	}

	@RequestMapping("/verifySecurityQuestion.html")
	public String verifySecurityQuestion(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.verifySecurityQuestion(registrationDTO);
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			return forgotPassword(new RegistrationDTO(), request, response, map);
		}
		map.put("baseDTO", registrationDTO);
		return ViewConstants.FORGOTPASSWORD;
	}

	@RequestMapping("/processForgotPassword.html")
	public String processForgotPassword(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processForgotPassword(registrationDTO);
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			map.put("baseDTO", registrationDTO);
			return ViewConstants.FORGOTPASSWORD;
		}
		registrationDTO.setResponseMessage("Password reset success");
		return login(registrationDTO, request, response, map);
	}
	
	@RequestMapping("/signup.html")
	public String signup(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("userTypeList", loginService.listUserTypes(new UserTypeMstDTO()));
		map.put("bloodGroupList", loginService.listBloodGroups(new BloodGroupMstDTO()));
		map.put("securityQuestionList", loginService.listSecurityQuestions(new SecurityQuestionDTO()));
		map.put("signupPageActive", "active");
		map.put("baseDTO", registrationDTO);
		return ViewConstants.SIGNUP;
	}

	@RequestMapping("/processSignup.html")
	public String processSignup(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processSignup(registrationDTO);
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			return signup(registrationDTO, request, response, map);
		}
		registrationDTO.setResponseMessage("User registration success");
		return login(registrationDTO, request, response, map);
	}

	@RequestMapping("/enquiry.html")
	public String enquiry(EnquiryFormDTO enquiryFormDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("enquiryPageActive", "active");
		map.put("baseDTO", enquiryFormDTO);
		return ViewConstants.ENQUIRY;
	}

	@RequestMapping("/processEnquiry.html")
	public String processEnquiry(EnquiryFormDTO enquiryFormDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processEnquiry(enquiryFormDTO);
			enquiryFormDTO = new EnquiryFormDTO();
			enquiryFormDTO.setResponseMessage("Thank you. We will get back to you.");
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(enquiryFormDTO, e);
		}
		return enquiry(enquiryFormDTO, request, response, map);
	}

	@RequestMapping("/feedback.html")
	public String feedback(FeedbackDTO feedbackDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("feedbackPageActive", "active");
		map.put("baseDTO", feedbackDTO);
		return ViewConstants.FEEDBACK;
	}

	@RequestMapping("/processFeedback.html")
	public String processFeedback(FeedbackDTO feedbackDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processFeedback(feedbackDTO);
			feedbackDTO = new FeedbackDTO();
			feedbackDTO.setResponseMessage("Thank you. We will get back to you.");
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(feedbackDTO, e);
		}
		return feedback(feedbackDTO, request, response, map);
		}

	@RequestMapping("/welcome.html")
	public String welcome(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("welcomePageActive", "active");
		return ViewConstants.WELCOME;
	}

	@RequestMapping("/changePassword.html")
	public String changePassword(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("changePasswordPageActive", "active");
		return ViewConstants.CHANGEPASSWORD;
	}

	@RequestMapping("/processChangePassword.html")
	public String processChangePassword(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		return ViewConstants.CHANGEPASSWORD;
	}
	
	@RequestMapping(value = "/passwordAttempts.html")
	public String passwordAttempts(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {

		ApplicationMessage message = null;
		RegistrationDTO registrationDTO = new RegistrationDTO();
		AuthenticationException authenticationException = (AuthenticationException) getValueFromSession(request,
				WebAttributes.AUTHENTICATION_EXCEPTION);
		if (authenticationException instanceof LockedException) {
			message = new ApplicationMessage(ErrorConstants.ACCOUNT_LOCKED);
		} else if (authenticationException instanceof CredentialsExpiredException) {
			message = new ApplicationMessage(ErrorConstants.CREDENTIAL_EXPIRED);
		} else if (authenticationException instanceof BadCredentialsException) {
			message = new ApplicationMessage(ErrorConstants.INVALID_CREDENTIALS);
		} else if (authenticationException instanceof DisabledException) {
			message = new ApplicationMessage(ErrorConstants.USER_NOT_ACTIVE);
		}else {
			message = new ApplicationMessage(ErrorConstants.INVALID_CREDENTIALS);
		}
		registrationDTO.setRequestFailed(true);
		registrationDTO.setResponseMessage(message.getKey());
		return login(registrationDTO, request, response, map);
	}
	
	@RequestMapping(value = "/accessDenied.html", method = RequestMethod.GET)
	public String accessDenied(HttpServletRequest request, Map<String, Object> map, HttpServletResponse response) {
		request.getSession().invalidate();
		Cookie terminate = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, null);
		terminate.setMaxAge(0);
		response.addCookie(terminate);
		SecurityContextHolder.clearContext();
		return login(new RegistrationDTO(), request, response, map);
	}
	
	@RequestMapping(value = "/sessionTimeout.html")
	public String sessionTimeout(HttpServletRequest request, Map<String, Object> map, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null != authentication) {
			request.getSession().invalidate();
			Cookie terminate = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, null);
			terminate.setMaxAge(0);
			response.addCookie(terminate);
			SecurityContextHolder.clearContext();
		}
		SecurityContextHolder.clearContext();
		return login(new RegistrationDTO(), request, response, map);
	}
	
	@RequestMapping(value = "/logout.html")
	public String logout(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		Cookie terminate = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, null);
		terminate.setMaxAge(0);
		response.addCookie(terminate);
		SecurityContextHolder.clearContext();
		return login(new RegistrationDTO(), request, response, map);
	}
	
	@RequestMapping("/viewHome.html")
	public String viewHome(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		setAjaxRelatedParams(map);
		return ViewConstants.VIEWHOME;
	}
	
	@RequestMapping("/viewProfile.html")
	public String viewProfile(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		setAjaxRelatedParams(map);
		return ViewConstants.PROFILEDETAIL;
	}
	
	@RequestMapping("/editProfile.html")
	public String editProfile(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		setAjaxRelatedParams(map);
		return ViewConstants.PROFILEEDIT;
	}
	
	@RequestMapping("/processEditProfile.html")
	public String processEditProfile(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		setAjaxRelatedParams(map);
		return ViewConstants.PROFILEDETAIL;
	}
	
	private void setAjaxRelatedParams(Map<String, Object> map){
		map.put(AppConstants.AJAXCONTENTFLAG, 1);
	}
}
