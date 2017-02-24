package net.bloodbanking.dto;

import java.util.Date;

public class RegistrationDTO extends BaseDTO {
	private Long registrationId;
	private StatusMstDTO statusMstDTO;
	private Integer bloodGroup;
	private Date birthDate;
	private String gender;
	private String userName;
	private String password;
	private Long usertypeId;
	private String securityQue;
	private String answer;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
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
	public Long getUsertypeId() {
		return usertypeId;
	}
	public void setUsertypeId(Long usertypeId) {
		this.usertypeId = usertypeId;
	}
	public String getSecurityQue() {
		return securityQue;
	}
	public void setSecurityQue(String securityQue) {
		this.securityQue = securityQue;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
