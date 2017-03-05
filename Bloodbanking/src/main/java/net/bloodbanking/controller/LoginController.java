package net.bloodbanking.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
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
import net.bloodbanking.constants.ViewConstants;
import net.bloodbanking.dto.BloodDonationDTO;
import net.bloodbanking.dto.BloodGroupMstDTO;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.FeedbackDTO;
import net.bloodbanking.dto.ListDTO;
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
			setValueInSession(request, AppConstants.NAME, registrationDTO.getLocationAddressDTO().getName());
			setValueInSession(request, AppConstants.USER_PRIVILEGES, userPrivileges);
			setValueInSession(request, AppConstants.USERTYPENAME, userTypeMstDTO.getUsertypeName());
			setValueInSession(request, AppConstants.USERTYPEID, userTypeMstDTO.getUsertypeId());
			setValueInSession(request, AppConstants.SUBMENUVIEWNAME, AppConstants.SUBMENUVIEW);
			if(AppConstants.ADMIN_NAME.equals(userTypeMstDTO.getUsertypeName())){
				setValueInSession(request, AppConstants.SUPERUSER, "1");
			}
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
		setLoginRelatedParams(map, "Home", null);
		return ViewConstants.VIEWHOME;
	}
	
	@RequestMapping("/viewProfile.html")
	public String viewProfile(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			registrationDTO.setUserName((String) getValueFromSession(request, AppConstants.USER_NAME));
			registrationDTO = loginService.loadRegistration(registrationDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
		}
		setLoginRelatedParams(map, "Profile", registrationDTO);
		return ViewConstants.PROFILEDETAIL;
	}
	
	@RequestMapping("/editProfile.html")
	public String editProfile(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		viewProfile(registrationDTO, request, response, map);
		return ViewConstants.PROFILEEDIT;
	}
	
	@RequestMapping("/processEditProfile.html")
	public String processEditProfile(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			registrationDTO.setUserName((String) getValueFromSession(request, AppConstants.USER_NAME));
			loginService.processEditProfile(registrationDTO);
			setValueInSession(request, AppConstants.NAME, registrationDTO.getLocationAddressDTO().getName());
			registrationDTO.setResponseMessage("Profile update success");
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
			editProfile(registrationDTO, request, response, map);
		}
		return viewProfile(registrationDTO, request, response, map);
	}

	@RequestMapping("/viewChangePassword.html")
	public String viewChangePassword(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		setLoginRelatedParams(map, "ChangePassword", registrationDTO);
		return ViewConstants.CHANGEPASSWORD;
	}

	@RequestMapping("/processChangePassword.html")
	public String processChangePassword(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			registrationDTO.setUserName((String) getValueFromSession(request, AppConstants.USER_NAME));
			loginService.processChangePassword(registrationDTO);
			registrationDTO.setResponseMessage("Change password success");
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
		}
		return viewChangePassword(registrationDTO, request, response, map);
	}
	
	@RequestMapping("/viewUser.html")
	public String viewUser(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			if(null == registrationDTO.getUsertypeId() && !isSuperUserLogin(request)){
				registrationDTO.setUsertypeId((Long)getValueFromSession(request, AppConstants.USERTYPEID));
			}
			ListDTO<RegistrationDTO> listDTO = loginService.viewUser(registrationDTO);
			if(CollectionUtils.isNotEmpty(listDTO.getList())){
				applyPagination(listDTO, registrationDTO, AppConstants.RESULTSPERPAGE);
			}
			map.put(AppConstants.SEARCHRESULT, listDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
		}
		setLoginRelatedParams(map, "User", registrationDTO);
		return ViewConstants.USERVIEW;
	}
	
	@RequestMapping("/detailUser.html")
	public String detailUser(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			registrationDTO = loginService.loadRegistration(registrationDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
			return viewUser(registrationDTO, request, response, map);
		}
		setLoginRelatedParams(map, "User", registrationDTO);
		return ViewConstants.USERDETAIL;
	}
	
	@RequestMapping("/activateUser.html")
	public String activateUser(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			loginService.activateUser(registrationDTO);
			registrationDTO.setResponseMessage("User activation success");
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
		}
		return viewUser(registrationDTO, request, response, map);
	}
	
	@RequestMapping("/deactivateUser.html")
	public String deactivateUser(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			loginService.deactivateUser(registrationDTO);
			registrationDTO.setResponseMessage("User deactivation success");
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(registrationDTO, e);
		}
		return viewUser(registrationDTO, request, response, map);
	}
	
	@RequestMapping("/viewFeedback.html")
	public String viewFeedback(FeedbackDTO feedbackDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			ListDTO<FeedbackDTO> listDTO = loginService.viewFeedback(feedbackDTO);
			if(CollectionUtils.isNotEmpty(listDTO.getList())){
				applyPagination(listDTO, feedbackDTO, AppConstants.RESULTSPERPAGE);
			}
			map.put(AppConstants.SEARCHRESULT, listDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(feedbackDTO, e);
		}
		setLoginRelatedParams(map, "Feedback", feedbackDTO);
		return ViewConstants.FEEDBACKVIEW;
	}
	
	@RequestMapping("/viewEnquiry.html")
	public String viewEnquiry(EnquiryFormDTO enquiryFormDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			ListDTO<EnquiryFormDTO> listDTO = loginService.viewEnquiry(enquiryFormDTO);
			if(CollectionUtils.isNotEmpty(listDTO.getList())){
				applyPagination(listDTO, enquiryFormDTO, AppConstants.RESULTSPERPAGE);
			}
			map.put(AppConstants.SEARCHRESULT, listDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(enquiryFormDTO, e);
		}
		setLoginRelatedParams(map, "Enquiry", enquiryFormDTO);
		return ViewConstants.ENQUIRYVIEW;
	}
	
	@RequestMapping("/addBloodDonation.html")
	public String addBloodDonation(BloodDonationDTO bloodDonationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			RegistrationDTO registrationDTO = new RegistrationDTO();
			registrationDTO.setUsertypeId(AppConstants.BLOODBANK_ID.longValue());
			map.put("bloodBankList", loginService.viewUser(registrationDTO).getList());
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(bloodDonationDTO, e);
		}
		setLoginRelatedParams(map, "BloodDonation", bloodDonationDTO);
		return ViewConstants.BLOODDONATIONADD;
	}

	@RequestMapping("/processBloodDonation.html")
	public String processBloodDonation(BloodDonationDTO bloodDonationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			bloodDonationDTO.setDonorUserName((String) getValueFromSession(request, AppConstants.USER_NAME));
			loginService.processBloodDonation(bloodDonationDTO);
		}catch(ApplicationException e){
			handleApplicationExceptionForJson(bloodDonationDTO, e);
			return addBloodDonation(bloodDonationDTO, request, response, map);
		}
		bloodDonationDTO.setResponseMessage("Added blood donation");
		return viewBloodDonation(bloodDonationDTO, request, response, map);
	}
	
	@RequestMapping("/viewBloodDonation.html")
	public String viewBloodDonation(BloodDonationDTO bloodDonationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			ListDTO<BloodDonationDTO> listDTO = loginService.viewBloodDonation(bloodDonationDTO);
			if(CollectionUtils.isNotEmpty(listDTO.getList())){
				applyPagination(listDTO, bloodDonationDTO, AppConstants.RESULTSPERPAGE);
			}
			map.put(AppConstants.SEARCHRESULT, listDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(bloodDonationDTO, e);
		}
		setLoginRelatedParams(map, "BloodDonation", bloodDonationDTO);
		return ViewConstants.BLOODDONATIONVIEW;
	}
	
	@RequestMapping("/viewBloodAvailability.html")
	public String viewBloodAvailability(EnquiryFormDTO enquiryFormDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try {
			ListDTO<EnquiryFormDTO> listDTO = loginService.viewEnquiry(enquiryFormDTO);
			if(CollectionUtils.isNotEmpty(listDTO.getList())){
				applyPagination(listDTO, enquiryFormDTO, AppConstants.RESULTSPERPAGE);
			}
			map.put(AppConstants.SEARCHRESULT, listDTO);
		} catch (ApplicationException e) {
			handleApplicationExceptionForJson(enquiryFormDTO, e);
		}
		setLoginRelatedParams(map, "Enquiry", enquiryFormDTO);
		return ViewConstants.BLOODAVAILABILITYVIEW;
	}
}
