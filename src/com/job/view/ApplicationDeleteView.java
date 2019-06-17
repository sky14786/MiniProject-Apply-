package com.job.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//import com.resume.run.Run;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.job.controller.ApplicationDeleteController;
import com.job.controller.LoadApplicationListController;
import com.job.model.Notice;
import com.job.model.dao.LoadSave;
import com.job.run.Run;
import com.job.model.Connection;

public class ApplicationDeleteView extends JPanel {

	private ArrayList<Notice> pt = new ArrayList<Notice>();
	private ArrayList<Notice> pt2 = new ArrayList<Notice>();
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private LoadSave dao = LoadSave.getDao();
	private LoadApplicationListController loadController = new LoadApplicationListController();
	private ApplicationDeleteController applicationDeleteController = new ApplicationDeleteController();

	private DefaultTableModel DtmStorage;
	private JTable searchTable;
	private JScrollPane scrollPane;
	private JButton btnDelete;
	private JButton btnBack;
	// public Run win = new Run();

	private Image img;

	// private ResumeDelete2 resumeDelete2 = new ResumeDelete2();

	// ��ȣ �ڵ�
	String bNo;
	String category; // pt.get(i)�� �ٹ����� ����
	String bName; // pt.get(i)�� ����� ����
	String timeTotime2; // pt.get(i)�� �ٹ��ð� ����
	String pay; // pt.get(i)�� �ñ� ����
	String region2; // pt.get(i)�� �ּ� ����
	String timeType; // pt.get(i)�� ��ñ����� �ð� ����
	String periodType2; // pt.get(i)�� �Ⱓ ����

//   private JFrame frame;

	private static final long serialVersionUID = 1L;
	private JPanel jobTable;
	private JButton searchButton;
	private JComboBox<?> typeOccurType;
	public Run win = new Run();
	private JFrame frame;
	private LoadApplicationListController loadALC = new LoadApplicationListController();

	public ApplicationDeleteView(Run win) {
		this.win = win;
		initialize();

	}

	public void tableSetting() {
		DtmStorage.setNumRows(0);
		DtmStorage.setColumnIdentifiers(new String[] { "�����", "�ñ�", "�ٹ��ð�", "�ٹ�����", "�Ⱓ", "�ð�", "�ּ�" });
		DtmStorage.addRow(new Object[] { bNo, pay, timeTotime2, category, periodType2, timeType, region2 });
		ArrayList<Notice> myApply = loadALC.loadApplicationList();
		DtmStorage.setNumRows(0);

		for (int i = 0; i < myApply.size(); i++) {
			bNo = Integer.toString(myApply.get(i).getbNo());
			category = myApply.get(i).getCategory();
			bName = myApply.get(i).getbName();
			timeTotime2 = myApply.get(i).getTimeTotime();
			pay = Double.toString(myApply.get(i).getPay());
			region2 = myApply.get(i).getAddr();
			timeType = myApply.get(i).getTimeType();
			periodType2 = myApply.get(i).getPeriodType();

			DtmStorage.addRow(
					new String[] { (String) bName, pay, timeTotime2, category, periodType2, timeType, region2 });
		}
	}

