package net.bloodbanking.entity;

import java.util.Date;

public class Registration implements java.io.Serializable {

	private static final long serialVersionUID = -8112733508669883190L;
	private Long registrationId;
	private StatusMst statusMst;
	private int bloodGroup;
	private Date birthDate;
	private String gender;
	private String userName;
	private String password;
	private long usertypeId;
	private int securityQue;
	private String answer;

	public Long getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public StatusMst getStatusMst() {
		return this.statusMst;
	}

	public void setStatusMst(StatusMst statusMst) {
		this.statusMst = statusMst;
	}

	public int getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(int bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUsertypeId() {
		return this.usertypeId;
	}

	public void setUsertypeId(long usertypeId) {
		this.usertypeId = usertypeId;
	}

	public int getSecurityQue() {
		return this.securityQue;
	}

	public void setSecurityQue(int securityQue) {
		this.securityQue = securityQue;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
