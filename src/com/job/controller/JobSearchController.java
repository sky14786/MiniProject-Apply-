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
	public String bName; // pt.get(i)의 업장명 변수
	public double pay; // pt.get(i)의 시급 변수
	public String timeTotime2; // pt.get(i)의 몇시까지 변수
	public String typeOccup2; // pt.get(i)의 근무형태 변수
	public String periodType2; // pt.get(i)의 기간 변수
	public String timeType2; // pt.get(i)의 몇 시간 변수
	public String region2; // pt.get(i)의 주소 변수
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

	public List<Notice> notice2 = new ArrayList<Notice>();// 조회결과를 테이블에 보여주기 위한 리스트
	public List<Notice> notice3 = new ArrayList<Notice>();// 테이블에 선택한 결과를 담는 리스트
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private LoadSave dao = LoadSave.getDao();

	// 검색
	public void search(String region, String typeOccup, String timeTotime, String periodType) {

		notice2.clear();
		System.out.println("검색 결과");
		// js.DtmStorage.setNumRows(0); // 검색 버튼을 누를때마다 테이블 갱신

		for (int i = 0; i < mm.notice.size(); i++) {

			bNo2 = mm.notice.get(i).getbNo();
			bName = mm.notice.get(i).getbName(); // notice.get(i)의 업장명 변수
			pay = mm.notice.get(i).getPay(); // pt.get(i)의 시급 변수
			timeTotime2 = mm.notice.get(i).getTimeTotime(); // pt.get(i)의 몇시부터 몇시까지 변수
			typeOccup2 = mm.notice.get(i).getCategory(); // pt.get(i)의 근무형태 변수
			periodType2 = mm.notice.get(i).getPeriodType(); // pt.get(i)의 기간 변수
			timeType2 = mm.notice.get(i).getTimeType(); // pt.get(i)의 몇시간 시간 변수
			region2 = mm.notice.get(i).getAddr(); // pt.get(i)의 주소 변수
			key1 = mm.notice.get(i).getbKeyword1();
			key2 = mm.notice.get(i).getbKeyword2();
			key3 = mm.notice.get(i).getbKeyword3();
			etc1 = mm.notice.get(i).getEtc();
			ki = "[기간 선택]";
			si = "[시간 선택]";
			mo = "[근무 형태]";
			ji = "[근무 지역]";

			// 지역 , 직종 , 시간, 기간
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
			// 지역 , 직종 , 시간
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(ki)) {

				System.out.println(mm.notice.get(i).toString());

				notice2.add((Notice) mm.notice.get(i));

			}
			
			// 지역 , 직종 , 기간
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& periodType.equals(periodType2)) {

				System.out.println(mm.notice.get(i).toString());

				notice2.add((Notice) mm.notice.get(i));

			}

			// 지역 , 기간
			if (region.equals(region2) && typeOccup.equals(mo) && timeTotime.equals(si)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 지역 , 시간
			if (region.equals(region2) && typeOccup.equals(mo) && timeTotime.equals(timeType2)
					&& periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 지역 , 직종
			if (region.equals(region2) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 지역 선택
			if (region.equals(region2) && typeOccup.equals(mo) && timeTotime.equals(si) && js.periodType.equals(ki)) {

				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 선택 x
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(si) && periodType.equals(ki)) {

				System.out.println("다시 선택");

			}

			// 근무 형태 선택
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& js.periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 근무 형태 , 시간 선택
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 근무형태 , 시간 , 기간 선택
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(timeType2)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 시간, 기간 선택
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(timeType2)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 시간 선택
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(timeType2) && periodType.equals(ki)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 기간 선택
			if (region.equals(ji) && typeOccup.equals(mo) && timeTotime.equals(si) && periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

			// 기간 , 근무 형태 선택
			if (region.equals(ji) && typeOccup.equals(typeOccup2) && timeTotime.equals(si)
					&& periodType.equals(periodType2)) {
				System.out.println(mm.notice.get(i));

				notice2.add((Notice) mm.notice.get(i));

			}

		}
		System.out.println();

	}

	// 키워드 검색 메소드
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

	// 전체 보기 메소드
	public void printAll() {

		js = new JobSearchView();

		notice2.clear();
		System.out.println("검색 결과");
		// js.DtmStorage.setNumRows(0); // 검색 버튼을 누를때마다 테이블 갱신

		for (int i = 0; i < mm.notice.size(); i++) {

			bNo2 = mm.notice.get(i).getbNo();
			bName = mm.notice.get(i).getbName(); // pt.get(i)의 업장명 변수
			pay = mm.notice.get(i).getPay(); // pt.get(i)의 시급 변수
			timeTotime2 = mm.notice.get(i).getTimeTotime(); // pt.get(i)의 몇시부터 몇시까지 변수
			typeOccup2 = mm.notice.get(i).getCategory(); // pt.get(i)의 근무형태 변수
			periodType2 = mm.notice.get(i).getPeriodType(); // pt.get(i)의 기간 변수
			timeType2 = mm.notice.get(i).getTimeType(); // pt.get(i)의 몇시간 시간 변수
			region2 = mm.notice.get(i).getAddr(); // pt.get(i)의 주소 변수
			key1 = mm.notice.get(i).getbKeyword1();
			key2 = mm.notice.get(i).getbKeyword2();
			key3 = mm.notice.get(i).getbKeyword3();
			etc1 = mm.notice.get(i).getEtc();

			notice2.add((Notice) mm.notice.get(i));

		}
	}

	// 상세 보기 버튼 메소드
	public Notice seeMore(int row) {
		Notice temp = new Notice();

		if (row == -1) {

			// 아무것도 선택하지 않고 지원하기를 클릭했을때
			// 안내메세지

			JOptionPane.showMessageDialog(null, "원하시는 알바를 선택해주세요!");

			System.out.println("선택 안함");

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

	// 지원하기 버튼 메소드
	public void search2(int row) {
		Notice temp2 = new Notice();
		System.out.println("Apply Row : " + row);

		if (row == -1) {

			// 아무것도 선택하지 않고 지원하기를 클릭했을때
			// 안내메세지
			JOptionPane.showMessageDialog(null, "원하시는 알바를 선택해주세요!");

			System.out.println("선택 안함");
		} else {

			// 선택한 정보를 새로운 객체에 저장

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

			// Connection 객체와 연동 부분 --------------------------------------
			System.out.println("지원시작!");
			
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
				System.out.println("단일지원성공");
				JOptionPane.showMessageDialog(null, "지원하였습니다!");
			}
			else {	//구인공고에 지원된 이력서가 하나라도 있으면
				System.out.println(connection.getResumes().toString());
				for (int i = 0; i < connection.getResumes().size(); i++) {
					if (connection.getResumes().get(i).getUserNo() == nowResume.getUserNo()) { //이미 지원해놓은 상태
						isEquals = false;
						break;
					} else { //처음지원
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
					System.out.println("지원성공");
					System.out.println("ResumesCount : " + tt.size());
					System.out.println("Resumes : " + tt.toString());
					System.out.println("-------------------------------------------");
					JOptionPane.showMessageDialog(null, "지원하였습니다!");
				}

				else {
					System.out.println("지원실패");
					JOptionPane.showMessageDialog(null, "이미 지원하셨습니다!");
				}
			}
			System.out.println("-------------------------------------------");
			System.out.println("now Notice : " + temp2.toString());
			System.out.println("now Row : " + notice2.get(row).getbNo());
			System.out.println("now Resumes Count : " + connection.getResumes().size());
			System.out.println("now Resumes : " + connection.getResumes().toString());
			System.out.println("now Connection : " + connection.toString());
			System.out.println("-------------------------------------------");
			// Connection 객체와 연동 부분 -------------------------------------------
			// 안내메세지
		}
		// return temp2;
	}
}
