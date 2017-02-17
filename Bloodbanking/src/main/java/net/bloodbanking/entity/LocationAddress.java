package net.bloodbanking.entity;

public class LocationAddress implements java.io.Serializable {

	private static final long serialVersionUID = 8042773452739511687L;
	private Long locationAddressId;
	private int referenceType;
	private String referenceId;
	private String name;
	private String mobileNumber;
	private String emailId;
	private String address;
	private String state;
	private String city;
	private String pincode;

	public LocationAddress() {
	}

	public LocationAddress(int referenceType, String referenceId) {
		this.referenceType = referenceType;
		this.referenceId = referenceId;
	}

	public LocationAddress(int referenceType, String referenceId, String name, String mobileNumber, String emailId,
			String address, String state, String city, String pincode) {
		this.referenceType = referenceType;
		this.referenceId = referenceId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public Long getLocationAddressId() {
		return this.locationAddressId;
	}

	public void setLocationAddressId(Long locationAddressId) {
		this.locationAddressId = locationAddressId;
	}

	public int getReferenceType() {
		return this.referenceType;
	}

	public void setReferenceType(int referenceType) {
		this.referenceType = referenceType;
	}

	public String getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
