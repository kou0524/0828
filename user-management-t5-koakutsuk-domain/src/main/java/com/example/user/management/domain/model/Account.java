package com.example.user.management.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userID;
	private String userName;
	private String password;
	@DateTimeFormat(pattern = "yyyy/MM/dd") 
	private Date birthday;
	private String address;
	private List<String> roles;
	private String role;
	private String phoneNumber;
	private String state;
	private String lastUpdateTime;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	/**@Override
	public String toString() {
		return "Account [UserID=" + UserID + ", Password=" + Password
				+ "]";
	}**/
}