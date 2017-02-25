package net.bloodbanking.entity;

public class UserTypeMapping implements java.io.Serializable {

	private static final long serialVersionUID = 5440520938477951553L;
	private Integer privilegeId;
	private UserLeftMenu userLeftMenu;
	private UserSubMenu userSubMenu;
	private UserTypeMst userTypeMst;

	public Integer getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public UserLeftMenu getUserLeftMenu() {
		return this.userLeftMenu;
	}

	public void setUserLeftMenu(UserLeftMenu userLeftMenu) {
		this.userLeftMenu = userLeftMenu;
	}

	public UserSubMenu getUserSubMenu() {
		return this.userSubMenu;
	}

	public void setUserSubMenu(UserSubMenu userSubMenu) {
		this.userSubMenu = userSubMenu;
	}

	public UserTypeMst getUserTypeMst() {
		return this.userTypeMst;
	}

	public void setUserTypeMst(UserTypeMst userTypeMst) {
		this.userTypeMst = userTypeMst;
	}

}
