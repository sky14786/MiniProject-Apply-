package com.job.controller;

import java.util.ArrayList;

import com.job.model.Owner;
import com.job.model.dao.LoadSave;

public class OwnerSignUpController {

	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private LoadSave dao = LoadSave.getDao();

	
	//View�κ��� �Էµ����͸� �޾ƿ� Onwer��ü ������ ����
	public void addOwner(String id, String pw, String name, String bNumber, String addr) {
		owners = dao.loadOnwer();
		owners.add(new Owner(owners.size(), id, pw, name, bNumber, addr, false));
		dao.saveOwner(owners);
	}
	//ID �ߺ�üũ �޼ҵ�
	public boolean duplicateCheck(String id) {
		boolean checkType = true;
		owners = dao.loadOnwer();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId().equals(id)) {
				checkType = false;
				break;
			}
		}
		return checkType;
	}
	//ID�� ����θ� �̷���� �ִ��� üũ �޼ҵ�
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
