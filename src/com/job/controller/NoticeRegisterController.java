package com.job.controller;

import java.util.ArrayList;

import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Owner;
import com.job.model.dao.LoadSave;

public class NoticeRegisterController {
	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private ArrayList<Owner> owners = new ArrayList<Owner>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private Connection connection = null;
	private int userNo = 0;
	private LoadSave dao = LoadSave.getDao();

	public NoticeRegisterController() {
	}

	// 구인공고등록 메소드
	public void addNotice(String bName, double pay, String timeTotime, String category, String addr, String periodType,
			String timeType, String bKeyword1, String bKeyword2, String bKeyword3, String etc) {
		connections = dao.loadConnection();
		userNo = dao.getNowUser();
		notices = dao.loadNoitce();
		owners = dao.loadOnwer();

		notices.add(new Notice(userNo, bName, pay, timeTotime, category, addr, periodType, timeType, bKeyword1,
				bKeyword2, bKeyword3, etc));

		connection = new Connection();
		connection.setNoticeNo(userNo);
		connections.add(connection);
		dao.saveConnection(connections);
		dao.saveNotice(notices);
		ownerApplyUpdate();
		dao.saveOwner(owners);
	}

	// Owner의 구인공고가 이미 등록되어 있는지 여부 체크
	public boolean isApplyCheck() {
		userNo = dao.getNowUser();
		owners = dao.loadOnwer();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getNo() == userNo) {
				if (!owners.get(i).isApply()) {
					return true;
				}
			}
		}
		return false;
	}

	// Owner가 구인공고 등록시에 isApply 값 변경 메소드
	public void ownerApplyUpdate() {
		userNo = dao.getNowUser();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getNo() == userNo) {
				owners.get(i).setApply(true);
				dao.saveOwner(owners);
				break;
			}
		}
	}
}
