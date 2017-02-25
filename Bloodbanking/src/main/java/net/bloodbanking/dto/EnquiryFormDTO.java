package net.bloodbanking.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EnquiryFormDTO extends BaseDTO {
	private Long inqId;
	private StatusMstDTO statusMstDTO;
	@NotEmpty(groups = {validateProcessEnquiry.class})
	private String message;
	@NotNull(groups = {validateProcessEnquiry.class})
	private LocationAddressDTO locationAddressDTO;
	private Date createdDate;
	public Long getInqId() {
		return inqId;
	}
	public void setInqId(Long inqId) {
		this.inqId = inqId;
	}
	public StatusMstDTO getStatusMstDTO() {
		return statusMstDTO;
	}
	public void setStatusMstDTO(StatusMstDTO statusMstDTO) {
		this.statusMstDTO = statusMstDTO;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocationAddressDTO getLocationAddressDTO() {
		return locationAddressDTO;
	}
	public void setLocationAddressDTO(LocationAddressDTO locationAddressDTO) {
		this.locationAddressDTO = locationAddressDTO;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public interface validateProcessEnquiry{}
}
