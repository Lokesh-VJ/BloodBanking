package net.bloodbanking.entity;

import java.io.Serializable;
import java.util.Date;

public class BloodRequest implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long brId;
	
	private Long regId;
	
	private Long bId;
	
	private Long locationId;
	
	private Long cityId;
	
	private String contactNo;
	
	private String bgroup;
	
	private String qty;
	
	private Long status;
	
   public Long getBrId() {
		return brId;
	}

	public void setBrId(Long brId) {
		this.brId = brId;
	}

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public Long getbId() {
		return bId;
	}

	public void setbId(Long bId) {
		this.bId = bId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getBgroup() {
		return bgroup;
	}

	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

private Date ddate;
	
}
