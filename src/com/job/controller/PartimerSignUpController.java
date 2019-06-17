package com.job.controller;

import java.util.ArrayList;

import com.job.model.Partimer;
import com.job.model.dao.LoadSave;

public class PartimerSignUpController {
	private ArrayList<Partimer> partimers = new ArrayList<Partimer>();
	private LoadSave dao = LoadSave.getDao();

	// View�κ��� �Էµ����͸� �޾ƿ� partimer ��ü ������ ����
	public void addPartimer(String id, String pw, String name, int age, String gender, String phone) {
		partimers = dao.loadPartimer();
		partimers.add(new Partimer(partimers.size(), id, pw, name, age, gender, phone, false));
		dao.savePartimer(partimers);
	}

	// ID �ߺ�Ȯ�� �޼ҵ�
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

	// ID ���� üũ �޼ҵ�
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
