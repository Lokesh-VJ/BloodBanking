package net.bloodbanking.dto;

public class BloodRequestDTO extends BaseDTO{
	private Long patientBloodbankMappingId;
	private Long patientId;
	private String patientUserName;
	private String patientName;
	private String patientAddress;
	private Long bloodBankId;
	private String bloodBankName;
	private Integer bloodGroupId;
	private String bloodGroupName;
	private Integer bloodUnits;
	private String bloodBankAddress;
	private String requestedDate;
	private Integer status;
	private String statusStr;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientUserName() {
		return patientUserName;
	}
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public Long getBloodBankId() {
		return bloodBankId;
	}
	public void setBloodBankId(Long bloodBankId) {
		this.bloodBankId = bloodBankId;
	}
	public String getBloodBankName() {
		return bloodBankName;
	}
	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}
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
	public Integer getBloodUnits() {
		return bloodUnits;
	}
	public void setBloodUnits(Integer bloodUnits) {
		this.bloodUnits = bloodUnits;
	}
	public String getBloodBankAddress() {
		return bloodBankAddress;
	}
	public void setBloodBankAddress(String bloodBankAddress) {
		this.bloodBankAddress = bloodBankAddress;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public Long getPatientBloodbankMappingId() {
		return patientBloodbankMappingId;
	}
	public void setPatientBloodbankMappingId(Long patientBloodbankMappingId) {
		this.patientBloodbankMappingId = patientBloodbankMappingId;
	}
}
