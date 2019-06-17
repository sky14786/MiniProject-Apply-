package com.job.model;

import java.io.Serializable;

public class Owner implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7768027846107587263L;
 	private int no;
	private String id, pw, name, bNumber, addr;
	private boolean isApply;

	public boolean isApply() {
		return isApply;
	}

	public void setApply(boolean isApply) {
		this.isApply = isApply;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Owner() {
	}

	public Owner(int no, String id, String pw, String name, String bNumber, String addr, boolean isApply) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.bNumber = bNumber;
		this.addr = addr;
		this.isApply = isApply;
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

	public String getbNumber() {
		return bNumber;
	}

	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Owner [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", bNumber=" + bNumber + ", addr="
				+ addr + ", isApply=" + isApply + "]";
	}

}
