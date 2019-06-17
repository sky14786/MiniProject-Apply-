package com.job.controller;

import java.util.ArrayList;

import com.job.model.Partimer;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class ResumeRegisterController {
	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private ArrayList<Partimer> parttimers = new ArrayList<Partimer>();
	private int userNo = 0;
	private LoadSave dao = LoadSave.getDao();

	public ResumeRegisterController() {}

	public ResumeRegisterController(int userNo, ArrayList<Partimer> parttimers) {
		this.userNo = userNo;
		this.parttimers = parttimers;
	}
	
	//이력서 추가하기
	public void addResume(String name, int age, String gender, String phoneNum, String academic, String career,
			String typeOccup, String periodType, String dow, String time, String region) {
		userNo = dao.getNowUser();
		resumes = dao.loadResume();
		parttimers = dao.loadPartimer();
		resumes.add(new Resume(userNo, name, age, gender, phoneNum, academic, career, typeOccup, periodType, dow, time,
				region));
		dao.saveResume(resumes);
		parttimerApplyUpdate();
		dao.savePartimer(parttimers);
	}

	//알바생 isApply 세팅
	public void parttimerApplyUpdate() {
		userNo = dao.getNowUser();
		for (int i = 0; i < parttimers.size(); i++) {
			if (parttimers.get(i).getNo() == userNo) {
				parttimers.get(i).setApply(true);
				break;
			}
		}
	}
	
	
}
