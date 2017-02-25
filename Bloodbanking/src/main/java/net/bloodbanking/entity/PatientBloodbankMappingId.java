package net.bloodbanking.entity;

public class PatientBloodbankMappingId implements java.io.Serializable {

	private static final long serialVersionUID = -5179674345877330566L;
	private long patientId;
	private long bloodbankId;

	public long getPatientId() {
		return this.patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long getBloodbankId() {
		return this.bloodbankId;
	}

	public void setBloodbankId(long bloodbankId) {
		this.bloodbankId = bloodbankId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PatientBloodbankMappingId))
			return false;
		PatientBloodbankMappingId castOther = (PatientBloodbankMappingId) other;

		return (this.getPatientId() == castOther.getPatientId())
				&& (this.getBloodbankId() == castOther.getBloodbankId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getPatientId();
		result = 37 * result + (int) this.getBloodbankId();
		return result;
	}

}
