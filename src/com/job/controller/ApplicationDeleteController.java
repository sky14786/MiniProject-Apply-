package com.job.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.dao.LoadSave;

public class ApplicationDeleteController {

	private ArrayList<Notice> pt = new ArrayList<Notice>();
	private ArrayList<Notice> pt2 = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private ArrayList<Integer> resuems = new ArrayList<Integer>();
	private LoadSave dao = LoadSave.getDao();
	private DefaultTableModel DtmStorage = new DefaultTableModel();
	private LoadApplicationListController lac = new LoadApplicationListController();
	private int noticeNo;

	String bNo;
	String category; // pt.get(i)의 근무형태 변수
	String bName; // pt.get(i)의 업장명 변수
	String timeTotime2; // pt.get(i)의 근무시간 변수
	String pay; // pt.get(i)의 시급 변수
	String region2; // pt.get(i)의 주소 변수
	String timeType; // pt.get(i)의 몇시까지의 시간 변수
	String periodType2; // pt.get(i)의 기간 변수

	public DefaultTableModel loadApplicationList() {

		pt = dao.loadNoitce();

		DtmStorage.setNumRows(0);
		for (int i = 0; i < pt.size(); i++) {
			// typeOccup2 = pt.get(i).; // pt.get(i)의 근무형태 변수
			// bNo = Integer.toString(pt.get(i).getbNo());
			bName = pt.get(i).getbName(); // pt.get(i)의 업장명 변수
			timeTotime2 = pt.get(i).getTimeTotime(); // pt.get(i)의 근무시간 변수
			pay = Double.toString(pt.get(i).getPay()); // pt.get(i)의 시급 변수
			region2 = pt.get(i).getAddr(); // pt.get(i)의 주소 변수
			timeType = pt.get(i).getTimeType(); // pt.get(i)의 몇시까지의 시간 변수
			periodType2 = pt.get(i).getPeriodType(); // pt.get(i)의 기간 변수
			category = pt.get(i).getCategory();
			System.out.println(pt.get(i));

			DtmStorage.addRow(
					new String[] { (String) bName, pay, timeTotime2, category, periodType2, timeType, region2 });

		}
		return DtmStorage;

	}

	public void deleteApplicationList() {

	}

	public void deleteApplicationFromConnection(int row) {
		ArrayList<Notice> arr = lac.loadApplicationList();
		int noticeNum = arr.get(row).getbNo();
		connections = dao.loadConnection();
		Connection con = new Connection();
		int temp = -1;
		if (connections != null) {
			for (int i = 0; i < connections.size(); i++) {
				if (connections.get(i).getNoticeNo() == noticeNum) {
					con = connections.get(i);
					temp = i;
					break;
				}
			}
		}

		if (con.getResumes() != null) {
			for (int i = 0; i < con.getResumes().size(); i++) {
				if (con.getResumes().get(i).getUserNo() == dao.getNowUser()) {
					con.getResumes().remove(i);
					break;
				}
			}

			if (temp != -1) {
				connections.set(temp, con);
				dao.saveConnection(connections);
			}
		}

		// 선덕코드
//		if (connections != null) { // connections비어있지 않으면
//			for (int i = 0; i < connections.size(); i++) { // 쭉 돌기
//				if (connections.get(i).getResumes() != null) { // 이력서가 하나라도 있다면
//					for (int j = 0; j < connections.get(i).getResumes().size(); j++) {
//						if (connections.get(i).getResumes().get(j).getUserNo() == dao.getNowUser()) { // 지원된 이력서 찾아서
//							connections.get(i).getResumes().remove(j); // 지우기
//							break;
//						}
//					}
//				}
//			}
//		}
		dao.saveConnection(connections);
	}

}
