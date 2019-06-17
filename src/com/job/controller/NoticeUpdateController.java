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

	// 구인공고 수정 메소드
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

	// NoticeUpdateView로 등록한 구인공고 객체를 보내주는 메소드
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

	// 구인공고 삭제시 연동된 Connection 객체도 같이 삭제
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

	// 구인공고 삭제
	public void deleteNotice() {
		// userNo 의 변수값과 동일한 객체를 ArrayList notices에서 삭제 ( notices.remove() 이용 )
		userNo = dao.getNowUser();
		for (int i = 0; i < notices.size(); i++) {
			if (notices.get(i).getbNo() == userNo) {
				notices.remove(i);
				dao.saveNotice(notices);
			}
		}
	}

	// 구인공고 삭제시 Owner객체의 isApply값도 false로 바꿔주는 메소드
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
