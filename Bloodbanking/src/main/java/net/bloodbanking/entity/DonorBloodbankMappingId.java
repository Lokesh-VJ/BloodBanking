package net.bloodbanking.entity;

public class DonorBloodbankMappingId implements java.io.Serializable {

	private static final long serialVersionUID = 6219633232662567453L;
	private long donorId;
	private long bloodbankId;

	public long getDonorId() {
		return this.donorId;
	}

	public void setDonorId(long donorId) {
		this.donorId = donorId;
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
		if (!(other instanceof DonorBloodbankMappingId))
			return false;
		DonorBloodbankMappingId castOther = (DonorBloodbankMappingId) other;

		return (this.getDonorId() == castOther.getDonorId()) && (this.getBloodbankId() == castOther.getBloodbankId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDonorId();
		result = 37 * result + (int) this.getBloodbankId();
		return result;
	}

}
