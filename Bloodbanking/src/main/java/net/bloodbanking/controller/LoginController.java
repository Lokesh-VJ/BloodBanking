package net.bloodbanking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.constants.ViewConstants;
import net.bloodbanking.dto.EnquiryFormDTO;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.exception.NhanceApplicationException;
import net.bloodbanking.service.LoginService;

@Controller("loginController")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login.html")
	public String login(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("loginPageActive", "active");
		map.put("registrationDTO", registrationDTO);
		return ViewConstants.LOGIN;
	}

	@RequestMapping("/processLogin.html")
	public String processLogin(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processLogin(registrationDTO);
			// set the session values...
			setValueInSession(request, AppConstants.USERNAME, registrationDTO.getUserName());
			// TODO, role needs to be enabled...
			// setValueInSession(request, AppConstants.USERTYPE, loadedRegistrationDTO.getUsertypeId());
		}catch(NhanceApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			return login(registrationDTO, request, response, map);
		}
		return welcome(request, response, map);
	}

	@RequestMapping("/forgotPassword.html")
	public String forgotPassword(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("securityQuestionList", loginService.listSecurityQuestions(new SecurityQuestionDTO()));
		map.put("registrationDTO", registrationDTO);
		return ViewConstants.VERIFYSECURITYQUESTION;
	}

	@RequestMapping("/verifySecurityQuestion.html")
	public String verifySecurityQuestion(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.verifySecurityQuestion(registrationDTO);
		}catch(NhanceApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			return forgotPassword(new RegistrationDTO(), request, response, map);
		}
		map.put("registrationDTO", registrationDTO);
		return ViewConstants.FORGOTPASSWORD;
	}

	@RequestMapping("/processForgotPassword.html")
	public String processForgotPassword(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processForgotPassword(registrationDTO);
		}catch(NhanceApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			map.put("registrationDTO", registrationDTO);
			return ViewConstants.FORGOTPASSWORD;
		}
		registrationDTO.setResponseMessage("Password reset success");
		return login(registrationDTO, request, response, map);
	}
	
	@RequestMapping("/signup.html")
	public String signup(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("signupPageActive", "active");
		map.put("registrationDTO", registrationDTO);
		return ViewConstants.SIGNUP;
	}

	@RequestMapping("/processSignup.html")
	public String processSignup(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processSignup(registrationDTO);
		}catch(NhanceApplicationException e){
			handleApplicationExceptionForJson(registrationDTO, e);
			return signup(registrationDTO, request, response, map);
		}
		registrationDTO.setResponseMessage("User registration success");
		return login(registrationDTO, request, response, map);
	}

	@RequestMapping("/enquiry.html")
	public String enquiry(EnquiryFormDTO enquiryFormDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("enquiryPageActive", "active");
		map.put("enquiryFormDTO", enquiryFormDTO);
		return ViewConstants.ENQUIRY;
	}

	@RequestMapping("/processEnquiry.html")
	public String processEnquiry(EnquiryFormDTO enquiryFormDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		try{
			loginService.processEnquiry(enquiryFormDTO);
			enquiryFormDTO = new EnquiryFormDTO();
			enquiryFormDTO.setMessage("Thank you. We will get back to you.");
		}catch(NhanceApplicationException e){
			handleApplicationExceptionForJson(enquiryFormDTO, e);
		}
		return enquiry(enquiryFormDTO, request, response, map);
	}

	@RequestMapping("/feedback.html")
	public String feedback(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("feedbackPageActive", "active");
		return ViewConstants.FEEDBACK;
	}

	@RequestMapping("/processFeedback.html")
	public String processFeedback(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		return ViewConstants.FEEDBACK;
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
}
