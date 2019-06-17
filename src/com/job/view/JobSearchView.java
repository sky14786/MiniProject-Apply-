package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.job.controller.CheckingController;
import com.job.controller.JobSearchController;
import com.job.model.dao.LoadSave;
import com.job.run.Run;

//객체 임포트

public class JobSearchView extends JPanel {

	DummyData mm = new DummyData();
	JobSearchController jsc = new JobSearchController();
	JobSearchView2 sub = new JobSearchView2();
	public DefaultTableModel DtmStorage;
	public int row;
	PartMainView pm = new PartMainView();
	public static String periodType; // comBobox에서 가져온 요일
	public static String typeOccup; // comBobox에서 가져온 직종
	public static String region; // comBobox에서 가져온 지역
	public static String timeTotime; // comBobox에서 가져온 몇시간

	private JComboBox<Object> regionType, periodCombobox, timeTotimeCombo;

	private static final long serialVersionUID = 1L;
	public JTable searchTable;
	private JButton searchButton;
	private JComboBox<?> typeOccurType;
	private JScrollPane scrollPane;
	private Run win = new Run();
	private LoadSave dao = LoadSave.getDao();
	
	private CheckingController checkingController = new CheckingController();

	public JobSearchView() {

	}

	public JobSearchView(Run win) {
		// this.win = win;
		//setBounds(100, 100, 1000, 600);
		setLayout(null);

		setSize(1000, 600);

		// 직종 ComboBox
		typeOccurType = new JComboBox<Object>();
		typeOccurType.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		typeOccurType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				typeOccup = typeOccurType.getSelectedItem().toString();

			}
		});

		typeOccurType.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34 \uD615\uD0DC]", "\uB9E4\uC7A5\uAD00\uB9AC", "\uC8FC\uBC29",
						"\uBBF8\uB514\uC5B4", "\uC6B4\uC804", "\uC0AC\uBB34", "IT", "\uC601\uC5C5", "\uAD50\uC721" }));
		typeOccurType.setSelectedIndex(0);
		typeOccurType.setBounds(402, 92, 192, 35);
		add(typeOccurType);

		// 테이블
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 216, 901, 335);
		add(scrollPane);

		String[] colum = { "", "", "", "", "", "", "" };
		DtmStorage = new DefaultTableModel(colum, 0) {
			public boolean isCellEditable(int row, int colunm) {
				return false;
			}
		};

		// ------------------------------------------테이블설정----------------------------------------------------
		searchTable = new JTable(DtmStorage);
		searchTable.setEnabled(true);
		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.setAutoCreateRowSorter(true);
		searchTable.getTableHeader().setResizingAllowed(false); // 테이블 컬럼 사이즈고정
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우 한개선택
		searchTable.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));

		// 테이블 행 타이틀
		DtmStorage.setColumnIdentifiers(new String[] { "업장번호", "업장명", "시급", "근무시간", "근무형태", "기간", "시간", "주소", "키워드 1",
				"키워드 2", "키워드 3", "추가 설명" });
		// 키워드랑 상세설명은 상세설명 클래스에서 보여주기

		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		searchTable.getTableHeader().setReorderingAllowed(false); // 테이블 셀 마우스로 이동 못하게
		searchTable.setAutoCreateRowSorter(true);
		searchTable.setRowHeight(40);
		searchTable.getSelectedRow();
		// -----------------------------------------------------------------------------------------------------------------
