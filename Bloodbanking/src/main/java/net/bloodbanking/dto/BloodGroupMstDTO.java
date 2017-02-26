package net.bloodbanking.dto;

public class BloodGroupMstDTO extends BaseDTO {
	private Integer bloodGroupId;
	private String bloodGroupName;
	public Integer getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(Integer bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}	
}