	private void initialize() {

		setBounds(100, 100, 1000, 600);
		setLayout(null);

		ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/����Ʋ.jpg").getImage());
		add(imgPanel);

		imgPanel.setBounds(0, 0, 1000, 600);
		add(imgPanel);
		imgPanel.setLayout(null);
		// frame.pack();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		add(panel);
		panel.setLayout(null);

		// ' ���� ��� ' ��ư - ù���� �˾�â���� �Ѿ

		JButton deleteButton = new JButton("");
		deleteButton.setBackground(new Color(255, 215, 0));
		deleteButton.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/deleteButton.jpg")));
		deleteButton.setFont(new Font("����������", Font.PLAIN, 14));
		deleteButton.setBorderPainted(false);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = searchTable.getSelectedRow();
				
				if(row>=0) {
					Modal m = new Modal(frame, row);
					m.setVisible(true);
				}
				else {
					System.out.println("��������� ���ΰ��� �����ϼ���");
					// �˾� �˸�â
					JDialog notice = new JDialog(win, "���þ˸�â", false);
					notice.setBounds(300, 150, 400, 300);
					notice.getContentPane().setLayout(null);

					JLabel label = new JLabel("����� ���ΰ��� �����ϼ���");
					label.setFont(new Font("���������� Bold", Font.PLAIN, 20));
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setBounds(40, 70, 300, 20);
					notice.getContentPane().add(label);
					
					// Ȯ�ι�ư
					JButton ans = new JButton("Ȯ��");
					ans.setBounds(150, 150, 80, 50);
					ans.setFont(new Font("����������", Font.PLAIN, 15));
					ans.setVisible(true);
					notice.getContentPane().add(ans);
					ans.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							notice.setVisible(false);
						}
					});

					notice.setVisible(true);
				}

			}
		});
		deleteButton.setBounds(560, 496, 200, 50);
		imgPanel.add(deleteButton);

		// ���̺�
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(41, 121, 901, 335);
		imgPanel.add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel();
		searchTable = new JTable(DtmStorage);

		// ���̺� �� Ÿ��Ʋ
		DtmStorage.setColumnIdentifiers(new String[] { "�����", "�ñ�", "�ٹ��ð�", "�ٹ�����", "�Ⱓ", "�ð�", "�ּ�" });
		DtmStorage.addRow(new Object[] { bName, pay, timeTotime2, category, periodType2, timeType, region2 });
		// ���̺� �� ����

		// ���� ������ ��ȣ�����Լ� �޾ƾ� �� Connection_Table

		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // ���̺� �� ���콺�� �̵� ���ϰ�
		searchTable.setAutoCreateRowSorter(true);
		// searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();
		scrollPane.setViewportView(searchTable);

		// ��ȣ �ڵ�
		// ��ȸ�ϱ� = loadApplicationList
