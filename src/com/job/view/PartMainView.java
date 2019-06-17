package com.job.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.CheckingController;
import com.job.controller.ResumeDeleteController;
import com.job.model.Partimer;
import com.job.run.Run;

//덕
public class PartMainView extends JPanel {

	private JTextField tfKeyword;
	private JButton searchBtn;
	private JButton registerBtn;
	private JButton modifyBtn;
	private JButton deleteBtn;
	private JButton listBtn;
	private JButton lookAroundBtn;
	private JButton logoutBtn;
	private JButton ansYes;
	private JButton ansNo;
	private JLabel loginLabel;
	private JLabel nowUserLabel;
	private JLabel liner;
	private JLabel typingLabel;

	private ResumeDeleteController resumeDeleteController = new ResumeDeleteController();
	private CheckingController checkingController = new CheckingController();

	public Run win = new Run();

	public int check = 1;

	public PartMainView() {
	}

	public PartMainView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setSize(1000, 600);
		setLayout(null);

		liner = new JLabel("");
		liner.setHorizontalAlignment(SwingConstants.CENTER);
		liner.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/line_label.png")));
		liner.setBounds(372, 323, 230, 2);
		add(liner);

		tfKeyword = new JTextField();
		tfKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		tfKeyword.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		tfKeyword.setBounds(372, 288, 230, 35);
		tfKeyword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfKeyword.setOpaque(false);
		add(tfKeyword);
		tfKeyword.setColumns(10);

		searchBtn = new JButton("");
		searchBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/find_button_2.png")));
		searchBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		searchBtn.setBounds(603, 285, 40, 40);
		searchBtn.setBorderPainted(false);
		searchBtn.setContentAreaFilled(false);
		add(searchBtn);

		registerBtn = new JButton("");
		registerBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/regist_button.png")));
		registerBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		registerBtn.setBounds(205, 190, 110, 30);
		registerBtn.setBorderPainted(false);
		registerBtn.setContentAreaFilled(false);
		add(registerBtn);

		modifyBtn = new JButton("");
		modifyBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/modi_button.png")));
		modifyBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		modifyBtn.setBounds(325, 190, 110, 30);
		modifyBtn.setBorderPainted(false);
		modifyBtn.setContentAreaFilled(false);
		add(modifyBtn);

		deleteBtn = new JButton("");
		deleteBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/delete_button.png")));
		deleteBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		deleteBtn.setBounds(445, 190, 110, 30);
		deleteBtn.setBorderPainted(false);
		deleteBtn.setContentAreaFilled(false);
		add(deleteBtn);

		listBtn = new JButton("");
		listBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/list_button.png")));
		listBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		listBtn.setBounds(565, 190, 110, 30);
		listBtn.setBorderPainted(false);
		listBtn.setContentAreaFilled(false);
		add(listBtn);

		logoutBtn = new JButton("");
		logoutBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/logout_button.png")));
		logoutBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		logoutBtn.setBounds(962, 5, 24, 24);
		logoutBtn.setBorderPainted(false);
		logoutBtn.setContentAreaFilled(false);
		add(logoutBtn);

		lookAroundBtn = new JButton("");
		lookAroundBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/lookAround_button.png")));
		lookAroundBtn.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		lookAroundBtn.setContentAreaFilled(false);
		lookAroundBtn.setBorderPainted(false);
		lookAroundBtn.setBounds(685, 190, 110, 30);
		add(lookAroundBtn);

