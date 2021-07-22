package com.ibs.miniproject.cart.model;

public class RegisterModel {
	private String name;
	private String userName;
	private String password;
	private String profession;
	private String gender;
	private String datefBirth;
	private String passwordConfirm;
	private int userQuantity;
	
	
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
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDatefBirth() {
		return datefBirth;
	}
	public void setDatefBirth(String datefBirth) {
		this.datefBirth = datefBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public int getUserQuantity() {
		return userQuantity;
	}
	public void setUserQuantity(int userQuantity) {
		this.userQuantity = userQuantity;
	}

}
