package com.example.user.management.domain.model;


import java.io.Serializable;
import java.util.ArrayList;

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;


	private String userID;
	private String role;
	private ArrayList<String> roles;//RoleServeice用
	
	
	public ArrayList<String> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
