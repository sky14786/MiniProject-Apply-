package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.job.controller.SearchController;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;
import com.job.run.Run;

public class SearchView extends JPanel {
	private Run win = new Run();
	private JTable table;
	private JTextField textField;
	public DefaultTableModel DtmStorage;
	private JButton searchButton;

	private String region;
	private String typeOccup;
	private String periodType;

	private String name;
	private int age;
	private String gender;
	private String phone;

	private String academic;
	private String career;

	private int userNo;
	private String dow;

	public String inputvar = "";

	private SearchController sc = new SearchController();

	public ArrayList<Resume> rs = new ArrayList<Resume>();

	public int getidx() {
		System.out.println("???");
		return table.getSelectedRow();
	}

	public SearchView(Run win) {
		this.win = win;
		initialize();
		rs = LoadSave.getDao().loadResume();
	}

	private void initialize() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setSize(1000, 600);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0) {
			public boolean isCellEditable(int row, int colum) {
				return false;
			}
		};
		// ------------------------------------------���̺���----------------------------------------------------
		table = new JTable(DtmStorage);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setResizingAllowed(false); // ���̺� �÷� ���������
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ���̺� �ο� �Ѱ�����
		table.setFont(new Font("����������", Font.PLAIN, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.getTableHeader().setReorderingAllowed(false); // ���̺� �� ���콺�� �̵� ���ϰ�
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(40);
		// -----------------------------------------------------------------------

		// DtmStorage.setColumnIdentifiers(new String[] { "resume NO", "����", "�̸�", "����",
		// "�ٹ��Ⱓ", "�ٹ�����", "��ȭ��ȣ" });
		DtmStorage.setColumnIdentifiers(new String[] { "user no", "����", "�̸�", "����", "�ٹ��Ⱓ", "�ٹ�����", "��ȭ��ȣ" });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(83, 276, 833, 257);
		add(scrollPane);

		DefaultTableCellRenderer DtmCellRender = new DefaultTableCellRenderer();
		DtmCellRender.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(DtmCellRender);
		}

		TableColumn column = table.getColumnModel().getColumn(0);

		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);

		// �˻���ư ���
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// ��ü��.�޼ҵ��(�޼ҵ尡 �޴� ����);
					DtmStorage.setNumRows(0);
					inputvar = textField.getText();
					sc.Search(win, region, typeOccup, periodType);

					for (int i = 0; i < sc.rs2.size(); i++) {
						DtmStorage.addRow(new Object[] { rs.get(i).getUserNo(), sc.rs2.get(i).getTypeOccup(),
								rs.get(i).getName(), sc.rs2.get(i).getRegion(), sc.rs2.get(i).getPeriodType(),
								rs.get(i).getDow(), rs.get(i).getPhone() });
					}
					// sc.parameterTest(textField.getText())
				} catch (NullPointerException a) {
					a.printStackTrace();
				}
			}
		});
		searchButton.setBounds(710, 129, 123, 52);
		searchButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchBtn.png")));
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		add(searchButton);

		// ���θ޴��� �ڷΰ���
		JButton button_3 = new JButton("");
		button_3.setBounds(785, 537, 123, 52);
		button_3.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getOwnerMainView());
				win.setSize(1000, 620);
				revalidate();
				repaint();
				win.setVisible(false);
				win.setVisible(true);

			}
		});
		setVisible(true);

		// ������ ��ü��ȸ
		JButton button = new JButton("");
		button.setBounds(83, 230, 167, 36);
		button.setIcon(new ImageIcon(this.getClass().getResource("/resource/allSearchBtn.png")));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ** OwnerMainView���� �̷¼� ���� ��ư �����ڸ��� ���̺� ǥ���ϱ� ���ؼ� ������ ��ü����ҽ� �޼ҵ�ȭ ���ֽ��ϴ�.**
				normalSearch();
			}
		});

		textField = new JTextField();
		textField.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 20));
		textField.setBounds(483, 135, 215, 32);
		textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textField.setOpaque(false);

		add(textField);
		textField.setColumns(10);

		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.out.println(add(textField));

			}
		});

		// ����
		JButton button_1 = new JButton("");
		button_1.setBounds(839, 230, 78, 36);
		button_1.setIcon(new ImageIcon(this.getClass().getResource("/resource/OpenBtn.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);

		add(button_1);

		JLabel lbBack = new JLabel("");
		lbBack.setBounds(0, 0, 1000, 600);
		lbBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchView-2.jpg")));
		add(lbBack);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() != -1) {
					win.getContentPane().removeAll();
					win.getContentPane().add(win.getSearch2View());
					win.setSize(581, 793);
					revalidate();
					repaint();

					Resume player = new Resume();
					player = sc.resumeset(win);
					win.getSearch2View().dataSetting(win, player);
				} else {
					System.out.println("Grid���� �������ּ���.");
				}

			}
		});
	}

	// ������ ��ü��ȸ �޼ҵ�
	public void normalSearch() {
		DtmStorage.setNumRows(0);

		for (int i = 0; i < rs.size(); i++) {

			userNo = rs.get(i).getUserNo();
			typeOccup = rs.get(i).getTypeOccup();
			name = rs.get(i).getName();
			region = rs.get(i).getRegion();
			periodType = rs.get(i).getPeriodType();
			dow = rs.get(i).getDow();
			phone = rs.get(i).getPhone();

			DtmStorage.addRow(new Object[] { (Object) userNo, typeOccup, name, region, periodType, dow, phone });

		}
	}

	private void dummyset() {
//		rs.add(new Resume("ȫ�浿", 19, "��", "010-1111-1111", "����", "�ǽù�", "IT", "������", "�ָ�", "3~6�ð�", "����", 121313));
//		rs.add(new Resume("���Ѽ�", 23, "��", "010-2111-1111", "����", "������", "ī��", "1���� �̻�", "����", "3~6�ð�", "��õ", 123131));
//		rs.add(new Resume("��Į��", 29, "��", "010-3111-1111", "����", "ī��", "��Ʈ", "3���� �̻�", "�ָ�", "3~6�ð�", "�泲", 122115));
//		rs.add(new Resume("�����", 24, "��", "010-4111-1111", "����", "�������", "���", "������", "����", "3~6�ð�", "����", 1278552));
//		rs.add(new Resume("�̴�ȣ", 26, "��", "010-5111-1111", "����", "������", "���", "3���� �̻�", "�ָ�", "3~6�ð�", "���", 234211));
//		rs.add(new Resume("�κ���", 32, "��", "010-6111-1111", "����", "������", "��Ʈ", "1���� �̻�", "����", "3~6�ð�", "��õ", 212311));

	}
}
