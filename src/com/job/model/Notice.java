package com.job.model;

import java.io.Serializable;

public class Notice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1560382784784307437L;
	private int bNo;
	private String bName;
	private double pay;
	private String timeTotime;
	private String etc;
	private String category;
	private String periodType, timeType;
	private String bKeyword1, bKeyword2, bKeyword3;
	private String addr;

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Notice() {
	}

	public Notice(int bNo, String bName, double pay, String timeTotime, String category, String addr, String periodType,
			String timeType, String bKeyword1, String bKeyword2, String bKeyword3, String etc) {
		super();
		this.bNo = bNo;
		this.bName = bName;
		this.pay = pay;
		this.timeTotime = timeTotime;
		this.etc = etc;
		this.category = category;
		this.bKeyword1 = bKeyword1;
		this.bKeyword2 = bKeyword2;
		this.bKeyword3 = bKeyword3;
		this.periodType = periodType;
		this.timeType = timeType;
		this.addr = addr;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public String getTimeTotime() {
		return timeTotime;
	}

	public void setTimeTotime(String timeTotime) {
		this.timeTotime = timeTotime;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getbKeyword1() {
		return bKeyword1;
	}

	public void setbKeyword1(String bKeyword1) {
		this.bKeyword1 = bKeyword1;
	}

	public String getbKeyword2() {
		return bKeyword2;
	}

	public void setbKeyword2(String bKeyword2) {
		this.bKeyword2 = bKeyword2;
	}

	public String getbKeyword3() {
		return bKeyword3;
	}

	public void setbKeyword3(String bKeyword3) {
		this.bKeyword3 = bKeyword3;
	}

	@Override
	public String toString() {
		return "Notice [bNo=" + bNo + ", bName=" + bName + ", pay=" + pay + ", timeTotime=" + timeTotime + ", etc="
				+ etc + ", category=" + category + ", periodType=" + periodType + ", timeType=" + timeType
				+ ", bKeyword1=" + bKeyword1 + ", bKeyword2=" + bKeyword2 + ", bKeyword3=" + bKeyword3 + ", addr="
				+ addr + "]";
	}

}
