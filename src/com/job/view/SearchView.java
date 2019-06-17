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
		// ------------------------------------------테이블설정----------------------------------------------------
		table = new JTable(DtmStorage);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setResizingAllowed(false); // 테이블 컬럼 사이즈고정
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 로우 한개선택
		table.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.getTableHeader().setReorderingAllowed(false); // 테이블 셀 마우스로 이동 못하게
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(40);
		// -----------------------------------------------------------------------

		// DtmStorage.setColumnIdentifiers(new String[] { "resume NO", "직종", "이름", "지역",
		// "근무기간", "근무요일", "전화번호" });
		DtmStorage.setColumnIdentifiers(new String[] { "user no", "직종", "이름", "지역", "근무기간", "근무요일", "전화번호" });

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

		// 검색버튼 기능
		searchButton = new JButton("\uAC80\uC0C9");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 객체명.메소드명(메소드가 받는 인자);
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

		// 메인메뉴로 뒤로가기
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

		// 구직자 전체조회
		JButton button = new JButton("");
		button.setBounds(83, 230, 167, 36);
		button.setIcon(new ImageIcon(this.getClass().getResource("/resource/allSearchBtn.png")));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ** OwnerMainView에서 이력서 열람 버튼 누르자마자 테이블에 표시하기 위해서 기존에 전체보기소스 메소드화 시켯습니다.**
				normalSearch();
			}
		});

		textField = new JTextField();
		textField.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
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

		// 열람
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
					System.out.println("Grid에서 선택해주세요.");
				}

			}
		});
	}

	// 구직자 전체조회 메소드
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
//		rs.add(new Resume("홍길동", 19, "남", "010-1111-1111", "대졸", "피시방", "IT", "일주일", "주말", "3~6시간", "서울", 121313));
//		rs.add(new Resume("강한수", 23, "남", "010-2111-1111", "대졸", "편의점", "카페", "1개월 이상", "평일", "3~6시간", "인천", 123131));
//		rs.add(new Resume("스칼렛", 29, "여", "010-3111-1111", "대졸", "카페", "마트", "3개월 이상", "주말", "3~6시간", "경남", 122115));
//		rs.add(new Resume("장원삼", 24, "남", "010-4111-1111", "고졸", "서브웨이", "배달", "일주일", "평일", "3~6시간", "전남", 1278552));
//		rs.add(new Resume("이대호", 26, "남", "010-5111-1111", "중졸", "편의점", "배달", "3개월 이상", "주말", "3~6시간", "경북", 234211));
//		rs.add(new Resume("민병헌", 32, "남", "010-6111-1111", "대졸", "편의점", "마트", "1개월 이상", "평일", "3~6시간", "인천", 212311));

	}
}
