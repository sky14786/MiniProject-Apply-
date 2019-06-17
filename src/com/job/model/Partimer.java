package com.job.model;

import java.io.Serializable;

public class Partimer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3613349579389110270L;
	private int no;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String gender;
	private String phone;
	private boolean isApply;

	public Partimer(int no, String id, String pw, String name, int age, String gender, String phone, boolean isApply) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.isApply = isApply;
	}

	public boolean getIsApply() {
		return isApply;
	}

	public void setApply(boolean isApply) {
		this.isApply = isApply;
	}

	public Partimer() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Partimer [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", phone=" + phone + ", isApply=" + isApply + "]";
	}

}
