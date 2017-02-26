package net.bloodbanking.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationDTO extends BaseDTO {
	private Long registrationId;
	private StatusMstDTO statusMstDTO;
	@NotNull(groups = {validateProcessSignup.class})
	private Integer bloodGroup;
    @NotEmpty(groups = {validateProcessSignup.class})
	private String birthDate;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String gender;
	@NotEmpty(groups = {validateLoadRegistration.class, validateProcessLogin.class, validateVerifySecurityQuestion.class, validateProcessSignup.class})
	private String userName;
	@NotEmpty(groups = {validateProcessLogin.class, validateProcessForgotPassword.class, validateProcessSignup.class})
	private String password;
	@NotEmpty(groups = {validateProcessForgotPassword.class, validateProcessSignup.class})
	private String confirmPassword;
	@NotNull(groups = {validateProcessSignup.class})
	private Long usertypeId;
	@NotNull(groups = {validateVerifySecurityQuestion.class, validateProcessSignup.class})
	private Integer securityQue;
	@NotEmpty(groups = {validateVerifySecurityQuestion.class, validateProcessSignup.class})
	private String answer;
	@NotNull(groups = {validateProcessSignup.class})
	private LocationAddressDTO locationAddressDTO;
	public Long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}
	public StatusMstDTO getStatusMstDTO() {
		return statusMstDTO;
	}
	public void setStatusMstDTO(StatusMstDTO statusMstDTO) {
		this.statusMstDTO = statusMstDTO;
	}
	public Integer getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Long getUsertypeId() {
		return usertypeId;
	}
	public void setUsertypeId(Long usertypeId) {
		this.usertypeId = usertypeId;
	}
	public Integer getSecurityQue() {
		return securityQue;
	}
	public void setSecurityQue(Integer securityQue) {
		this.securityQue = securityQue;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocationAddressDTO getLocationAddressDTO() {
		return locationAddressDTO;
	}
	public void setLocationAddressDTO(LocationAddressDTO locationAddressDTO) {
		this.locationAddressDTO = locationAddressDTO;
	}

	public interface validateLoadRegistration{}
	
	public interface validateProcessLogin{}
	
	public interface validateVerifySecurityQuestion{}
	
	public interface validateProcessForgotPassword{}
	
	public interface validateProcessSignup{}
}
