package net.bloodbanking.entity;

import java.util.Date;

public class PatientBloodbankMapping implements java.io.Serializable {

	private static final long serialVersionUID = -6399932713011837638L;
	private PatientBloodbankMappingId id;
	private int bloodUnits;
	private int status;
	private Date createdDate;

	public PatientBloodbankMappingId getId() {
		return this.id;
	}

	public void setId(PatientBloodbankMappingId id) {
		this.id = id;
	}

	public int getBloodUnits() {
		return this.bloodUnits;
	}

	public void setBloodUnits(int bloodUnits) {
		this.bloodUnits = bloodUnits;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
