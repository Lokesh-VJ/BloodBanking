package net.bloodbanking.entity;

import java.io.Serializable;
import java.util.Date;

public class InquiryForm implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long inqId;
	
	private String name;
	
	private String inquiry;
	
	private String address;
	
	private String phoneNo;
	
	private String email;
	
	private Date date;
	
	private Long flag;

	public Long getInqId() {
		return inqId;
	}

	public void setInqId(Long inqId) {
		this.inqId = inqId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}
	
	
  
	
}
