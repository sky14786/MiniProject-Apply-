package com.job.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;
import com.job.view.DummyData;
import com.job.view.JobSearchView;

public class JobSearchController {

	JScrollPane listJs;
	JPanel listPanel;
	JTable userTable;
	Vector<String> userCol = new Vector<String>();
	DefaultTableModel model;
	public int bNo2;
	public String bName; // pt.get(i)�� ����� ����
	public double pay; // pt.get(i)�� �ñ� ����
	public String timeTotime2; // pt.get(i)�� ��ñ��� ����
	public String typeOccup2; // pt.get(i)�� �ٹ����� ����
	public String periodType2; // pt.get(i)�� �Ⱓ ����
	public String timeType2; // pt.get(i)�� �� �ð� ����
	public String region2; // pt.get(i)�� �ּ� ����
	public String key1;
	public String key2;
	public String key3;
	public String etc1;
	public String ki;
	public String si;
	public String mo;
	public String ji;

	DefaultTableModel dtm = new DefaultTableModel();

	JobSearchView js = null;
	DummyData mm = null;
	Notice n = new Notice();

	public List<Notice> notice2 = new ArrayList<Notice>();// ��ȸ����� ���̺� �����ֱ� ���� ����Ʈ
	public List<Notice> notice3 = new ArrayList<Notice>();// ���̺� ������ ����� ��� ����Ʈ
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private LoadSave dao = LoadSave.getDao();

	// �˻�
	public void search(String region, String typeOccup, String timeTotime, String periodType) {

		notice2.clear();
		System.out.println("�˻� ���");
		// js.DtmStorage.setNumRows(0); // �˻� ��ư�� ���������� ���̺� ����

		for (int i = 0; i < mm.notice.size(); i++) {

			bNo2 = mm.notice.get(i).getbNo();
			bName = mm.notice.get(i).getbName(); // notice.get(i)�� ����� ����
			pay = mm.notice.get(i).getPay(); // pt.get(i)�� �ñ� ����
			timeTotime2 = mm.notice.get(i).getTimeTotime(); // pt.get(i)�� ��ú��� ��ñ��� ����
			typeOccup2 = mm.notice.get(i).getCategory(); // pt.get(i)�� �ٹ����� ����
			periodType2 = mm.notice.get(i).getPeriodType(); // pt.get(i)�� �Ⱓ ����
			timeType2 = mm.notice.get(i).getTimeType(); // pt.get(i)�� ��ð� �ð� ����
			region2 = mm.notice.get(i).getAddr(); // pt.get(i)�� �ּ� ����
			key1 = mm.notice.get(i).getbKeyword1();
			key2 = mm.notice.get(i).getbKeyword2();
			key3 = mm.notice.get(i).getbKeyword3();
			etc1 = mm.notice.get(i).getEtc();
			ki = "[�Ⱓ ����]";
			si = "[�ð� ����]";
			mo = "[�ٹ� ����]";
			ji = "[�ٹ� ����]";

			// ���� , ���� , �ð�, �Ⱓ
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(periodType2)) {

				System.out.println(mm.notice.get(i).toString());

				notice2.add((Notice) mm.notice.get(i));

				// for (int j = 0; j < pt2.size(); j++) {
				//
				// js.DtmStorage.addRow(new Object[] { bNo2, bName, pay, timeTotime2,
				// typeOccup2, periodType2, timeType2, region2, key1, key2, key3, etc1 });
				//
				// break;
				// }

			}
			// ���� , ���� , �ð�
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(ki)) {

				System.out.println(mm.notice.get(i).toString());

				notice2.add((Notice) mm.notice.get(i));

			}
			
