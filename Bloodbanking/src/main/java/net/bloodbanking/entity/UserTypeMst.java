package net.bloodbanking.entity;

import java.util.HashSet;
import java.util.Set;

public class UserTypeMst implements java.io.Serializable {

	private static final long serialVersionUID = 8938800143450319736L;
	private Integer usertypeId;
	private String usertypeName;
	private Set<UserTypeMapping> userTypeMappings = new HashSet<UserTypeMapping>(0);

	public UserTypeMst() {
	}

	public UserTypeMst(String usertypeName) {
		this.usertypeName = usertypeName;
	}

	public UserTypeMst(String usertypeName, Set<UserTypeMapping> userTypeMappings) {
		this.usertypeName = usertypeName;
		this.userTypeMappings = userTypeMappings;
	}

	public Integer getUsertypeId() {
		return this.usertypeId;
	}

	public void setUsertypeId(Integer usertypeId) {
		this.usertypeId = usertypeId;
	}

	public String getUsertypeName() {
		return this.usertypeName;
	}

	public void setUsertypeName(String usertypeName) {
		this.usertypeName = usertypeName;
	}

	public Set<UserTypeMapping> getUserTypeMappings() {
		return this.userTypeMappings;
	}

	public void setUserTypeMappings(Set<UserTypeMapping> userTypeMappings) {
		this.userTypeMappings = userTypeMappings;
	}

}
