package com.job.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.job.controller.NoticeRegisterController;
import com.job.model.Connection;
import com.job.model.Notice;
import com.job.model.Resume;
import com.job.model.dao.LoadSave;
import com.job.run.Run;

//����,�ؿ�
public class OwnerMainView extends JPanel {
	private JTable table;
	private DefaultTableModel Dtm;
	private ArrayList<Resume> resumes = new ArrayList<Resume>();
	private ArrayList<Notice> notices = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private Connection connection = null;
	private JButton btnShowNoticeReg, btnShowMyNotice, btnsShowSearchView, btnDetailView, btnLogout;

	private NoticeRegisterController nrc = new NoticeRegisterController();
	private LoadSave dao = LoadSave.getDao();
	private Run win = new Run();

	public OwnerMainView(Run win) {
		this.win = win;
		setLayout(null);
		setSize(1000, 600);
		btnShowNoticeReg = new JButton("");
		btnShowNoticeReg.setBackground(Color.WHITE);
		btnShowNoticeReg.setBounds(97, 177, 161, 66);
		btnShowNoticeReg.setIcon(new ImageIcon(this.getClass().getResource("/resource/NoticeReg.png")));
		btnShowNoticeReg.setContentAreaFilled(false);
		btnShowNoticeReg.setBorderPainted(false);
		add(btnShowNoticeReg);

		btnShowMyNotice = new JButton("");
		btnShowMyNotice.setBackground(Color.WHITE);
		btnShowMyNotice.setBounds(268, 177, 161, 66);
		btnShowMyNotice.setIcon(new ImageIcon(this.getClass().getResource("/resource/MyNotice.png")));
		btnShowMyNotice.setContentAreaFilled(false);
		btnShowMyNotice.setBorderPainted(false);

		add(btnShowMyNotice);

		btnsShowSearchView = new JButton("");
		btnsShowSearchView.setBackground(Color.WHITE);
		btnsShowSearchView.setForeground(Color.BLACK);
		btnsShowSearchView.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchBtn.png")));
		btnsShowSearchView.setContentAreaFilled(false);
		btnsShowSearchView.setBorderPainted(false);

		btnsShowSearchView.setBounds(739, 128, 132, 66);
		add(btnsShowSearchView);
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		String[] colnum = { "", "", "", "" };
		Dtm = new DefaultTableModel(colnum, 0) {
			// �� ����Ŭ���� ������ ����
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		// ------------------------------------------���̺���----------------------------------------------------
		table = new JTable(Dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setReorderingAllowed(false); // ���̺� �÷� �̵�����
		table.getTableHeader().setResizingAllowed(false); // ���̺� �÷� ���������
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ���̺� �ο� �Ѱ�����
		table.setRowHeight(40);
		table.setFont(new Font("����������", Font.PLAIN, 14));
		Dtm.setColumnIdentifiers(new String[] { "�̸�", "����", "����", "��ȭ��ȣ" });
		// -----------------------------------------------------------------------------------------
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setEnabled(false);
		scrollPane1.setBounds(99, 255, 786, 320);
		add(scrollPane1);

		// �󼼺��� ��ư
		btnDetailView = new JButton("\uC0C1\uC138\uBCF4\uAE30");
		btnDetailView.setIcon(new ImageIcon(this.getClass().getResource("/resource/OpenBtn.png")));
		btnDetailView.setContentAreaFilled(false);
		btnDetailView.setBorderPainted(false);
		btnDetailView.setBounds(443, 198, 105, 27);
		add(btnDetailView);
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		btnLogout = new JButton("");
		btnLogout.setBounds(874, 44, 112, 28);
		btnLogout.setIcon(new ImageIcon(this.getClass().getResource("/resource/LogoutBtn.png")));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		add(btnLogout);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/OwnerMainView.jpg")));
		label.setBounds(0, 0, 1000, 600);
		add(label);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		table.getTableHeader().setReorderingAllowed(false); // �÷��� �̵� �Ұ�
		table.getTableHeader().setResizingAllowed(false); // �÷� ũ�� ���� �Ұ�
		table.setFocusable(false);

		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(dtcr);
		}

		Dtm.setNumRows(0);
		showResume();
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------

		settingButton();

	}

	// ���� ��� ȭ�� ����
	private void showNoticeReg() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getNoticeRegisterView());
		win.setVisible(false);
		win.setVisible(true);
		revalidate();
		repaint();
	}

	// �� ���� Ȯ��
	private void showMyNotice() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getNoticeUpdateView());
		revalidate();
		repaint();
		win.getNoticeUpdateView().settingData();
		win.setVisible(false);
		win.setVisible(true);

	}

	// �˻�ȭ�� ����
	private void showSearchView() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getSearchView());
		revalidate();
		repaint();
		win.setSize(1000, 620);
		win.getSearchView().normalSearch(); // ������ ��ü��ȸ �޼ҵ�
		win.setVisible(false);
		win.setVisible(true);
	}

	// Table�� Row �ʱ�ȭ
	public void resetDTM() {
		Dtm.setNumRows(0);
	}

	// �α׾ƿ� �޼ҵ�
	private void logout() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getLoginView());
		win.setSize(590, 590);
		revalidate();
		repaint();
	}

	// OwnerMainView ���Խÿ� ���� �ø� ���ΰ��� ������ �����ڸ� �����ִ� �޼ҵ�
	public void showResume() {
		ArrayList<Connection> connections = dao.loadConnection();
		Connection connection = new Connection();
		ArrayList<Resume> resumes = null;
		resetDTM();
		if (connections != null) {
			for (int i = 0; i < connections.size(); i++) {
				if (connections.get(i).getNoticeNo() == dao.getNowUser()) {
					connection = connections.get(i);
					break;
				}
			}

			if (connection.getResumes() != null) {
				resumes = connection.getResumes();
				System.out.println("-------------------------------------------");
				System.out.println("Now Notice : " + connection.getNoticeNo());
				System.out.println("Now Resumes Count : " + connection.getResumes().size());
				System.out.println("Now Resumes : " + connection.getResumes().toString());
				System.out.println("-------------------------------------------");

				if (resumes.size() > 0) {
					for (int i = 0; i < resumes.size(); i++) {
						Dtm.addRow(new String[] { resumes.get(i).getName(), Integer.toString(resumes.get(i).getAge()),
								resumes.get(i).getGender(), resumes.get(i).getPhone() });
					}
				}
			}

		}
	}

	// ��ư ��� ���� �޼ҵ�
	private void settingButton() {
		btnShowMyNotice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showMyNotice();
			}
		});
		btnShowNoticeReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNoticeReg();
			}
		});

		btnsShowSearchView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showSearchView();
			}
		});

		btnDetailView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = table.getSelectedRow();
				win.getOwnerDetailView().OwnerDetailButton1(seeMore(num));

			}
		});

		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
	}

	// ��ư�� Ȱ��ȭ ���� üũ �޼ҵ�
	public void isNoticeTest() {
		if (nrc.isApplyCheck()) {
			System.out.println();
			btnShowNoticeReg.setEnabled(true);
			btnShowMyNotice.setEnabled(false);
		} else {
			btnShowMyNotice.setEnabled(true);
			btnShowNoticeReg.setEnabled(false);
		}
	}

	// �󼼺���
	public Resume seeMore(int num) {
		Resume temp = new Resume();
		ArrayList<Resume> arr = LoadSave.getDao().loadResume();
		ArrayList<Connection> con = LoadSave.getDao().loadConnection();

		if (num == -1) {

			// �ƹ��͵� �������� �ʰ� �����ϱ⸦ Ŭ��������
			// �ȳ��޼���

			JOptionPane.showMessageDialog(null, "���Ͻô� �˹ٸ� �������ּ���!");

			System.out.println("���� ����");

		} else if (num != -1) {
			for (int i = 0; i < con.size(); i++) {
				if (con.get(i).getNoticeNo() == dao.getNowUser()) {
					arr = con.get(i).getResumes();
				}
			}

			temp.setName(arr.get(num).getName());
			temp.setAge(arr.get(num).getAge());
			temp.setGender(arr.get(num).getGender());
			temp.setPhone(arr.get(num).getPhone());
			temp.setCareer(arr.get(num).getCareer());
			temp.setPeriodType(arr.get(num).getPeriodType());
			temp.setTypeOccup(arr.get(num).getTypeOccup());
			temp.setPeriodType(arr.get(num).getPeriodType());
			temp.setDow(arr.get(num).getDow());
			temp.setTime(arr.get(num).getTime());
			temp.setRegion(arr.get(num).getRegion());
			temp.setAcademic(arr.get(num).getAcademic());

			System.out.println(temp.toString());

			win.getContentPane().removeAll();
			win.getContentPane().add(win.getOwnerDetailView());
			revalidate();
			repaint();
			win.setSize(581, 800);
			win.setVisible(false);
			win.setVisible(true);

		}

		return temp;
	}
}
