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
	
	//�̷¼� �����ϱ�
	public void delResume() {
		userNo = dao.getNowUser();
		resumes = dao.loadResume();
		parttimers = dao.loadPartimer();
		
		// Ŀ�ؼ���� ����
		deleteResumeFromConnection();
		
		// ��ü �̷¼� ��Ͽ��� ����
		for (int i = 0; i < resumes.size(); i++) {
			if (resumes.get(i).getUserNo() == userNo) {
				resumes.remove(i);
				break;
			}
		}
		dao.saveResume(resumes); // ������ �̷¼���� ����

		parttimerApplyUpdate(); // �������� �̷¼���ϻ��� false�� ����
		dao.savePartimer(parttimers); // ������ ���������� ����
	}
	
	//�˹ٻ� isApply ����
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

		if (connections != null) {	//connections������� ������
			for (int i = 0; i < connections.size(); i++) {	//�� ����
				if (connections.get(i).getResumes() != null) {	//�̷¼��� �ϳ��� �ִٸ�
					for (int j = 0; j < connections.get(i).getResumes().size(); j++) {
						if (connections.get(i).getResumes().get(j).getUserNo() == dao.getNowUser()) {	//������ �̷¼� ã�Ƽ�
							connections.get(i).getResumes().remove(j);	//�����
							break;
						}
					}
				}
			}
		}
		dao.saveConnection(connections);
	}
	
}
