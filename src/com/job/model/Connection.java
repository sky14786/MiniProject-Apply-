package com.job.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Connection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5934914269966134169L;
	private int noticeNo;
	private ArrayList<Resume> resumes;

	public Connection() {
	}

	public Connection(int noticeNo, ArrayList<Resume> resumes) {
		super();
		this.noticeNo = noticeNo;
		this.resumes = resumes;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public ArrayList<Resume> getResumes() {
		return resumes;
	}

	public void setResuems(ArrayList<Resume> resumes) {
		this.resumes = resumes;
	}

	@Override
	public String toString() {
		return "Connection [noticeNo=" + noticeNo + ", resuems=" + resumes + "]";
	}

}