//		JButton searchB = new JButton("\uC870\uD68C\uD558\uAE30");
//		searchB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tableSetting();
//
//			}
//		});
//		searchB.setFont(new Font("����������", Font.PLAIN, 15));
//		searchB.setBounds(438, 496, 135, 37);
//		imgPanel.add(searchB);

		// <<�ڷΰ��� ��ư
		JButton backButton = new JButton("");
		backButton.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/backButton.jpg")));
		backButton.setBackground(new Color(255, 215, 0));
		backButton.setFont(new Font("����������", Font.PLAIN, 14));
		backButton.setBorderPainted(false);
		backButton.setBounds(220, 496, 200, 50);
		imgPanel.add(backButton);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				win.getContentPane().removeAll();
				win.getContentPane().add(win.getPartMainView());
				win.setSize(1000, 600);
				revalidate();
				repaint();
				win.getPartMainView().buttonTest();
				win.getPartMainView().showId();
				win.setVisible(false);
				win.setVisible(true);

			}
		});

		pt = dao.loadNoitce();

		tableSetting();

	}

	class ImagePanel extends JPanel {

		private Image img;

		public ImagePanel(Image img) {

			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));

		}

		public void paintComponent(Graphics g) {

			g.drawImage(img, 0, 0, null);
		}
	}

	public class Modal extends JDialog {

		// ù ��° �˾�â

		private Image img;

		public Modal(Window parent, int row) {

			super(parent, "���� ���", ModalityType.APPLICATION_MODAL);
			setSize(400, 260);
			setLayout(null);
			setBounds(400, 300, 400, 260);

			ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/�˾�Ʋ1.jpg").getImage());

			imgPanel.setBounds(0, 0, 400, 260);
			getContentPane().add(imgPanel);
			add(imgPanel);
			imgPanel.setLayout(null);

			JLabel lb = new JLabel("���� �� ������ ����Ͻðڽ��ϱ�?");
			lb.setFont(new Font("����������", Font.PLAIN, 16));
			lb.setBounds(80, 60, 400, 50);

			// ������ ����Ͻðڽ��ϱ�? '��' ��ư

			// yesBtn.setIcon(new
			// ImageIcon(ResumeDelete.class.getResource("/resourses/\uB4A4\uB85C\uAC00\uAE302.jpg")));

			JButton yesBtn = new JButton("��");
			yesBtn.setBounds(100, 150, 60, 30);
			yesBtn.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/yesBtn.jpg")));
			yesBtn.setFont(new Font("����������", Font.PLAIN, 14));
			yesBtn.setBorderPainted(false);
			yesBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					yesBtn(row);

					// +�迭���� �����ϴ� �ڵ� ����

					// pt.remove(1); //pt2.remove();
					// win.rd.setPt(pt); //����� �ڵ�

					dispose();
					Modal2 m2 = new Modal2(frame);
					m2.setVisible(true);

				}
			});

			// ������ ����Ͻðڽ��ϱ�? '�ƴϿ�'��ư - ����ȭ������ ���ư�

			JButton noBtn = new JButton("�ƴϿ�");
			noBtn.setBounds(225, 150, 73, 30);
			noBtn.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/noBtn.jpg")));
			noBtn.setFont(new Font("����������", Font.PLAIN, 14));

			// ImageIcon(ResumeDelete.class.getResource("/resourses/noBtn4.jpg")));
			noBtn.setBorderPainted(false);
			noBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					dispose();
				}
			});

			add(lb);
			add(noBtn);
			add(yesBtn);

		}

	}

	public void yesBtn(int row) {

		applicationDeleteController.deleteApplicationFromConnection(row);
		tableSetting();

//		int row = searchTable.getSelectedRow();
//		if (row == -1)
//			return;
//
//		DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
//		System.out.println(model.getValueAt(row, 0));
//		model.removeRow(row);
//
//		pt.remove(row);
//
//		System.out.println(pt.size());

		// delController.delApplicationList();

//      save = dao.saveConnection();
//      pt = dao.loadPartimer();
//      for (int i = 0; i < pt.size(); i++) {
//         if (pt.get(i).getUserNo() == UserNo) {
//            pt.remove(i);
//            break;
//         }
//      }
//      dao.saveConnection(��¼��);
//   }

//       for ( int i = 0 ; i<pt.size() ; i++ ) {
//          
//          
//          
//       }

	}

	public class Modal2 extends JDialog {

		// �ι�° �˾�â

		public Modal2(Window parent) {

			super(parent, "���� ��� �Ϸ�", ModalityType.APPLICATION_MODAL);
			setSize(400, 260);
			setLayout(null);
			setBounds(400, 300, 400, 260);

			ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/�˾�Ʋ2.jpg").getImage());

			imgPanel.setBounds(0, 0, 400, 260);
			getContentPane().add(imgPanel);
			add(imgPanel);
			imgPanel.setLayout(null);

			JLabel lb = new JLabel("���� ��Ұ� �Ϸ�Ǿ����ϴ�.");
			lb.setFont(new Font("����������", Font.PLAIN, 16));
			lb.setBounds(95, 40, 400, 50);
			JLabel lb2 = new JLabel("���� ������� ���ư��ϴ�.");
			lb2.setFont(new Font("����������", Font.PLAIN, 16));
			lb2.setBounds(100, 70, 400, 50);

			// Ȯ�� ��ư
			// ���� �� ����׸� ������ ��� ������

			JButton okBtn = new JButton("Ȯ��");
			okBtn.setFont(new Font("����������", Font.PLAIN, 14));
			okBtn.setBounds(160, 150, 73, 30);
			okBtn.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/okBtn.jpg")));
			okBtn.setBorderPainted(false);
			okBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});

			add(lb);
			add(lb2);
			add(okBtn);

		}

	}
}