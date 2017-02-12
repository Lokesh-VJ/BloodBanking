package net.bloodbanking.entity;

import java.io.Serializable;

public class CityMst implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long cityId;
	
	private Long stateId;
	
	private String cityName;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
