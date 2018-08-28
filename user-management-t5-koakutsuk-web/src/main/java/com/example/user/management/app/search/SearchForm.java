package com.example.user.management.app.search;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class SearchForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "[0-9]*")
	private String userID;

	@Size(min = 0, max = 30)
	private String userName;

	@DateTimeFormat(pattern = "yyyy/MM/dd") 
	private Date birthday;

	@Size(min = 0, max = 60)
	private String address;

	@Pattern(regexp = "[0-9]*")
	private String phoneNumber;
	
	private String state;
	
	private String role;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



}
