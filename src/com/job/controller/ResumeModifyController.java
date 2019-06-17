package com.job.controller;

import java.util.ArrayList;

import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class ResumeModifyController {

	private int userNo;
	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private LoadSave dao = LoadSave.getDao();

	
	//이력서 수정내역 저장
	public void modifyResume(String name, int age, String gender, String phoneNum, String academic, String career,
			String typeOccup, String periodType, String dow, String time, String region) {
		userNo = dao.getNowUser();
		resumes = dao.loadResume();
		for (int i = 0; i < resumes.size(); i++) {
			if (resumes.get(i).getUserNo() == userNo) {
				resumes.set(i, new Resume(userNo, name, age, gender, phoneNum, academic, career, typeOccup, periodType,
						dow, time, region));
				dao.saveResume(resumes);
				break;
			}
		}
	}
}
