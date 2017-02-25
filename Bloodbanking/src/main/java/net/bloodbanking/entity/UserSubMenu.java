package net.bloodbanking.entity;

import java.util.HashSet;
import java.util.Set;

public class UserSubMenu implements java.io.Serializable {

	private static final long serialVersionUID = 4281455346884918735L;
	private Integer subMenuId;
	private String subMenuName;
	private Set<UserTypeMapping> userTypeMappings = new HashSet<UserTypeMapping>(0);

	public Integer getSubMenuId() {
		return this.subMenuId;
	}

	public void setSubMenuId(Integer subMenuId) {
		this.subMenuId = subMenuId;
	}

	public String getSubMenuName() {
		return this.subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public Set<UserTypeMapping> getUserTypeMappings() {
		return this.userTypeMappings;
	}

	public void setUserTypeMappings(Set<UserTypeMapping> userTypeMappings) {
		this.userTypeMappings = userTypeMappings;
	}

}
