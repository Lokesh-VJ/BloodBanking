package net.bloodbanking.entity;

import java.util.Date;

public class DonorBloodbankMapping implements java.io.Serializable {

	private static final long serialVersionUID = -98800248960701044L;
	private DonorBloodbankMappingId id;
	private int bloodUnits;
	private Date createdDate;

	public DonorBloodbankMapping() {
	}

	public DonorBloodbankMapping(DonorBloodbankMappingId id, int bloodUnits, Date createdDate) {
		this.id = id;
		this.bloodUnits = bloodUnits;
		this.createdDate = createdDate;
	}

	public DonorBloodbankMappingId getId() {
		return this.id;
	}

	public void setId(DonorBloodbankMappingId id) {
		this.id = id;
	}

	public int getBloodUnits() {
		return this.bloodUnits;
	}

	public void setBloodUnits(int bloodUnits) {
		this.bloodUnits = bloodUnits;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
