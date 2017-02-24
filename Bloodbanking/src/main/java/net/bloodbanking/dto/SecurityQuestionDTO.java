package net.bloodbanking.dto;

public class SecurityQuestionDTO extends BaseDTO {

	private Integer securityQuestionId;
	
	private String securityQuestion;

	public Integer getSecurityQuestionId() {
		return securityQuestionId;
	}

	public void setSecurityQuestionId(Integer securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

}
