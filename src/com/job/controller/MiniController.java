package com.job.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.job.model.Resume;
import com.job.view.MainView;

public class MiniController extends JFrame {

	private MainView mainMenu = new MainView();

	static String inputvar = " ";

	/**
	 * Create the frame.
	 */

	public void mainMenu() {

		mainMenu.mainView(this);

//		EventQueue.invokeLater(new Runnable() {	
//			public void run() {
//				try {
//					
//					setVisible(true);
//					mainMenu.testset();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});

	}

	public void search() {

		List<Resume> list = new ArrayList<Resume>();
		List<Resume> list2 = new ArrayList<Resume>();
		list = mainMenu.pt;
		list2 = mainMenu.pt2;
		Resume resume = new Resume();

		mainMenu.pt2.clear();
		System.out.println("��� ���");
		mainMenu.DtmStorage.setNumRows(0);

		for (int i = 0; i < list.size(); i++) {
			// pt�� �ε����� ���� ����
			mainMenu.userNo = list.get(i).getUserNo();
			mainMenu.typeOccup2 = list.get(i).getTypeOccup();
			mainMenu.name = list.get(i).getName();
			mainMenu.region2 = list.get(i).getRegion();
			mainMenu.periodType2 = list.get(i).getPeriodType();
			mainMenu.dow = list.get(i).getDow();
			mainMenu.phone = list.get(i).getPhone();

//		            DtmStorage.addRow(new String[] {(String)resumeNO, typeOccup2, 
//		            name , region2 , period2,
//		            dow, phone});

			if (mainMenu.region.equals("[�ٹ�����]") && mainMenu.typeOccup.equals("[�ٹ�����]")
					&& mainMenu.periodType.equals(mainMenu.periodType2)) {
				System.out.println(list.get(i)); // ����� �߳������� ���

				list2.add((Resume) list.get(i)); // wk�� �ε����� wk2 ����Ʈ�� �ε����� �߰�

				// ���̺� ���
				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}

			}

			if (mainMenu.region.equals("[�ٹ�����]") && mainMenu.typeOccup.equals(mainMenu.typeOccup2)
					&& mainMenu.periodType.equals(mainMenu.periodType2)) {
				System.out.println(mainMenu.pt.get(i));

				list2.add((Resume) list.get(i));

				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}
			}

			if (mainMenu.region.equals(mainMenu.region2) && mainMenu.typeOccup.equals(mainMenu.typeOccup2)
					&& mainMenu.periodType.equals(mainMenu.periodType2)) {
				System.out.println(list.get(i));

				list2.add((Resume) list.get(i));

				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}
			}

			if (mainMenu.region.equals(mainMenu.region2) && mainMenu.typeOccup.equals("[�ٹ�����]")
					&& mainMenu.periodType.equals("[�ٹ��Ⱓ]")) {
				System.out.println(list.get(i));

				list2.add((Resume) list.get(i));

				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}
			}

			if (mainMenu.region.equals(mainMenu.region2) && mainMenu.typeOccup.equals(mainMenu.typeOccup2)
					&& mainMenu.periodType.equals("[�ٹ��Ⱓ]")) {
				System.out.println(list.get(i));

				list2.add((Resume) list.get(i));

				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}
			}

			if (mainMenu.region.equals("[�ٹ�����]") && mainMenu.typeOccup.equals(mainMenu.typeOccup2)
					&& mainMenu.periodType.equals("[�ٹ��Ⱓ]")) {
				System.out.println(list.get(i));

				list2.add((Resume) list.get(i));

				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}
			}

			if (mainMenu.region.equals(mainMenu.region2) && mainMenu.typeOccup.equals("[�ٹ�����]")
					&& mainMenu.periodType.equals(mainMenu.periodType2)) {
				System.out.println(list.get(i));

				list2.add((Resume) list.get(i));

				for (int j = 0; j < list2.size(); j++) {
					mainMenu.DtmStorage.addRow(new Object[] { (Object) mainMenu.userNo, mainMenu.typeOccup2,
							mainMenu.name, mainMenu.region2, mainMenu.periodType2, mainMenu.dow, mainMenu.phone });
					break;
				}
			}

		}

		System.out.println();

	}
}
