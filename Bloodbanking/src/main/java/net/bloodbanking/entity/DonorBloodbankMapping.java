package net.bloodbanking.entity;

import java.util.Date;

public class DonorBloodbankMapping implements java.io.Serializable {

	private static final long serialVersionUID = -98800248960701044L;
	private long donorBloodbankMappingId;
	private long donorId;
	private long bloodbankId;
	private int bloodUnits;
	private Date createdDate;
	public long getDonorBloodbankMappingId() {
		return donorBloodbankMappingId;
	}
	public void setDonorBloodbankMappingId(long donorBloodbankMappingId) {
		this.donorBloodbankMappingId = donorBloodbankMappingId;
	}
	public long getDonorId() {
		return donorId;
	}
	public void setDonorId(long donorId) {
		this.donorId = donorId;
	}
	public long getBloodbankId() {
		return bloodbankId;
	}
	public void setBloodbankId(long bloodbankId) {
		this.bloodbankId = bloodbankId;
	}
	public int getBloodUnits() {
		return bloodUnits;
	}
	public void setBloodUnits(int bloodUnits) {
		this.bloodUnits = bloodUnits;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
