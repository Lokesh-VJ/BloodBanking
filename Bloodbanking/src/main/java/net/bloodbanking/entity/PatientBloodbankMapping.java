package net.bloodbanking.entity;

import java.util.Date;

public class PatientBloodbankMapping implements java.io.Serializable {

	private static final long serialVersionUID = -6399932713011837638L;
	private long patientBloodbankMappingId;
	private long patientId;
	private long bloodbankId;
	private int bloodUnits;
	private int status;
	private Date createdDate;
	public long getPatientBloodbankMappingId() {
		return patientBloodbankMappingId;
	}
	public void setPatientBloodbankMappingId(long patientBloodbankMappingId) {
		this.patientBloodbankMappingId = patientBloodbankMappingId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
