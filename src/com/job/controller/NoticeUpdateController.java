package com.job.controller;

import java.util.ArrayList;

import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Owner;
import com.job.model.dao.LoadSave;

public class NoticeUpdateController {
	private int userNo = 0;
	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private LoadSave dao = LoadSave.getDao();

	// ���ΰ��� ���� �޼ҵ�
	public void updateNotice(String bName, double pay, String timeTotime, String category, String addr,
			String periodType, String timeType, String bKeyword1, String bKeyword2, String bKeyword3, String etc) {
		userNo = dao.getNowUser();
		for (int i = 0; i < notices.size(); i++) {
			if (notices.get(i).getbNo() == userNo) {
				notices.set(i, new Notice(userNo, bName, pay, timeTotime, category, addr, periodType, timeType,
						bKeyword1, bKeyword2, bKeyword3, etc));
				dao.saveNotice(notices);
				break;
			}
		}
	}

	// NoticeUpdateView�� ����� ���ΰ��� ��ü�� �����ִ� �޼ҵ�
	public Notice sendUserInformation() {
		userNo = dao.getNowUser();
		notices = dao.loadNoitce();
		Notice temp = null;
		for (int i = 0; i < notices.size(); i++) {
			if (notices.get(i).getbNo() == userNo) {
				temp = notices.get(i);
				break;
			}
		}
		return temp;
	}

	// ���ΰ��� ������ ������ Connection ��ü�� ���� ����
	public void deleteConnection() {
		ArrayList<Connection> connections = dao.loadConnection();
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getNoticeNo() == userNo) {
				connections.remove(i);
				dao.saveConnection(connections);
				break;
			}
		}

	}

	// ���ΰ��� ����
	public void deleteNotice() {
		// userNo �� �������� ������ ��ü�� ArrayList notices���� ���� ( notices.remove() �̿� )
		userNo = dao.getNowUser();
		for (int i = 0; i < notices.size(); i++) {
			if (notices.get(i).getbNo() == userNo) {
				notices.remove(i);
				dao.saveNotice(notices);
			}
		}
	}

	// ���ΰ��� ������ Owner��ü�� isApply���� false�� �ٲ��ִ� �޼ҵ�
	public void applyUpdate() {
		userNo = dao.getNowUser();
		ArrayList<Owner> owners = dao.loadOnwer();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getNo() == userNo) {
				owners.get(i).setApply(false);
				dao.saveOwner(owners);
				break;
			}
		}
	}
}
