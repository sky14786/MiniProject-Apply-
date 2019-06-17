package com.job.model;

import java.io.Serializable;

public class Resume implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -5678515146937211275L;
	private int userNo; // 고유번호

	private String name;
	private int age;
	private String gender;
	private String phone;

	private String academic; // 학력
	private String career; // 경력
	private String typeOccup; // 직종
	private String periodType; // 기간
	private String dow; // 요일
	private String time; // 시간
	private String region; // 지역

	public Resume() {
	}

	public Resume(int userNo, String name, int age, String gender, String phone, String academic, String career,
			String typeOccup, String periodType, String dow, String time, String region) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.academic = academic;
		this.career = career;
		this.typeOccup = typeOccup;
		this.periodType = periodType;
		this.dow = dow;
		this.time = time;
		this.region = region;
		this.userNo = userNo;
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

	public String getAcademic() {
		return academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getTypeOccup() {
		return typeOccup;
	}

	public void setTypeOccup(String typeOccup) {
		this.typeOccup = typeOccup;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getDow() {
		return dow;
	}

	public void setDow(String dow) {
		this.dow = dow;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Resume [name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", academic="
				+ academic + ", career=" + career + ", typeOccup=" + typeOccup + ", periodType=" + periodType + ", dow="
				+ dow + ", time=" + time + ", region=" + region + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Resume temp = (Resume) obj;
		boolean isEquals = false;
		if (this.academic.equals(temp.getAcademic()) && this.career.equals(temp.getCareer())
				&& this.dow.equals(temp.getDow()) && this.gender.equals(temp.getGender())
				&& this.name.equals(temp.getName()) && this.periodType.equals(temp.periodType)
				&& this.phone.equals(temp.getPhone()) && this.region.equals(temp.getRegion())
				&& this.time.equals(temp.time) && this.typeOccup.equals(temp.typeOccup) && this.age == temp.getAge()
				&& this.userNo == temp.getUserNo()) {
			isEquals = true;
		}
		return isEquals;
	}

}