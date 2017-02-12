package net.bloodbanking.entity;

import java.io.Serializable;

public class LocationMst implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long locationId;
	
	private Long cityId;
	
	private String locationName;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	
	
}