			// ���� , ���� , �Ⱓ
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& periodType.equals(periodType2)) {

				System.out.println(mm.notice.get(i).toString());

				notice2.add((Notice) mm.notice.get(i));

			}

			// ���� , �Ⱓ
			if (region.equals(region2) && typeOccup.equals(mo) && timeTotime.equals(si)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// ���� , �ð�
			if (region.equals(region2) && typeOccup.equals(mo) && timeTotime.equals(timeType2)
					&& periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// ���� , ����
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// ���� ����
			if (region.equals(region2) && typeOccup.equals(mo) && timeTotime.equals(si) && js.periodType.equals(ki)) {

				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// ���� x
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(si) && periodType.equals(ki)) {

				System.out.println("�ٽ� ����");

			}

			// �ٹ� ���� ����
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& js.periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// �ٹ� ���� , �ð� ����
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// �ٹ����� , �ð� , �Ⱓ ����
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// �ð�, �Ⱓ ����
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(timeType2)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// �ð� ����
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(timeType2) && periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// �Ⱓ ����
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(si) && periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// �Ⱓ , �ٹ� ���� ����
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

		}
		System.out.println();

	}

	// Ű���� �˻� �޼ҵ�
	public ArrayList<Notice> keywordSearch(String keyword) {
		ArrayList<Notice> arr = arr = dao.loadNoitce();
		ArrayList<Notice> temp = new ArrayList<Notice>();

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getbKeyword1().contains(keyword) || arr.get(i).getbKeyword2().contains(keyword)
					|| arr.get(i).getbKeyword3().contains(keyword)) {
				temp.add(arr.get(i));
			}
		}

		return temp;
	}

	// ��ü ���� �޼ҵ�
	public void printAll() {

		js = new JobSearchView();

		notice2.clear();
		System.out.println("�˻� ���");
		// js.DtmStorage.setNumRows(0); // �˻� ��ư�� ���������� ���̺� ����

		for (int i = 0; i < mm.notice.size(); i++) {

			bNo2 = mm.notice.get(i).getbNo();
			bName = mm.notice.get(i).getbName(); // pt.get(i)�� ����� ����
			pay = mm.notice.get(i).getPay(); // pt.get(i)�� �ñ� ����
			timeTotime2 = mm.notice.get(i).getTimeTotime(); // pt.get(i)�� ��ú��� ��ñ��� ����
			typeOccup2 = mm.notice.get(i).getCategory(); // pt.get(i)�� �ٹ����� ����
			periodType2 = mm.notice.get(i).getPeriodType(); // pt.get(i)�� �Ⱓ ����
			timeType2 = mm.notice.get(i).getTimeType(); // pt.get(i)�� ��ð� �ð� ����
			region2 = mm.notice.get(i).getAddr(); // pt.get(i)�� �ּ� ����
			key1 = mm.notice.get(i).getbKeyword1();
			key2 = mm.notice.get(i).getbKeyword2();
			key3 = mm.notice.get(i).getbKeyword3();
			etc1 = mm.notice.get(i).getEtc();

			notice2.add((Notice) mm.notice.get(i));

		}
	}

	// �� ���� ��ư �޼ҵ�
	public Notice seeMore(int row) {
		Notice temp = new Notice();

		if (row == -1) {

			// �ƹ��͵� �������� �ʰ� �����ϱ⸦ Ŭ��������
			// �ȳ��޼���

			JOptionPane.showMessageDialog(null, "���Ͻô� �˹ٸ� �������ּ���!");

			System.out.println("���� ����");

		} else if (row != -1) {
			temp.setbNo(notice2.get(row).getbNo());
			temp.setbName(notice2.get(row).getbName());
			temp.setPay(notice2.get(row).getPay());
			temp.setTimeTotime(notice2.get(row).getTimeTotime());
			temp.setCategory(notice2.get(row).getCategory());
			temp.setPeriodType(notice2.get(row).getPeriodType());
			temp.setTimeType(notice2.get(row).getTimeType());
			temp.setAddr(notice2.get(row).getAddr());
			temp.setbKeyword1(notice2.get(row).getbKeyword1());
			temp.setbKeyword2(notice2.get(row).getbKeyword2());
			temp.setbKeyword3(notice2.get(row).getbKeyword3());
			temp.setEtc(notice2.get(row).getEtc());

		}
		return temp;

	}

	// �����ϱ� ��ư �޼ҵ�
	public void search2(int row) {
		Notice temp2 = new Notice();
		System.out.println("Apply Row : " + row);

		if (row == -1) {

			// �ƹ��͵� �������� �ʰ� �����ϱ⸦ Ŭ��������
			// �ȳ��޼���
			JOptionPane.showMessageDialog(null, "���Ͻô� �˹ٸ� �������ּ���!");

			System.out.println("���� ����");
		} else {

			// ������ ������ ���ο� ��ü�� ����

			temp2.setbNo(notice2.get(row).getbNo());
			temp2.setbName(notice2.get(row).getbName());
			temp2.setPay(notice2.get(row).getPay());
			temp2.setTimeTotime(notice2.get(row).getTimeTotime());
			temp2.setCategory(notice2.get(row).getCategory());
			temp2.setPeriodType(notice2.get(row).getPeriodType());
			temp2.setTimeType(notice2.get(row).getTimeType());
			temp2.setAddr(notice2.get(row).getAddr());
			temp2.setbKeyword1(notice2.get(row).getbKeyword1());
			temp2.setbKeyword2(notice2.get(row).getbKeyword2());
			temp2.setbKeyword3(notice2.get(row).getbKeyword3());
			temp2.setEtc(notice2.get(row).getEtc());

			System.out.println(notice2.get(row).toString());

			// Connection ��ü�� ���� �κ� --------------------------------------
			System.out.println("��������!");
			
			Connection connection = new Connection();
			connections = dao.loadConnection();
			ArrayList<Resume> resumes = dao.loadResume();
			ArrayList<Resume> tt = new ArrayList<Resume>();
			Resume nowResume = new Resume();
			
			boolean isEquals = false;
			int temp = 0;
			
			for (int i = 0; i < connections.size(); i++) {
				if (connections.get(i).getNoticeNo() == notice2.get(row).getbNo()) {
					connection = connections.get(i);
					temp = i;
					break;
				}
			}
			for (int i = 0; i < resumes.size(); i++) {
				if (resumes.get(i).getUserNo() == dao.getNowUser()) {
					nowResume = resumes.get(i);
				}
			}
			
			if (connection.getResumes() == null) {
				tt.add(nowResume);
				connection.setResuems(tt);
				connections.set(temp, connection);
				dao.saveConnection(connections);
				System.out.println("������������");
				JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�!");
			}
			else {	//���ΰ��� ������ �̷¼��� �ϳ��� ������
				System.out.println(connection.getResumes().toString());
				for (int i = 0; i < connection.getResumes().size(); i++) {
					if (connection.getResumes().get(i).getUserNo() == nowResume.getUserNo()) { //�̹� �����س��� ����
						isEquals = false;
						break;
					} else { //ó������
						isEquals = true;
					}
				}
				if (isEquals) {
					tt = connection.getResumes();
					tt.add(nowResume);
					connection.setResuems(tt);
					connections.set(temp, connection);
					dao.saveConnection(connections);
					System.out.println("-------------------------------------------");
					System.out.println("��������");
					System.out.println("ResumesCount : " + tt.size());
					System.out.println("Resumes : " + tt.toString());
					System.out.println("-------------------------------------------");
					JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�!");
				}

				else {
					System.out.println("��������");
					JOptionPane.showMessageDialog(null, "�̹� �����ϼ̽��ϴ�!");
				}
			}
			System.out.println("-------------------------------------------");
			System.out.println("now Notice : " + temp2.toString());
			System.out.println("now Row : " + notice2.get(row).getbNo());
			System.out.println("now Resumes Count : " + connection.getResumes().size());
			System.out.println("now Resumes : " + connection.getResumes().toString());
			System.out.println("now Connection : " + connection.toString());
			System.out.println("-------------------------------------------");
			// Connection ��ü�� ���� �κ� -------------------------------------------
			// �ȳ��޼���
		}
		// return temp2;
	}
}
