package net.bloodbanking.entity;

import java.io.Serializable;

public class Feedback implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long fId;
	
	private String name;

	private String email;

	private String feedback;

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}


