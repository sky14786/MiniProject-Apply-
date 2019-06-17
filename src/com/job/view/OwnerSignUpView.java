package com.job.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.OwnerSignUpController;
import com.job.run.Run;

//준영
public class OwnerSignUpView extends JPanel {

	private JTextField tfID;
	private JPasswordField tfPW;
	private JTextField tfName;
	private JTextField tfbNumber;
	private JTextField tfAddr;
	private JButton btnSignUp, btnBack;
	private OwnerSignUpController ownerSignUpController = new OwnerSignUpController();
	private JLabel lbErrorMsg;
	private JButton btnDuplicateCheck;
	private boolean isDuplicate;
	private JLabel label_6;
	private Run win = new Run();

	public OwnerSignUpView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setLayout(null);
		setSize(992, 572);
		Color fontColor = new Color(0x4f4f4f);

		tfID = new JTextField();
		tfID.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfID.setColumns(10);
		tfID.setForeground(fontColor);
		tfID.setBounds(204, 143, 189, 35);
		tfID.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfID.setOpaque(false);
		add(tfID);

		tfPW = new JPasswordField();
		tfPW.setEchoChar('*');
		tfPW.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfPW.setColumns(10);
		tfPW.setForeground(fontColor);
		tfPW.setBounds(204, 213, 189, 35);
		tfPW.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPW.setOpaque(false);
		add(tfPW);

		tfName = new JTextField();
		tfName.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfName.setColumns(10);
		tfName.setForeground(fontColor);
		tfName.setBounds(204, 284, 189, 35);
		tfName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfName.setOpaque(false);
		add(tfName);

		tfbNumber = new JTextField();
		tfbNumber.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfbNumber.setColumns(10);
		tfbNumber.setForeground(fontColor);
		tfbNumber.setBounds(204, 353, 189, 35);
		tfbNumber.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfbNumber.setOpaque(false);
		add(tfbNumber);

		tfAddr = new JTextField();
		tfAddr.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfAddr.setForeground(fontColor);
		tfAddr.setColumns(10);
		tfAddr.setBounds(204, 422, 203, 35);
		tfAddr.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfAddr.setOpaque(false);
		add(tfAddr);

		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(this.getClass().getResource("/resource/SignUpButton.png")));
		btnSignUp.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnSignUp.setBounds(121, 494, 146, 53);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		add(btnSignUp);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnBack.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnBack.setBounds(315, 494, 146, 53);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		add(btnBack);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setForeground(Color.RED);
		lbErrorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lbErrorMsg.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbErrorMsg.setBounds(483, 29, 423, 44);
		add(lbErrorMsg);

		btnDuplicateCheck = new JButton("");
		btnDuplicateCheck.setIcon(new ImageIcon(this.getClass().getResource("/resource/DuplicateCheckButton.png")));
		btnDuplicateCheck.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		btnDuplicateCheck.setBounds(420, 134, 103, 44);
		btnDuplicateCheck.setContentAreaFilled(false);
		btnDuplicateCheck.setBorderPainted(false);
		add(btnDuplicateCheck);

		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(this.getClass().getResource("/resource/OwnerSignUpImage-2.jpg")));
		label_6.setBounds(0, 0, 994, 571);
		add(label_6);

		isDuplicate = false;

		settingButton();
	}

	// 버튼 기능 설정 메소드
	private void settingButton() {
		btnDuplicateCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				duplicateCheck();
			}
		});

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveLoginView();
			}
		});

		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
	}

	// 입력 사항 초기화
	private void resetTextField() {
		tfID.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfbNumber.setText("");
		tfAddr.setText("");
		lbErrorMsg.setText("");
	}

	// 뒤로가기
	private void moveLoginView() {
		resetTextField();
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getLoginView());
		win.setSize(590, 590);
		revalidate();
		repaint();
	}

	// 중복확인 기능설정 메소드
	private void duplicateCheck() {
		if (!tfID.getText().equals("")) {
			if (ownerSignUpController.englishCheck(tfID.getText())) {
				if ((isDuplicate = ownerSignUpController.duplicateCheck(tfID.getText()))) {
					lbErrorMsg.setText("사용 가능한 ID 입니다.");
				} else {
					lbErrorMsg.setText("사용중인 ID 입니다.");
				}
			} else {
				lbErrorMsg.setText("ID는 영문자와 숫자만 가능합니다.");
			}
		} else {
			lbErrorMsg.setText("ID를 입력해 주세요.");
		}
	}

	// 회원가입 메소드
	private void signUp() {
		if (!tfID.getText().equals("")) {
			if (!tfPW.getText().equals("") && (tfPW.getText().length() >= 8 && tfPW.getText().length() <= 12)) {
				if (!tfName.getText().equals("")) {
					if (!tfbNumber.getText().equals("")) {
						if (!tfAddr.getText().equals("")) {
							//공백이 없고 패스워드가 8~12자 일경우
							if (isDuplicate) {
								//중복확인을 했고 그 값이 true일 경우
								ownerSignUpController.addOwner(tfID.getText(), tfPW.getText(), tfName.getText(),
										tfbNumber.getText(), tfAddr.getText());

								resetTextField();
								moveLoginView();
							} else {
								lbErrorMsg.setText("ID 중복검사를 하세요.");
							}
						} else {
							lbErrorMsg.setText("주소를 입력해 주세요.");
						}
					} else {
						lbErrorMsg.setText("사업자등록번호를 입력해 주세요.");
					}
				} else {
					lbErrorMsg.setText("이름을 입력해 주세요.");
				}
			} else if (!(tfPW.getText().length() >= 8 && tfPW.getText().length() <= 12)) {
				lbErrorMsg.setText("비밀번호는 8~12자 입니다.");
			} else {
				lbErrorMsg.setText("PW를 입력해 주세요.");
			}
		} else {
			lbErrorMsg.setText("ID를 입력해 주세요.");
		}
	}

}
