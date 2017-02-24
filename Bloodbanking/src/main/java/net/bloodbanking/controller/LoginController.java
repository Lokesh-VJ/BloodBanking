package net.bloodbanking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bloodbanking.constants.AppConstants;
import net.bloodbanking.constants.ViewConstants;
import net.bloodbanking.dto.RegistrationDTO;
import net.bloodbanking.dto.SecurityQuestionDTO;
import net.bloodbanking.service.LoginService;

@Controller("loginController")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login.html")
	public String login(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("loginPageActive", "active");
		return ViewConstants.LOGIN;
	}

	@RequestMapping("/processLogin.html")
	public String processLogin(RegistrationDTO registrationDTO, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		String userName = registrationDTO.getUserName();
		String password = registrationDTO.getPassword();
		
		loginService.loadRegistration(registrationDTO);
		if(null == registrationDTO 
				|| !password.equals(registrationDTO.getPassword())){
			// if user doesnot exists or password doesnot matches, go back to login...
			map.put(AppConstants.ERROR_MSG_KEY, "Username/password not valid");
			return login(request, response, map);
		}

		if(registrationDTO.getStatusMstDTO().getStatus() != AppConstants.ACTIVE){
			// if user not active, do not allow to login...
			map.put(AppConstants.ERROR_MSG_KEY, "User not active, contact admin");
			return login(request, response, map);
		}

		// set the session values...
		setValueInSession(request, AppConstants.USERNAME, registrationDTO.getUserName());
		// TODO, role needs to be enabled...
		// setValueInSession(request, AppConstants.USERTYPE, loadedRegistrationDTO.getUsertypeId());

		return welcome(request, response, map);
	}

	@RequestMapping("/forgotPassword.html")
	public String forgotPassword(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("securityQuestionList", loginService.listSecurityQuestions(new SecurityQuestionDTO()));
		return ViewConstants.VERIFYSECURITYQUESTION;
	}

	@RequestMapping("/verifySecurityQuestion.html")
	public String verifySecurityQuestion(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("loginPageActive", "active");
		return ViewConstants.FORGOTPASSWORD;
	}

	@RequestMapping("/processForgotPassword.html")
	public String processForgotPassword(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		return ViewConstants.FORGOTPASSWORD;
	}

	@RequestMapping("/signup.html")
	public String signup(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("signupPageActive", "active");
		return ViewConstants.SIGNUP;
	}

	@RequestMapping("/processSignup.html")
	public String processSignup(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		return ViewConstants.SIGNUP;
	}

	@RequestMapping("/enquiry.html")
	public String enquiry(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		map.put("enquiryPageActive", "active");
		return ViewConstants.ENQUIRY;
	}

	@RequestMapping("/processEnquiry.html")
	public String processEnquiry(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		return ViewConstants.ENQUIRY;
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
