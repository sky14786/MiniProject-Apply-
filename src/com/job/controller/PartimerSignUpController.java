package com.job.controller;

import java.util.ArrayList;

import com.job.model.Partimer;
import com.job.model.dao.LoadSave;

public class PartimerSignUpController {
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();
	private LoadSave dao = LoadSave.getDao();

	// View로부터 입력데이터를 받아와 partimer 객체 생성후 저장
	public void addPartimer(String id, String pw, String name, int age, String gender, String phone) {
		partimers = dao.loadPartimer();
		partimers.add(new Partimer(partimers.size(), id, pw, name, age, gender, phone, false));
		dao.savePartimer(partimers);
	}

	// ID 중복확인 메소드
	public boolean duplicateCheck(String id) {
		boolean checkType = true;
		partimers = dao.loadPartimer();
		for (int i = 0; i < partimers.size(); i++) {
			if (partimers.get(i).getId().equals(id)) {
				checkType = false;
				break;
			}
		}
		return checkType;
	}

	// ID 영어 체크 메소드
	public boolean englishCheck(String id) {
		boolean checkType = true;
		for (int i = 0; i < id.length(); i++) {
			if (!((id.charAt(i) >= 'a' && id.charAt(i) <= 'z') || (id.charAt(i) >= 'A' && id.charAt(i) <= 'Z')
					|| (id.charAt(i) >= '0' && id.charAt(i) <= '9'))) {
				checkType = false;
				return checkType;
			}
		}
		return checkType;
	}

}
