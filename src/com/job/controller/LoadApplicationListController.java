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
	String category; // pt.get(i)�� �ٹ����� ����
	String bName; // pt.get(i)�� ����� ����
	String timeTotime2; // pt.get(i)�� �ٹ��ð� ����
	String pay; // pt.get(i)�� �ñ� ����
	String region2; // pt.get(i)�� �ּ� ����
	String timeType; // pt.get(i)�� ��ñ����� �ð� ����
	String periodType2; // pt.get(i)�� �Ⱓ ����

	// ������ ��� Load �޼ҵ�
	public ArrayList<Notice> loadApplicationList() {

		// Data Access Object �κ��� �ʿ� Data Load
		notices = dao.loadNoitce();
		connections = dao.loadConnection();
		notices = dao.loadNoitce();

		// �̷¼� ������ ���� �޾ƿ� ��ü ����
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
//         // typeOccup2 = pt.get(i).; // pt.get(i)�� �ٹ����� ����
//         // bNo = Integer.toString(pt.get(i).getbNo());
//         bName = notices.get(i).getbName(); // pt.get(i)�� ����� ����
//         timeTotime2 = notices.get(i).getTimeTotime(); // pt.get(i)�� �ٹ��ð� ����
//         pay = Double.toString(notices.get(i).getPay()); // pt.get(i)�� �ñ� ����
//         region2 = notices.get(i).getAddr(); // pt.get(i)�� �ּ� ����
//         timeType = notices.get(i).getTimeType(); // pt.get(i)�� ��ñ����� �ð� ����
//         periodType2 = notices.get(i).getPeriodType(); // pt.get(i)�� �Ⱓ ����
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