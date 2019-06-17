package com.job.controller;

import java.util.ArrayList;

import com.job.model.Partimer;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class CheckingController {
	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private ArrayList<Partimer> parttimers = new ArrayList<Partimer>();
	private int userNo = 0;
	private LoadSave dao = LoadSave.getDao();

	public int isApplyCheck() {
		userNo = dao.getNowUser();
		parttimers = dao.loadPartimer();
		int check=1; //����ã�� ����
		
		for(int i=0; i<parttimers.size(); i++) {
			if(parttimers.get(i).getNo() == userNo) {	//���� ã��
				System.out.println(parttimers.get(i).toString());
				if(parttimers.get(i).getIsApply() == true)
				{
					check = 2;	//�̷¼� ����
				}
				else if(parttimers.get(i).getIsApply() == false)
				{
					check = 3;	//�̷¼� ����
				}
			}
		}

		return check;
	}
	
	//ȸ������ �����ֱ�
	public Partimer sendUserInformation() {
		userNo = dao.getNowUser();
		parttimers = dao.loadPartimer();
		Partimer temp = null;
		for (int i = 0; i < parttimers.size(); i++) {
			if (parttimers.get(i).getNo() == userNo) {
				return parttimers.get(i);
			}
		}
		return temp;
	}

	//�̷¼� �����ֱ�
	public Resume sendResume() {
		userNo = dao.getNowUser();
		resumes = dao.loadResume();
		Resume temp = null;
		for (int i = 0; i < resumes.size(); i++) {
			if (resumes.get(i).getUserNo() == userNo) {
				return resumes.get(i);
			}
		}
		return temp;
	}
	
}
