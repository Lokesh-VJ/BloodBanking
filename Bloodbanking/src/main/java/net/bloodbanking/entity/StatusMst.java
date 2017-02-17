package net.bloodbanking.entity;

import java.util.HashSet;
import java.util.Set;

public class StatusMst implements java.io.Serializable {

	private static final long serialVersionUID = -2060098170961189780L;
	private Integer status;
	private String description;
	private Set<Registration> registrations = new HashSet<Registration>(0);
	private Set<EnquiryForm> enquiryForms = new HashSet<EnquiryForm>(0);

	public StatusMst() {
	}

	public StatusMst(String description) {
		this.description = description;
	}

	public StatusMst(String description, Set<Registration> registrations, Set<EnquiryForm> enquiryForms) {
		this.description = description;
		this.registrations = registrations;
		this.enquiryForms = enquiryForms;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	public Set<EnquiryForm> getEnquiryForms() {
		return this.enquiryForms;
	}

	public void setEnquiryForms(Set<EnquiryForm> enquiryForms) {
		this.enquiryForms = enquiryForms;
	}

}
