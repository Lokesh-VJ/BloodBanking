package net.bloodbanking.entity;

import java.util.HashSet;
import java.util.Set;

public class UserLeftMenu implements java.io.Serializable {

	private static final long serialVersionUID = -7384191403974061968L;
	private Integer leftMenuId;
	private String leftMenuName;
	private String leftMenuDescription;
	private Set<UserTypeMapping> userTypeMappings = new HashSet<UserTypeMapping>(0);

	public Integer getLeftMenuId() {
		return this.leftMenuId;
	}

	public void setLeftMenuId(Integer leftMenuId) {
		this.leftMenuId = leftMenuId;
	}

	public String getLeftMenuName() {
		return this.leftMenuName;
	}

	public void setLeftMenuName(String leftMenuName) {
		this.leftMenuName = leftMenuName;
	}

	public String getLeftMenuDescription() {
		return this.leftMenuDescription;
	}

	public void setLeftMenuDescription(String leftMenuDescription) {
		this.leftMenuDescription = leftMenuDescription;
	}

	public Set<UserTypeMapping> getUserTypeMappings() {
		return this.userTypeMappings;
	}

	public void setUserTypeMappings(Set<UserTypeMapping> userTypeMappings) {
		this.userTypeMappings = userTypeMappings;
	}

}
