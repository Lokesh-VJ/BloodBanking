package net.bloodbanking.entity;

import java.io.Serializable;

public class UsertypeMst implements Serializable {

	private static final long serialVersionUID = 845720660513814694L;

	private Long uId;
	
	private String uType;

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	
}