//       화면이 나올때 전체 출력
//       jsc.printAll();
//       for(int i = 0; i < jsc.notice2.size(); i++)
//       {
//    	   DtmStorage.addRow(new Object[] { jsc.notice2.get(i).getbNo(), jsc.notice2.get(i).getbName(),
//    			   jsc.notice2.get(i).getPay(), jsc.notice2.get(i).getTimeTotime(), jsc.notice2.get(i).getCategory(),
//    			   jsc.notice2.get(i).getPeriodType(), jsc.notice2.get(i).getTimeType(), jsc.notice2.get(i).getAddr(),
//    			   jsc.notice2.get(i).getbKeyword1(), jsc.notice2.get(i).getbKeyword2(), jsc.notice2.get(i).getbKeyword3(),
//    			   jsc.notice2.get(i).getEtc() });
//       }

		// 키워드 1 항목 숨기기
		searchTable.getColumn("키워드 1").setWidth(0);
		searchTable.getColumn("키워드 1").setMinWidth(0);
		searchTable.getColumn("키워드 1").setMaxWidth(0);

		// 키워드 2 항목 숨기기
		searchTable.getColumn("키워드 2").setWidth(0);
		searchTable.getColumn("키워드 2").setMinWidth(0);
		searchTable.getColumn("키워드 2").setMaxWidth(0);

		// 키워드 3 항목 숨기기
		searchTable.getColumn("키워드 3").setWidth(0);
		searchTable.getColumn("키워드 3").setMinWidth(0);
		searchTable.getColumn("키워드 3").setMaxWidth(0);

		// 추가 설명 항목 숨기기
		searchTable.getColumn("추가 설명").setWidth(0);
		searchTable.getColumn("추가 설명").setMinWidth(0);
		searchTable.getColumn("추가 설명").setMaxWidth(0);

		// 추가 설명 항목 숨기기
		searchTable.getColumn("업장번호").setWidth(0);
		searchTable.getColumn("업장번호").setMinWidth(0);
		searchTable.getColumn("업장번호").setMaxWidth(0);

		scrollPane.setViewportView(searchTable);

		// 셀 내용 가운데 정렬
		DefaultTableCellRenderer DtmCellRender = new DefaultTableCellRenderer();
		DtmCellRender.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = searchTable.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(DtmCellRender);
		}

		// 지역 ComboBox
		regionType = new JComboBox<Object>();
		regionType.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		regionType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				region = regionType.getSelectedItem().toString();

			}
		});
		regionType.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34 \uC9C0\uC5ED]", "\uAC15\uC6D0",
				"\uACBD\uAE30", "\uACBD\uB0A8", "\uACBD\uBD81", "\uAD11\uC8FC", "\uB300\uAD6C", "\uB300\uC804",
				"\uC11C\uC6B8", "\uC138\uC885", "\uC6B8\uC0B0", "\uC778\uCC9C", "\uC804\uB0A8", "\uC804\uBD81",
				"\uC81C\uC8FC", "\uBD80\uC0B0", "\uCDA9\uB0A8", "\uCDA9\uBD81" }));
		regionType.setSelectedIndex(0);
		regionType.setBounds(130, 92, 144, 35);
		add(regionType);

		// 요일 ComboBox
		periodCombobox = new JComboBox<Object>();
		periodCombobox.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		periodCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				periodType = periodCombobox.getSelectedItem().toString();

			}
		});
		periodCombobox.setModel(new DefaultComboBoxModel(
				new String[] { "[\uAE30\uAC04 \uC120\uD0DD]", "\uD558\uB8E8", "\uC77C\uC8FC\uC77C",
						"1\uAC1C\uC6D4 \uC774\uC0C1", "3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1" }));
		periodCombobox.setSelectedIndex(0);
		periodCombobox.setBounds(402, 161, 130, 35);
		add(periodCombobox);

		// 검색버튼
		searchButton = new JButton("");
		searchButton.setBorderPainted(false);
		searchButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchBtn.jpg")));
		searchButton.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DtmStorage.setNumRows(0);
				jsc.search(region, typeOccup, timeTotime, periodType);
				for (int i = 0; i < jsc.notice2.size(); i++) {
					DtmStorage.addRow(new Object[] { jsc.notice2.get(i).getbNo(), jsc.notice2.get(i).getbName(),
							jsc.notice2.get(i).getPay(), jsc.notice2.get(i).getTimeTotime(),
							jsc.notice2.get(i).getCategory(), jsc.notice2.get(i).getPeriodType(),
							jsc.notice2.get(i).getTimeType(), jsc.notice2.get(i).getAddr(),
							jsc.notice2.get(i).getbKeyword1(), jsc.notice2.get(i).getbKeyword2(),
							jsc.notice2.get(i).getbKeyword3(), jsc.notice2.get(i).getEtc() });

				}

			}
		}

		);
		searchButton.setBounds(741, 128, 194, 35);
		add(searchButton);

		// 상세보기 버튼
		JButton viewMore = new JButton("");
		viewMore.setBorderPainted(false);
		viewMore.setIcon(new ImageIcon(this.getClass().getResource("/resource/SeeMoreBtn.jpg")));
		viewMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				row = searchTable.getSelectedRow();
				if (row > -1) {
					sub.subSearch2(jsc.seeMore(row));
				} else {
					JOptionPane.showMessageDialog(null, "원하시는 알바를 선택해 주세요.");

				}

			}
		});
		viewMore.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));

		viewMore.setBounds(844, 173, 91, 35);
		add(viewMore);

		// 지원하기 버튼
		JButton apply = new JButton("");
		apply.setBorderPainted(false);
		apply.setIcon(new ImageIcon(this.getClass().getResource("/resource/ApplyBtn.jpg")));
		apply.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int check = checkingController.isApplyCheck();
				System.out.println("이력서 존재여부 : " + check);
				
				if (check == 2) {	//이력서 있음(지원됨)
					row = searchTable.getSelectedRow();
					jsc.search2(searchTable.getSelectedRow());
				}
				else if (check == 3) {	//이력서 없음(지원불가)
					// 팝업 알림창
					JDialog notice = new JDialog(win, "지원불가 알림창", false);
					notice.setBounds(300, 150, 400, 300);
					notice.getContentPane().setLayout(null);

					JLabel label1 = new JLabel("먼저 이력서를 등록한 후에");
					label1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
					label1.setHorizontalAlignment(SwingConstants.CENTER);
					label1.setBounds(40, 70, 300, 20);
					notice.getContentPane().add(label1);
					
					JLabel label2 = new JLabel("지원해주세요^-^");
					label2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
					label2.setHorizontalAlignment(SwingConstants.CENTER);
					label2.setBounds(85, 100, 200, 20);
					notice.getContentPane().add(label2);
					
					// 삭제 진행 취소 버튼
					JButton ans = new JButton("OK");
					ans.setBounds(155, 150, 80, 50);
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
				else {	//유저찾기 실패(지원불가)
					System.out.println("유저찾기 실패");
				}
			}
		});
		apply.setBounds(741, 173, 91, 35);
		add(apply);

		timeTotimeCombo = new JComboBox<Object>();
		timeTotimeCombo.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		timeTotimeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				timeTotime = timeTotimeCombo.getSelectedItem().toString();
			}
		});
		timeTotimeCombo.setModel(new DefaultComboBoxModel(new String[] { "[\uC2DC\uAC04 \uC120\uD0DD]",
				"1\uC2DC\uAC04 ~ 3\uC2DC\uAC04", "3\uC2DC\uAC04 ~ 6\uC2DC\uAC04", "6\uC2DC\uAC04 ~ 8\uC2DC\uAC04",
				"8\uC2DC\uAC04 \uC774\uC0C1" }));
		timeTotimeCombo.setSelectedIndex(0);
		timeTotimeCombo.setBounds(130, 161, 130, 35);
		add(timeTotimeCombo);

		// 뒤로가기 버튼
		JButton resetButton = new JButton("");
		resetButton.setBorderPainted(false);
		resetButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton2.jpg")));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				win.getContentPane().removeAll();
				win.getContentPane().add(win.getPartMainView());
				win.getContentPane().revalidate();
				win.getContentPane().repaint();

			}
		});
		resetButton.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		resetButton.setBounds(741, 38, 194, 35);
		add(resetButton);

		// 전체 보기 버튼
		JButton allView = new JButton("");
		allView.setBorderPainted(false);
		allView.setIcon(new ImageIcon(this.getClass().getResource("/resource/AllVeiwBtn.jpg")));
		allView.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		allView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				normalSearch(); // 전체보기 메소드 호출
			}
		});
		allView.setBounds(741, 83, 194, 35);
		add(allView);

		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(this.getClass().getResource("/resource/JobSearchViewMain.jpg")));
		BackGround.setBounds(0, 0, 1000, 600);
		add(BackGround);

	}

	// 전체보기 메소드
	public void normalSearch() {
		jsc.notice2 = dao.loadNoitce();
		DtmStorage.setNumRows(0);
		for (int i = 0; i < jsc.notice2.size(); i++) {
			DtmStorage.addRow(new Object[] { jsc.notice2.get(i).getbNo(), jsc.notice2.get(i).getbName(),
					jsc.notice2.get(i).getPay(), jsc.notice2.get(i).getTimeTotime(), jsc.notice2.get(i).getCategory(),
					jsc.notice2.get(i).getPeriodType(), jsc.notice2.get(i).getTimeType(), jsc.notice2.get(i).getAddr(),
					jsc.notice2.get(i).getbKeyword1(), jsc.notice2.get(i).getbKeyword2(),
					jsc.notice2.get(i).getbKeyword3(), jsc.notice2.get(i).getEtc() });

		}
	}

	public void printTable1(String keyword) {

		JobSearchController jcs = new JobSearchController();
		jsc.notice2 = jcs.keywordSearch(keyword);
		DtmStorage.setRowCount(0);

		System.out.println("키워드검색 결과 : " + jsc.notice2.toString());

		for (int i = 0; i < jsc.notice2.size(); i++) {

			// bNo,bName,pay,timetitime,category,periodtype,timeType,addr,keyword1,2,3,etc

			DtmStorage.addRow(new Object[] { jsc.notice2.get(i).getbNo(), jsc.notice2.get(i).getbName(),
					jsc.notice2.get(i).getPay(), jsc.notice2.get(i).getTimeTotime(), jsc.notice2.get(i).getCategory(),
					jsc.notice2.get(i).getPeriodType(), jsc.notice2.get(i).getTimeType(), jsc.notice2.get(i).getAddr(),
					jsc.notice2.get(i).getbKeyword1(), jsc.notice2.get(i).getbKeyword2(),
					jsc.notice2.get(i).getbKeyword3(), jsc.notice2.get(i).getEtc() });
		}

		if (jsc.notice2.size() == 0) {
			JOptionPane.showMessageDialog(null, "검색 결과가 없습니다!");

		}

	}

}
