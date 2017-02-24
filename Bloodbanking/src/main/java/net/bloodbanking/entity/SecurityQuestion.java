package net.bloodbanking.entity;

import java.io.Serializable;

public class SecurityQuestion implements Serializable {

	private static final long serialVersionUID = -2050790779040249153L;
	private Integer securityQuestionId;
	private String securityQuestion;

	public Integer getSecurityQuestionId() {
		return this.securityQuestionId;
	}

	public void setSecurityQuestionId(Integer securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	public String getSecurityQuestion() {
		return this.securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

}
