package com.job.controller;

import java.util.ArrayList;

import com.job.model.Connection;
import com.job.model.Partimer;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class ResumeDeleteController {

	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private ArrayList<Partimer> parttimers = new ArrayList<Partimer>();
	private int userNo = 0;
	private LoadSave dao = LoadSave.getDao();
	private ArrayList<Connection> connections = new ArrayList<Connection>();

	public ResumeDeleteController() {}
	
	//이력서 삭제하기
	public void delResume() {
		userNo = dao.getNowUser();
		resumes = dao.loadResume();
		parttimers = dao.loadPartimer();
		
		// 커넥션즈에서 삭제
		deleteResumeFromConnection();
		
		// 전체 이력서 목록에서 삭제
		for (int i = 0; i < resumes.size(); i++) {
			if (resumes.get(i).getUserNo() == userNo) {
				resumes.remove(i);
				break;
			}
		}
		dao.saveResume(resumes); // 수정된 이력서목록 저장

		parttimerApplyUpdate(); // 구직자의 이력서등록상태 false로 세팅
		dao.savePartimer(parttimers); // 수정된 구직자정보 저장
	}
	
	//알바생 isApply 세팅
	public void parttimerApplyUpdate() {
		userNo = dao.getNowUser();
		for (int i = 0; i < parttimers.size(); i++) {
			if (parttimers.get(i).getNo() == userNo) {
				parttimers.get(i).setApply(false);
				break;
			}
		}
	}
	
	private void deleteResumeFromConnection() {
		connections = dao.loadConnection();

		if (connections != null) {	//connections비어있지 않으면
			for (int i = 0; i < connections.size(); i++) {	//쭉 돌기
				if (connections.get(i).getResumes() != null) {	//이력서가 하나라도 있다면
					for (int j = 0; j < connections.get(i).getResumes().size(); j++) {
						if (connections.get(i).getResumes().get(j).getUserNo() == dao.getNowUser()) {	//지원된 이력서 찾아서
							connections.get(i).getResumes().remove(j);	//지우기
							break;
						}
					}
				}
			}
		}
		dao.saveConnection(connections);
	}
	
}
