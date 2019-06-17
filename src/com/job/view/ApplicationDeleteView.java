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

	// 기호 코드
	String bNo;
	String category; // pt.get(i)의 근무형태 변수
	String bName; // pt.get(i)의 업장명 변수
	String timeTotime2; // pt.get(i)의 근무시간 변수
	String pay; // pt.get(i)의 시급 변수
	String region2; // pt.get(i)의 주소 변수
	String timeType; // pt.get(i)의 몇시까지의 시간 변수
	String periodType2; // pt.get(i)의 기간 변수

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
		DtmStorage.setColumnIdentifiers(new String[] { "업장명", "시급", "근무시간", "근무형태", "기간", "시간", "주소" });
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

		ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/메인틀.jpg").getImage());
		add(imgPanel);

		imgPanel.setBounds(0, 0, 1000, 600);
		add(imgPanel);
		imgPanel.setLayout(null);
		// frame.pack();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		add(panel);
		panel.setLayout(null);

		// ' 지원 취소 ' 버튼 - 첫번쨰 팝업창으로 넘어감

		JButton deleteButton = new JButton("");
		deleteButton.setBackground(new Color(255, 215, 0));
		deleteButton.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/deleteButton.jpg")));
		deleteButton.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
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
					System.out.println("지원취소할 구인공고를 선택하세요");
					// 팝업 알림창
					JDialog notice = new JDialog(win, "선택알림창", false);
					notice.setBounds(300, 150, 400, 300);
					notice.getContentPane().setLayout(null);

					JLabel label = new JLabel("취소할 구인공고를 선택하세요");
					label.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setBounds(40, 70, 300, 20);
					notice.getContentPane().add(label);
					
					// 확인버튼
					JButton ans = new JButton("확인");
					ans.setBounds(150, 150, 80, 50);
					ans.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
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

		// 테이블
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(41, 121, 901, 335);
		imgPanel.add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel();
		searchTable = new JTable(DtmStorage);

		// 테이블 행 타이틀
		DtmStorage.setColumnIdentifiers(new String[] { "업장명", "시급", "근무시간", "근무형태", "기간", "시간", "주소" });
		DtmStorage.addRow(new Object[] { bName, pay, timeTotime2, category, periodType2, timeType, region2 });
		// 테이블에 행 삽입

		// 여기 데이터 기호씨에게서 받아야 함 Connection_Table

		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // 테이블 셀 마우스로 이동 못하게
		searchTable.setAutoCreateRowSorter(true);
		// searchTable.setCellSelectionEnabled(rootPaneCheckingEnabled);
		searchTable.setRowHeight(50);
		searchTable.getSelectedRow();
		scrollPane.setViewportView(searchTable);

		// 기호 코드
		// 조회하기 = loadApplicationList
//		JButton searchB = new JButton("\uC870\uD68C\uD558\uAE30");
//		searchB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tableSetting();
//
//			}
//		});
//		searchB.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
//		searchB.setBounds(438, 496, 135, 37);
//		imgPanel.add(searchB);

		// <<뒤로가기 버튼
		JButton backButton = new JButton("");
		backButton.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/backButton.jpg")));
		backButton.setBackground(new Color(255, 215, 0));
		backButton.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
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

		// 첫 번째 팝업창

		private Image img;

		public Modal(Window parent, int row) {

			super(parent, "지원 취소", ModalityType.APPLICATION_MODAL);
			setSize(400, 260);
			setLayout(null);
			setBounds(400, 300, 400, 260);

			ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/팝업틀1.jpg").getImage());

			imgPanel.setBounds(0, 0, 400, 260);
			getContentPane().add(imgPanel);
			add(imgPanel);
			imgPanel.setLayout(null);

			JLabel lb = new JLabel("선택 된 지원을 취소하시겠습니까?");
			lb.setFont(new Font("나눔스퀘어", Font.PLAIN, 16));
			lb.setBounds(80, 60, 400, 50);

			// 지원을 취소하시겠습니까? '예' 버튼

			// yesBtn.setIcon(new
			// ImageIcon(ResumeDelete.class.getResource("/resourses/\uB4A4\uB85C\uAC00\uAE302.jpg")));

			JButton yesBtn = new JButton("예");
			yesBtn.setBounds(100, 150, 60, 30);
			yesBtn.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/yesBtn.jpg")));
			yesBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
			yesBtn.setBorderPainted(false);
			yesBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					yesBtn(row);

					// +배열에서 삭제하는 코드 구현

					// pt.remove(1); //pt2.remove();
					// win.rd.setPt(pt); //덮어쓰는 코드

					dispose();
					Modal2 m2 = new Modal2(frame);
					m2.setVisible(true);

				}
			});

			// 지원을 취소하시겠습니까? '아니오'버튼 - 메인화면으로 돌아감

			JButton noBtn = new JButton("아니오");
			noBtn.setBounds(225, 150, 73, 30);
			noBtn.setIcon(new ImageIcon(ApplicationDeleteView.class.getResource("/resourses/noBtn.jpg")));
			noBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));

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
//      dao.saveConnection(어쩌구);
//   }

//       for ( int i = 0 ; i<pt.size() ; i++ ) {
//          
//          
//          
//       }

	}

	public class Modal2 extends JDialog {

		// 두번째 팝업창

		public Modal2(Window parent) {

			super(parent, "지원 취소 완료", ModalityType.APPLICATION_MODAL);
			setSize(400, 260);
			setLayout(null);
			setBounds(400, 300, 400, 260);

			ImagePanel imgPanel = new ImagePanel(new ImageIcon("./image/팝업틀2.jpg").getImage());

			imgPanel.setBounds(0, 0, 400, 260);
			getContentPane().add(imgPanel);
			add(imgPanel);
			imgPanel.setLayout(null);

			JLabel lb = new JLabel("지원 취소가 완료되었습니다.");
			lb.setFont(new Font("나눔스퀘어", Font.PLAIN, 16));
			lb.setBounds(95, 40, 400, 50);
			JLabel lb2 = new JLabel("지원 목록으로 돌아갑니다.");
			lb2.setFont(new Font("나눔스퀘어", Font.PLAIN, 16));
			lb2.setBounds(100, 70, 400, 50);

			// 확인 버튼
			// 선택 된 취소항목 제외한 목록 보여줌

			JButton okBtn = new JButton("확인");
			okBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
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