package net.bloodbanking.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class FeedbackDTO extends BaseDTO {
	private Long fid;
	@NotEmpty(groups = {validateProcessFeedback.class})
	private String feedback;
	@NotNull(groups = {validateProcessFeedback.class})
	private LocationAddressDTO locationAddressDTO;
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public LocationAddressDTO getLocationAddressDTO() {
		return locationAddressDTO;
	}
	public void setLocationAddressDTO(LocationAddressDTO locationAddressDTO) {
		this.locationAddressDTO = locationAddressDTO;
	}
	public interface validateProcessFeedback{}
}
