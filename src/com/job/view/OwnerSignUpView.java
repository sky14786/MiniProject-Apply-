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

//�ؿ�
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
		tfID.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfID.setColumns(10);
		tfID.setForeground(fontColor);
		tfID.setBounds(204, 143, 189, 35);
		tfID.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfID.setOpaque(false);
		add(tfID);

		tfPW = new JPasswordField();
		tfPW.setEchoChar('*');
		tfPW.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfPW.setColumns(10);
		tfPW.setForeground(fontColor);
		tfPW.setBounds(204, 213, 189, 35);
		tfPW.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPW.setOpaque(false);
		add(tfPW);

		tfName = new JTextField();
		tfName.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfName.setColumns(10);
		tfName.setForeground(fontColor);
		tfName.setBounds(204, 284, 189, 35);
		tfName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfName.setOpaque(false);
		add(tfName);

		tfbNumber = new JTextField();
		tfbNumber.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfbNumber.setColumns(10);
		tfbNumber.setForeground(fontColor);
		tfbNumber.setBounds(204, 353, 189, 35);
		tfbNumber.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfbNumber.setOpaque(false);
		add(tfbNumber);

		tfAddr = new JTextField();
		tfAddr.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 18));
		tfAddr.setForeground(fontColor);
		tfAddr.setColumns(10);
		tfAddr.setBounds(204, 422, 203, 35);
		tfAddr.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfAddr.setOpaque(false);
		add(tfAddr);

		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(this.getClass().getResource("/resource/SignUpButton.png")));
		btnSignUp.setFont(new Font("����������", Font.PLAIN, 26));
		btnSignUp.setBounds(121, 494, 146, 53);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		add(btnSignUp);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnBack.setFont(new Font("����������", Font.PLAIN, 26));
		btnBack.setBounds(315, 494, 146, 53);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		add(btnBack);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setForeground(Color.RED);
		lbErrorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lbErrorMsg.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 20));
		lbErrorMsg.setBounds(483, 29, 423, 44);
		add(lbErrorMsg);

		btnDuplicateCheck = new JButton("");
		btnDuplicateCheck.setIcon(new ImageIcon(this.getClass().getResource("/resource/DuplicateCheckButton.png")));
		btnDuplicateCheck.setFont(new Font("����������", Font.PLAIN, 14));
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

	// ��ư ��� ���� �޼ҵ�
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

	// �Է� ���� �ʱ�ȭ
	private void resetTextField() {
		tfID.setText("");
		tfPW.setText("");
		tfName.setText("");
		tfbNumber.setText("");
		tfAddr.setText("");
		lbErrorMsg.setText("");
	}

	// �ڷΰ���
	private void moveLoginView() {
		resetTextField();
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getLoginView());
		win.setSize(590, 590);
		revalidate();
		repaint();
	}

	// �ߺ�Ȯ�� ��ɼ��� �޼ҵ�
	private void duplicateCheck() {
		if (!tfID.getText().equals("")) {
			if (ownerSignUpController.englishCheck(tfID.getText())) {
				if ((isDuplicate = ownerSignUpController.duplicateCheck(tfID.getText()))) {
					lbErrorMsg.setText("��� ������ ID �Դϴ�.");
				} else {
					lbErrorMsg.setText("������� ID �Դϴ�.");
				}
			} else {
				lbErrorMsg.setText("ID�� �����ڿ� ���ڸ� �����մϴ�.");
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
					if (!tfbNumber.getText().equals("")) {
						if (!tfAddr.getText().equals("")) {
							//������ ���� �н����尡 8~12�� �ϰ��
							if (isDuplicate) {
								//�ߺ�Ȯ���� �߰� �� ���� true�� ���
								ownerSignUpController.addOwner(tfID.getText(), tfPW.getText(), tfName.getText(),
										tfbNumber.getText(), tfAddr.getText());

								resetTextField();
								moveLoginView();
							} else {
								lbErrorMsg.setText("ID �ߺ��˻縦 �ϼ���.");
							}
						} else {
							lbErrorMsg.setText("�ּҸ� �Է��� �ּ���.");
						}
					} else {
						lbErrorMsg.setText("����ڵ�Ϲ�ȣ�� �Է��� �ּ���.");
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
