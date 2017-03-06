package net.bloodbanking.dto;

public class BloodDonationDTO extends BaseDTO{
	private Long donorBloodbankMappingId;
	private Long donorId;
	private String donorUserName;
	private String donorName;
	private String donorAddress;
	private Long bloodBankId;
	private String bloodBankName;
	private Integer bloodGroupId;
	private String bloodGroupName;
	private Integer bloodUnits;
	private String bloodBankAddress;
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
	public String getBloodBankAddress() {
		return bloodBankAddress;
	}
	public void setBloodBankAddress(String bloodBankAddress) {
		this.bloodBankAddress = bloodBankAddress;
	}
	public Integer getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(Integer bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	public Long getDonorBloodbankMappingId() {
		return donorBloodbankMappingId;
	}
	public void setDonorBloodbankMappingId(Long donorBloodbankMappingId) {
		this.donorBloodbankMappingId = donorBloodbankMappingId;
	}
	public String getDonorAddress() {
		return donorAddress;
	}
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}
}