		loginLabel = new JLabel("\uB2D8 \uC811\uC18D\uC911");
		loginLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 15));
		loginLabel.setBounds(898, 4, 60, 25);
		add(loginLabel);

		nowUserLabel = new JLabel("anonymous");
		nowUserLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 15));
		nowUserLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nowUserLabel.setBounds(782, 4, 110, 25);
		add(nowUserLabel);

		typingLabel = new JLabel("");
		typingLabel.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		typingLabel.setForeground(Color.RED);
		typingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typingLabel.setBounds(422, 333, 140, 20);
		add(typingLabel);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/resumeE&M_Background.png")));
		background.setBounds(0, 0, 1000, 600);
		add(background);

		showId();
		buttonTest();
		clearKeywordTextField();
		searchClick();
		searchEnter();
		lookAroundScene();
		enrollScene();
		modifyScene();
		deleteScene();
		listScene();
		prevScene();

	}

	// 현재 접속중인 유저 띄우기
	public void showId() {
		Partimer temp = null;
		if ((temp = checkingController.sendUserInformation()) != null) {
			System.out.println("-------------------------------------------");
			System.out.println("showId : " + temp.toString());
			System.out.println("-------------------------------------------");
			nowUserLabel.setText(temp.getId());
		} else {
			// System.out.println("아이디 불러오기 오류");
		}
	}

	// 등록,수정,삭제버튼 enable 여부
	public void buttonTest() {
		check = checkingController.isApplyCheck();
		// System.out.println("버튼 활성화 : " + check);
		if (check == 3) {
			registerBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			modifyBtn.setEnabled(false);
		} else if (check == 2) {
			registerBtn.setEnabled(false);
			deleteBtn.setEnabled(true);
			modifyBtn.setEnabled(true);
		} else {
			// System.out.println("버튼 활성화 오류");
		}
	}
	
	// 키워드 입력란 비우기
		public void clearKeywordTextField() {
			tfKeyword.setText("");
		}

	// 검색버튼 액션
	public void searchClick() {
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) // 구현할것 : 화면전환, 키워드 넘기기
			{
				// 키워드 넘기기 임시테스트
				String keyword = tfKeyword.getText();

				if (keyword.equals("")) {
					typingLabel.setText("키워드를 입력하세요.");
				} else {
					typingLabel.setText("");
					System.out.println("-------------------------------------------");
					System.out.println("검색 키워드 : " + keyword);
					System.out.println("-------------------------------------------");
					win.getJobSearchView().printTable1(keyword);

					// 화면전환
					win.getContentPane().removeAll();
					win.getContentPane().add(win.getJobSearchView()); // 여기서 기호오빠 화면으로 전환
					win.getContentPane().revalidate();
					win.getContentPane().repaint();
				}
			}
		});
	}

	// 검색창 액션 (enter키)
	public void searchEnter() {
		tfKeyword.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) // 구현할것 : 화면전환, 키워드 넘기기
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// 키워드 넘기기 임시테스트
					String keyword = tfKeyword.getText();

					if (keyword.equals("")) {
						typingLabel.setText("키워드를 입력하세요.");
					} else {
						typingLabel.setText("");
						System.out.println("-------------------------------------------");
						System.out.println("검색 키워드 : " + keyword);
						System.out.println("-------------------------------------------");
						win.getJobSearchView().printTable1(keyword);

						// 화면전환
						win.getContentPane().removeAll();
						win.getContentPane().add(win.getJobSearchView()); // 여기서 기호오빠 화면으로 전환
						win.getContentPane().revalidate();
						win.getContentPane().repaint();
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	// 구인공고 전체보기 버튼 액션
	public void lookAroundScene() {
		lookAroundBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getJobSearchView()); // 여기서 기호오빠 화면으로 전환
				win.getJobSearchView().normalSearch(); // 기본 전체보기 메소드
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	// 이력서 등록 버튼 액션
	// 스위치 확인, 이력서 등록창 띄우기
	public void enrollScene() {
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getResumeEnrollView());
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
				win.getResumeEnrollView().settingData();
			}
		});
	}

	// 이력서 수정 버튼 액션
	// 스위치 확인, 저장된 이력서 불러와 띄우기
	public void modifyScene() {
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getResumeModifyView());
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
				win.getResumeModifyView().settingData();
			}
		});
	}

	// 이력서 삭제 버튼 액션
	// 이력서 모두 비우기 , 스위치, 팝업
	public void deleteScene() {
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 팝업 알림창
				JDialog notice = new JDialog(win, "삭제알림", false);
				notice.setBounds(300, 150, 400, 300);
				notice.getContentPane().setLayout(null);

				JLabel label = new JLabel("삭제하시겠습니까?");
				label.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(90, 70, 200, 20);
				notice.getContentPane().add(label);

				// 삭제 진행 승인 버튼
				ansYes = new JButton("삭제");
				ansYes.setBounds(100, 150, 80, 50);
				ansYes.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
				ansYes.setVisible(true);
				notice.getContentPane().add(ansYes);
				ansYes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 이력서 삭제
						resumeDeleteController.delResume();

						// 삭제시 등록 버튼 활성화
						buttonTest();

						// 등록화면 null로 세팅
						win.getResumeEnrollView().clearTextField();
						notice.setVisible(false);
					}
				});

				// 삭제 진행 취소 버튼
				ansNo = new JButton("취소");
				ansNo.setBounds(200, 150, 80, 50);
				ansNo.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
				ansNo.setVisible(true);
				notice.getContentPane().add(ansNo);
				ansNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						notice.setVisible(false);
					}
				});

				notice.setVisible(true);
			}
		});
	}

	// 지원목록 버튼 액션
	public void listScene() {
		listBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 지원목록 띄우기 (현희언니꺼랑 연결)
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getApplicationDeleteView()); // 여기서 현희언니 화면으로 전환
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
				win.getApplicationDeleteView().tableSetting();
				win.setVisible(false);
				win.setVisible(true);
			}
		});
	}

	// 로그아웃 버튼 액션
	public void prevScene() {
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getLoginView());
				win.setSize(590, 590);
				revalidate();
				repaint();
			}
		});
	}

}
