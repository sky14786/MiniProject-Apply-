package com.job.controller;

import java.util.ArrayList;
import java.util.List;

import com.job.model.Resume;
import com.job.run.Run;
import com.job.view.SearchView;

public class SearchController {

	public String region2;
	public String typeOccup2;
	public String periodType2;
	public String re;
	public String oc;
	public String pe;
	private String inputvar2;

	public ArrayList<Resume> rs2 = new ArrayList<Resume>();
	public ArrayList<Resume> rs3 = new ArrayList<Resume>();
	public ArrayList<Resume> rs5 = new ArrayList<Resume>();
	SearchView ss = null;

	// SearchView

	public void Search(Run win, String region, String typeOccup, String periodType) {

		rs2.clear();

		ss = win.getSearchView();

		for (int i = 0; i < ss.rs.size(); i++) {

			region2 = ss.rs.get(i).getRegion();
			typeOccup2 = ss.rs.get(i).getTypeOccup();
			periodType2 = ss.rs.get(i).getPeriodType();

			if (ss.rs.get(i).getRegion().equals(ss.inputvar)) {

				System.out.println(ss.rs.get(i).toString());
				rs2.add((Resume) ss.rs.get(i));
			}

			if (ss.rs.get(i).getTypeOccup().equals(ss.inputvar)) {

				System.out.println(ss.rs.get(i).toString());
				rs2.add((Resume) ss.rs.get(i));

			}
			if (ss.rs.get(i).getPeriodType().equals(ss.inputvar)) {

				System.out.println(ss.rs.get(i).toString());
				rs2.add((Resume) ss.rs.get(i));
			} else {
				System.out.println("다시 입력하시오");
			}
		}
		System.out.println();
	}

	public Resume resumeset(Run win) {
		Resume resume2 = new Resume();
		ss = win.getSearchView();
		String userNo = ss.DtmStorage.getValueAt(ss.getidx(), 0).toString();
		List<Resume> userList = new ArrayList<Resume>();
		userList = ss.rs;
		String userno = "";
		for (int i = 0; i < userList.size(); i++) {
			userno = Integer.toString(userList.get(i).getUserNo());
			if (userno.equals(userNo)) {
				resume2 = userList.get(i);
			}
		}

		System.out.println(">>>" + resume2);
		return resume2;
	}
}
