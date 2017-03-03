package net.bloodbanking.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class RegistrationDTO extends BaseDTO implements UserDetails{
	private static final long serialVersionUID = 2220043525853280045L;
	private Long registrationId;
	private StatusMstDTO statusMstDTO;
	@NotNull(groups = {validateProcessSignup.class})
	private Integer bloodGroup;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String birthDate;
	@NotEmpty(groups = {validateProcessSignup.class})
	private String gender;
	@NotEmpty(groups = {validateLoadRegistration.class, validateVerifySecurityQuestion.class, validateProcessSignup.class})
	private String userName;
	@NotEmpty(groups = {validateProcessForgotPassword.class, validateProcessSignup.class})
	private String password;
	@NotEmpty(groups = {validateProcessForgotPassword.class, validateProcessSignup.class})
	private String confirmPassword;
	@NotNull(groups = {validateProcessSignup.class})
	private Long usertypeId;
	@NotNull(groups = {validateVerifySecurityQuestion.class, validateProcessSignup.class})
	private Integer securityQue;
	@NotEmpty(groups = {validateVerifySecurityQuestion.class, validateProcessSignup.class})
	private String answer;
	@NotNull(groups = {validateProcessSignup.class})
	private LocationAddressDTO locationAddressDTO;
	private List<String> privileges;
	private String usertypeName;
	private String bloodGroupName;
	public Long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}
	public StatusMstDTO getStatusMstDTO() {
		return statusMstDTO;
	}
	public void setStatusMstDTO(StatusMstDTO statusMstDTO) {
		this.statusMstDTO = statusMstDTO;
	}
	public Integer getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Long getUsertypeId() {
		return usertypeId;
	}
	public void setUsertypeId(Long usertypeId) {
		this.usertypeId = usertypeId;
	}
	public Integer getSecurityQue() {
		return securityQue;
	}
	public void setSecurityQue(Integer securityQue) {
		this.securityQue = securityQue;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocationAddressDTO getLocationAddressDTO() {
		return locationAddressDTO;
	}
	public void setLocationAddressDTO(LocationAddressDTO locationAddressDTO) {
		this.locationAddressDTO = locationAddressDTO;
	}

	public interface validateLoadRegistration{}

	public interface validateVerifySecurityQuestion{}

	public interface validateProcessForgotPassword{}

	public interface validateProcessSignup{}

	@SuppressWarnings("deprecation")
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority > list = new ArrayList<GrantedAuthority>();
		list.add(new GrantedAuthorityImpl("ROLE"));
		return list;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public List<String> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}
	public String getUsertypeName() {
		return usertypeName;
	}
	public void setUsertypeName(String usertypeName) {
		this.usertypeName = usertypeName;
	}
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
}
