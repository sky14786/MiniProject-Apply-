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

//��
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
		tfKeyword.setFont(new Font("����������", Font.PLAIN, 20));
		tfKeyword.setBounds(372, 288, 230, 35);
		tfKeyword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfKeyword.setOpaque(false);
		add(tfKeyword);
		tfKeyword.setColumns(10);

		searchBtn = new JButton("");
		searchBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/find_button_2.png")));
		searchBtn.setFont(new Font("����������", Font.PLAIN, 20));
		searchBtn.setBounds(603, 285, 40, 40);
		searchBtn.setBorderPainted(false);
		searchBtn.setContentAreaFilled(false);
		add(searchBtn);

		registerBtn = new JButton("");
		registerBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/regist_button.png")));
		registerBtn.setFont(new Font("����������", Font.PLAIN, 15));
		registerBtn.setBounds(205, 190, 110, 30);
		registerBtn.setBorderPainted(false);
		registerBtn.setContentAreaFilled(false);
		add(registerBtn);

		modifyBtn = new JButton("");
		modifyBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/modi_button.png")));
		modifyBtn.setFont(new Font("����������", Font.PLAIN, 15));
		modifyBtn.setBounds(325, 190, 110, 30);
		modifyBtn.setBorderPainted(false);
		modifyBtn.setContentAreaFilled(false);
		add(modifyBtn);

		deleteBtn = new JButton("");
		deleteBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/delete_button.png")));
		deleteBtn.setFont(new Font("����������", Font.PLAIN, 15));
		deleteBtn.setBounds(445, 190, 110, 30);
		deleteBtn.setBorderPainted(false);
		deleteBtn.setContentAreaFilled(false);
		add(deleteBtn);

		listBtn = new JButton("");
		listBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/list_button.png")));
		listBtn.setFont(new Font("����������", Font.PLAIN, 15));
		listBtn.setBounds(565, 190, 110, 30);
		listBtn.setBorderPainted(false);
		listBtn.setContentAreaFilled(false);
		add(listBtn);

		logoutBtn = new JButton("");
		logoutBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/logout_button.png")));
		logoutBtn.setFont(new Font("����������", Font.PLAIN, 15));
		logoutBtn.setBounds(962, 5, 24, 24);
		logoutBtn.setBorderPainted(false);
		logoutBtn.setContentAreaFilled(false);
		add(logoutBtn);

		lookAroundBtn = new JButton("");
		lookAroundBtn.setIcon(new ImageIcon(PartMainView.class.getResource("/resource/lookAround_button.png")));
		lookAroundBtn.setFont(new Font("����������", Font.PLAIN, 15));
		lookAroundBtn.setContentAreaFilled(false);
		lookAroundBtn.setBorderPainted(false);
		lookAroundBtn.setBounds(685, 190, 110, 30);
		add(lookAroundBtn);

		loginLabel = new JLabel("\uB2D8 \uC811\uC18D\uC911");
		loginLabel.setFont(new Font("���������� Bold", Font.PLAIN, 15));
		loginLabel.setBounds(898, 4, 60, 25);
		add(loginLabel);

		nowUserLabel = new JLabel("anonymous");
		nowUserLabel.setFont(new Font("���������� Bold", Font.PLAIN, 15));
		nowUserLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nowUserLabel.setBounds(782, 4, 110, 25);
		add(nowUserLabel);

		typingLabel = new JLabel("");
		typingLabel.setFont(new Font("����������", Font.PLAIN, 15));
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

	// ���� �������� ���� ����
	public void showId() {
		Partimer temp = null;
		if ((temp = checkingController.sendUserInformation()) != null) {
			System.out.println("-------------------------------------------");
			System.out.println("showId : " + temp.toString());
			System.out.println("-------------------------------------------");
			nowUserLabel.setText(temp.getId());
		} else {
			// System.out.println("���̵� �ҷ����� ����");
		}
	}

	// ���,����,������ư enable ����
	public void buttonTest() {
		check = checkingController.isApplyCheck();
		// System.out.println("��ư Ȱ��ȭ : " + check);
		if (check == 3) {
			registerBtn.setEnabled(true);
			deleteBtn.setEnabled(false);
			modifyBtn.setEnabled(false);
		} else if (check == 2) {
			registerBtn.setEnabled(false);
			deleteBtn.setEnabled(true);
			modifyBtn.setEnabled(true);
		} else {
			// System.out.println("��ư Ȱ��ȭ ����");
		}
	}
	
	// Ű���� �Է¶� ����
		public void clearKeywordTextField() {
			tfKeyword.setText("");
		}

	// �˻���ư �׼�
	public void searchClick() {
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) // �����Ұ� : ȭ����ȯ, Ű���� �ѱ��
			{
				// Ű���� �ѱ�� �ӽ��׽�Ʈ
				String keyword = tfKeyword.getText();

				if (keyword.equals("")) {
					typingLabel.setText("Ű���带 �Է��ϼ���.");
				} else {
					typingLabel.setText("");
					System.out.println("-------------------------------------------");
					System.out.println("�˻� Ű���� : " + keyword);
					System.out.println("-------------------------------------------");
					win.getJobSearchView().printTable1(keyword);

					// ȭ����ȯ
					win.getContentPane().removeAll();
					win.getContentPane().add(win.getJobSearchView()); // ���⼭ ��ȣ���� ȭ������ ��ȯ
					win.getContentPane().revalidate();
					win.getContentPane().repaint();
				}
			}
		});
	}

	// �˻�â �׼� (enterŰ)
	public void searchEnter() {
		tfKeyword.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) // �����Ұ� : ȭ����ȯ, Ű���� �ѱ��
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Ű���� �ѱ�� �ӽ��׽�Ʈ
					String keyword = tfKeyword.getText();

					if (keyword.equals("")) {
						typingLabel.setText("Ű���带 �Է��ϼ���.");
					} else {
						typingLabel.setText("");
						System.out.println("-------------------------------------------");
						System.out.println("�˻� Ű���� : " + keyword);
						System.out.println("-------------------------------------------");
						win.getJobSearchView().printTable1(keyword);

						// ȭ����ȯ
						win.getContentPane().removeAll();
						win.getContentPane().add(win.getJobSearchView()); // ���⼭ ��ȣ���� ȭ������ ��ȯ
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

	// ���ΰ��� ��ü���� ��ư �׼�
	public void lookAroundScene() {
		lookAroundBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getJobSearchView()); // ���⼭ ��ȣ���� ȭ������ ��ȯ
				win.getJobSearchView().normalSearch(); // �⺻ ��ü���� �޼ҵ�
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	// �̷¼� ��� ��ư �׼�
	// ����ġ Ȯ��, �̷¼� ���â ����
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

	// �̷¼� ���� ��ư �׼�
	// ����ġ Ȯ��, ����� �̷¼� �ҷ��� ����
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

	// �̷¼� ���� ��ư �׼�
	// �̷¼� ��� ���� , ����ġ, �˾�
	public void deleteScene() {
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �˾� �˸�â
				JDialog notice = new JDialog(win, "�����˸�", false);
				notice.setBounds(300, 150, 400, 300);
				notice.getContentPane().setLayout(null);

				JLabel label = new JLabel("�����Ͻðڽ��ϱ�?");
				label.setFont(new Font("���������� Bold", Font.PLAIN, 20));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(90, 70, 200, 20);
				notice.getContentPane().add(label);

				// ���� ���� ���� ��ư
				ansYes = new JButton("����");
				ansYes.setBounds(100, 150, 80, 50);
				ansYes.setFont(new Font("����������", Font.PLAIN, 15));
				ansYes.setVisible(true);
				notice.getContentPane().add(ansYes);
				ansYes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// �̷¼� ����
						resumeDeleteController.delResume();

						// ������ ��� ��ư Ȱ��ȭ
						buttonTest();

						// ���ȭ�� null�� ����
						win.getResumeEnrollView().clearTextField();
						notice.setVisible(false);
					}
				});

				// ���� ���� ��� ��ư
				ansNo = new JButton("���");
				ansNo.setBounds(200, 150, 80, 50);
				ansNo.setFont(new Font("����������", Font.PLAIN, 15));
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

	// ������� ��ư �׼�
	public void listScene() {
		listBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ������� ���� (�����ϲ��� ����)
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getApplicationDeleteView()); // ���⼭ ������ ȭ������ ��ȯ
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
				win.getApplicationDeleteView().tableSetting();
				win.setVisible(false);
				win.setVisible(true);
			}
		});
	}

	// �α׾ƿ� ��ư �׼�
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
