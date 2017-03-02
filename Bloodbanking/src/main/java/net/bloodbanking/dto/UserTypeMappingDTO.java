package net.bloodbanking.dto;

public class UserTypeMappingDTO extends BaseDTO {
	private String leftMenuName;
	private String leftMenuDescription;
	private String subMenuName;
	public String getLeftMenuName() {
		return leftMenuName;
	}
	public void setLeftMenuName(String leftMenuName) {
		this.leftMenuName = leftMenuName;
	}
	public String getLeftMenuDescription() {
		return leftMenuDescription;
	}
	public void setLeftMenuDescription(String leftMenuDescription) {
		this.leftMenuDescription = leftMenuDescription;
	}
	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
}
