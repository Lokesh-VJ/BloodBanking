package net.bloodbanking.dto;

public class BloodBankStockDTO extends BaseDTO{
	private String bloodBankName;
	private String bloodGroupName;
	private Long donotedBloodUnits;
	private Long suppliedBloodUnits;
	private Long rejectedBloodUnits;
	private Long pendingBloodUnits;
	private Long totalAvailableBloodUnits;
	public String getBloodBankName() {
		return bloodBankName;
	}
	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
	public Long getDonotedBloodUnits() {
		return donotedBloodUnits;
	}
	public void setDonotedBloodUnits(Long donotedBloodUnits) {
		this.donotedBloodUnits = donotedBloodUnits;
	}
	public Long getSuppliedBloodUnits() {
		return suppliedBloodUnits;
	}
	public void setSuppliedBloodUnits(Long suppliedBloodUnits) {
		this.suppliedBloodUnits = suppliedBloodUnits;
	}
	public Long getRejectedBloodUnits() {
		return rejectedBloodUnits;
	}
	public void setRejectedBloodUnits(Long rejectedBloodUnits) {
		this.rejectedBloodUnits = rejectedBloodUnits;
	}
	public Long getPendingBloodUnits() {
		return pendingBloodUnits;
	}
	public void setPendingBloodUnits(Long pendingBloodUnits) {
		this.pendingBloodUnits = pendingBloodUnits;
	}
	public Long getTotalAvailableBloodUnits() {
		return totalAvailableBloodUnits;
	}
	public void setTotalAvailableBloodUnits(Long totalAvailableBloodUnits) {
		this.totalAvailableBloodUnits = totalAvailableBloodUnits;
	}
}
