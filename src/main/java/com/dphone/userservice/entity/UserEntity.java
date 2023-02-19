package com.dphone.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// < User Database Entity >

@Entity
@Table(name="User_Data")
public class UserEntity {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	private String firstName;
	private String lastName;
	private String address;
	private String userName;
	private String password;
	private String status;
	private String email;
	private String mobile;
	private String refcode;
	private String roles;
	private int referralPoints;

	
	public int getReferralPoints() {
		return referralPoints;
	}
	public void setReferralPoints(int referralPoints) {
		this.referralPoints = referralPoints;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getRefcode() {
		return refcode;
	}
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(int userId, String firstName, String lastName, String address, String userName, String password,
			String status, String email, String mobile, String refcode, String roles, int referralPoints) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.email = email;
		this.mobile = mobile;
		this.refcode = refcode;
		this.roles = roles;
		this.referralPoints = referralPoints;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", userName=" + userName + ", password=" + password + ", status=" + status + ", email="
				+ email + ", mobile=" + mobile + ", refcode=" + refcode + ", roles=" + roles + ", referralPoints="
				+ referralPoints + "]";
	}
	
	
	
	
}
