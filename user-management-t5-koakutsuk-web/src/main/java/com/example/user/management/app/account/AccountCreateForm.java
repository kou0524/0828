package com.example.user.management.app.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

//アカウンﾄ作成用のDTOクラス
public class AccountCreateForm implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message="1～255文字以内で入力してください")
	@Size(min = 1, max = 255,message="1～255文字以内で入力してください")
	private String userID;

	@NotEmpty(message="1～60文字以内で入力してください")
	@Size(min = 1, max = 30,message="1～60文字以内で入力してください")
	private String userName;

	@NotNull(message="6文字以上のパスワードを入力してください")
	@Size(min = 6,message="6文字以上のパスワードを入力してください")
	private String password;

	@NotNull(message="6文字以上のパスワードを入力してください")
	@Size(min = 6,message="6文字以上のパスワードを入力してください")
	private String confirmPassword;

	@NotNull(message="yyyy/MM/dd形式で生年月日を入力してください")
	@DateTimeFormat(pattern = "yyyy/MM/dd") 
	private Date birthday;

	@NotEmpty(message="1～60文字以内で入力してください")
	@Size(min = 1, max = 60,message="1～60文字以内で入力してください")
	private String address;

	@NotNull(message="10桁もしくは11桁の半角数字で入力してください")
	@Size(min = 10, max = 11,message="10桁もしくは11桁の半角数字で入力してください")
	private String phoneNumber;

	@NotEmpty(message="管理者か一般ユーザを選択してください")
	private ArrayList<String> roles;

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

	/**@Override
	public String toString() {
		return "Account [UserID=" + UserID + ", Password=" + Password
				+ "]";
	}**/
}