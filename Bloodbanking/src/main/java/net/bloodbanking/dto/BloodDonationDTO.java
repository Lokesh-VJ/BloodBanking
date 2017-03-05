package net.bloodbanking.dto;

public class BloodDonationDTO extends BaseDTO{
	private Long donorId;
	private String donorUserName;
	private String donorName;
	private Long bloodBankId;
	private String bloodBankName;
	private String bloodGroupName;
	private Integer bloodUnits;
	private String donatedDate;
	public Long getDonorId() {
		return donorId;
	}
	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	public Long getBloodBankId() {
		return bloodBankId;
	}
	public void setBloodBankId(Long bloodBankId) {
		this.bloodBankId = bloodBankId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
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
	public Integer getBloodUnits() {
		return bloodUnits;
	}
	public void setBloodUnits(Integer bloodUnits) {
		this.bloodUnits = bloodUnits;
	}
	public String getDonatedDate() {
		return donatedDate;
	}
	public void setDonatedDate(String donatedDate) {
		this.donatedDate = donatedDate;
	}
	public String getDonorUserName() {
		return donorUserName;
	}
	public void setDonorUserName(String donorUserName) {
		this.donorUserName = donorUserName;
	}
}
