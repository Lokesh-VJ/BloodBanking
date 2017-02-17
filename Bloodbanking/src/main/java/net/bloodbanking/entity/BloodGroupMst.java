package net.bloodbanking.entity;

public class BloodGroupMst implements java.io.Serializable {

	private static final long serialVersionUID = -5897839229960798981L;
	private Integer bloodGroupId;
	private String bloodGroupName;

	public BloodGroupMst() {
	}

	public BloodGroupMst(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}

	public Integer getBloodGroupId() {
		return this.bloodGroupId;
	}

	public void setBloodGroupId(Integer bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getBloodGroupName() {
		return this.bloodGroupName;
	}

	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}

}
