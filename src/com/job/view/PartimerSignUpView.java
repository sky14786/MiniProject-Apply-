package com.job.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.PartimerSignUpController;
import com.job.run.Run;

//�ؿ�
public class PartimerSignUpView extends JPanel {

	private JTextField tfID;
	private JPasswordField tfPW;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfPhone;
	private JLabel lbErrorMsg;
	private JButton btnBack, btnSignUp, btnDuplicateCheck;
	private PartimerSignUpController partimerSignUpController = new PartimerSignUpController();
	private boolean isDuplicate;
	private ButtonGroup rbg = new ButtonGroup();
	private JRadioButton[] radio = new JRadioButton[2];
	private JLabel label;
	public Run win;

	/**
	 * Create the application.
	 */
	public PartimerSignUpView(Run win) {
		this.win = win;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setLayout(null);

		Color fontColor = new Color(0x4f4f4f);

		tfID = new JTextField();
		tfID.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfID.setColumns(10);
		tfID.setForeground(fontColor);
		tfID.setBounds(202, 143, 189, 35);
		tfID.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfID.setOpaque(false);
		add(tfID);

		tfPW = new JPasswordField();
		tfPW.setEchoChar('*');
		tfPW.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfPW.setColumns(10);
		tfPW.setForeground(fontColor);
		tfPW.setBounds(202, 213, 189, 35);
		tfPW.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPW.setOpaque(false);
		add(tfPW);

		tfName = new JTextField();
		tfName.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfName.setColumns(10);
		tfName.setForeground(fontColor);
		tfName.setBounds(202, 284, 189, 35);
		tfName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfName.setOpaque(false);
		add(tfName);

		tfAge = new JTextField();
		tfAge.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfAge.setColumns(10);
		tfAge.setForeground(fontColor);
		tfAge.setBounds(202, 353, 189, 35);
		tfAge.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfAge.setOpaque(false);
		add(tfAge);

		tfPhone = new JTextField();
		tfPhone.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfPhone.setColumns(10);
		tfPhone.setForeground(fontColor);
		tfPhone.setBounds(202, 422, 203, 35);
		tfPhone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPhone.setOpaque(false);
		add(tfPhone);

		radio[0] = new JRadioButton("\uC5EC");
		radio[0].setBounds(480, 365, 50, 33);
		radio[0].setForeground(fontColor);
		radio[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		radio[0].setOpaque(false);
		radio[0].setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		add(radio[0]);

		radio[1] = new JRadioButton("\uB0A8");
		radio[1].setBounds(420, 365, 50, 33);
		radio[1].setForeground(fontColor);
		radio[1].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		radio[1].setOpaque(false);
		radio[1].setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		add(radio[1]);

		rbg.add(radio[0]);
		rbg.add(radio[1]);

		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(this.getClass().getResource("/resource/SignUpButton.png")));
		btnSignUp.setFont(new Font("����������", Font.PLAIN, 26));
		btnSignUp.setBounds(121, 494, 146, 53);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		add(btnSignUp);

		btnBack = new JButton("");

		btnBack.setFont(new Font("����������", Font.PLAIN, 26));
		btnBack.setBounds(315, 494, 146, 53);
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		add(btnBack);

		btnDuplicateCheck = new JButton("");
		btnDuplicateCheck.setIcon(new ImageIcon(this.getClass().getResource("/resource/DuplicateCheckButton.png")));
		btnDuplicateCheck.setFont(new Font("����������", Font.PLAIN, 14));
		btnDuplicateCheck.setBounds(416, 134, 101, 44);
		btnDuplicateCheck.setContentAreaFilled(false);
		btnDuplicateCheck.setBorderPainted(false);
		add(btnDuplicateCheck);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setForeground(Color.RED);
		lbErrorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lbErrorMsg.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 20));
		lbErrorMsg.setBounds(483, 29, 423, 44);
		add(lbErrorMsg);

		label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/PartimerSignUpImage-2.jpg")));
		label.setBounds(0, 0, 994, 571);
		add(label);

		radio[0].setSelected(true);

		settingButton();

	}

	// ��ư ��ɼ��� �޼ҵ�
	private void settingButton() {
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showLoginView();
			}
		});

		btnDuplicateCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				duplicateCheck();
			}
		});

		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
	}

	// �Է»��� �ʱ�ȭ �޼ҵ�
	public void resetTextField() {
		tfID.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfPhone.setText("");
		tfAge.setText("");
		lbErrorMsg.setText("");

	}

	// �ڷΰ��� �޼ҵ�
	private void showLoginView() {
		resetTextField();
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getLoginView());
		win.setSize(590, 590);
		revalidate();
		repaint();
	}

	// ID �ߺ�Ȯ�� �޼ҵ�
	private void duplicateCheck() {
		if (!tfID.getText().equals("")) {
			if (partimerSignUpController.englishCheck(tfID.getText())) {
				if (partimerSignUpController.duplicateCheck(tfID.getText())) {
					isDuplicate = true;
					lbErrorMsg.setText("��� ������ ID �Դϴ�.");
				} else {
					isDuplicate = false;
					lbErrorMsg.setText("������� ID �Դϴ�.");
				}
			} else {
				lbErrorMsg.setText("ID�� �����ڿ� ���ڸ� ��밡���մϴ�.");
			}
		} else {
			lbErrorMsg.setText("ID�� �Է��� �ּ���.");
		}

	}

	// ȸ������ �޼ҵ�
	private void signUp() {
		if (!tfID.getText().equals("")) {
			if (!tfPW.getText().equals("") && (tfPW.getText().length() >= 8 && tfPW.getText().length() <= 12)) {
				if (!tfName.getText().equals("")) {
					if (!tfAge.getText().equals("")) {
						if (!tfPhone.getText().equals("")) {
							// ��� �Է»����� ������ �ƴϰ� ��й�ȣ�� 8~12�� �ϰ��
							if (isDuplicate) {
								// �ߺ�Ȯ���� �߰� �� ���� true�� ���
								partimerSignUpController.addPartimer(tfID.getText(), tfPW.getText(), tfName.getText(),
										Integer.parseInt(tfAge.getText()), radio[0].isSelected() == true ? "����" : "����",
										tfPhone.getText());

								resetTextField();
								showLoginView();
							} else {
								lbErrorMsg.setText("ID �ߺ��˻縦 �ϼ���.");
							}
						} else {
							lbErrorMsg.setText("����ó�� �Է��� �ּ���.");
						}
					} else {
						lbErrorMsg.setText("���̸� �Է��� �ּ���.");
					}
				} else {
					lbErrorMsg.setText("�̸��� �Է��� �ּ���.");
				}
			} else if (!(tfPW.getText().length() >= 8 && tfPW.getText().length() <= 12)) {
				lbErrorMsg.setText("��й�ȣ�� 8~12�� �Դϴ�.");
			} else {
				lbErrorMsg.setText("PW�� �Է��� �ּ���.");
			}
		} else {
			lbErrorMsg.setText("ID�� �Է��� �ּ���.");
		}
	}

}
