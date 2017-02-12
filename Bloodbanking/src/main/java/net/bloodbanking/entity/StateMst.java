package net.bloodbanking.entity;

import java.io.Serializable;

public class StateMst implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long stateId;
	
	private String stateName;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
