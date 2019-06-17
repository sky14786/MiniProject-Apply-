package com.job.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;

public class LoadApplicationListController {

	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private ArrayList<Notice> pt2 = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private ArrayList<Integer> resuems = new ArrayList<Integer>();
	private LoadSave dao = LoadSave.getDao();
	private DefaultTableModel DtmStorage = new DefaultTableModel();

	String bNo;
	String category; // pt.get(i)의 근무형태 변수
	String bName; // pt.get(i)의 업장명 변수
	String timeTotime2; // pt.get(i)의 근무시간 변수
	String pay; // pt.get(i)의 시급 변수
	String region2; // pt.get(i)의 주소 변수
	String timeType; // pt.get(i)의 몇시까지의 시간 변수
	String periodType2; // pt.get(i)의 기간 변수

	// 지원한 목록 Load 메소드
	public ArrayList<Notice> loadApplicationList() {

		// Data Access Object 로부터 필요 Data Load
		notices = dao.loadNoitce();
		connections = dao.loadConnection();
		notices = dao.loadNoitce();

		// 이력서 지원한 공고를 받아올 객체 선언
		ArrayList<Notice> myApply = new ArrayList<Notice>();

		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getResumes() != null) {
				for (int j = 0; j < connections.get(i).getResumes().size(); j++) {
					if (connections.get(i).getResumes().get(j).getUserNo() == dao.getNowUser()) {
						for (int k = 0; k < notices.size(); k++) {
							if (notices.get(k).getbNo() == connections.get(i).getNoticeNo()) {
								myApply.add(notices.get(k));
								System.out.println("ADD notice : " + notices.get(k));
								break;
							}
						}
					}
				}
			}
		}

		
//      for (int i = 0; i < notices.size(); i++) {
//         // typeOccup2 = pt.get(i).; // pt.get(i)의 근무형태 변수
//         // bNo = Integer.toString(pt.get(i).getbNo());
//         bName = notices.get(i).getbName(); // pt.get(i)의 업장명 변수
//         timeTotime2 = notices.get(i).getTimeTotime(); // pt.get(i)의 근무시간 변수
//         pay = Double.toString(notices.get(i).getPay()); // pt.get(i)의 시급 변수
//         region2 = notices.get(i).getAddr(); // pt.get(i)의 주소 변수
//         timeType = notices.get(i).getTimeType(); // pt.get(i)의 몇시까지의 시간 변수
//         periodType2 = notices.get(i).getPeriodType(); // pt.get(i)의 기간 변수
//         category = notices.get(i).getCategory();
//         System.out.println(notices.get(i));
//
//         DtmStorage.addRow(
//               new String[] { (String) bName, pay, timeTotime2, category, periodType2, timeType, region2 });
//
//      }
		return myApply;

	}

}