package net.bloodbanking.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import net.bloodbanking.dto.EnquiryFormDTO.validateProcessEnquiry;
import net.bloodbanking.dto.FeedbackDTO.validateProcessFeedback;
import net.bloodbanking.dto.RegistrationDTO.validateProcessSignup;

public class LocationAddressDTO extends BaseDTO {
	private Long locationAddressId;
	private Integer referenceType;
	private String referenceId;
	@NotEmpty(groups = {validateProcessSignup.class, validateProcessEnquiry.class, validateProcessFeedback.class})
	private String name;
	@NotEmpty(groups = {validateProcessSignup.class, validateProcessEnquiry.class})
	private String mobileNumber;
	@Email
	@NotEmpty(groups = {validateProcessSignup.class, validateProcessEnquiry.class, validateProcessFeedback.class})
	private String emailId;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String address;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String state;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String city;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String pincode;
	public Long getLocationAddressId() {
		return locationAddressId;
	}
	public void setLocationAddressId(Long locationAddressId) {
		this.locationAddressId = locationAddressId;
	}
	public Integer getReferenceType() {
		return referenceType;
	}
	public void setReferenceType(Integer referenceType) {
		this.referenceType = referenceType;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
