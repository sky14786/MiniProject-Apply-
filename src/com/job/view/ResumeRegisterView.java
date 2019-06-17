package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.CheckingController;
import com.job.controller.ResumeRegisterController;
import com.job.model.Partimer;
import com.job.run.Run;
import javax.swing.ImageIcon;
import java.awt.Color;
//덕
public class ResumeRegisterView extends JPanel {

	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfGender;
	private JTextField tfPhone;
	private JTextField tfCareer;
	private JComboBox comboAcademic;
	private JComboBox comboTypeOccup;
	private JComboBox comboPeriod;
	private JComboBox comboDow;
	private JComboBox comboTime;
	private JComboBox comboRegion;
	private JButton complete;
	private JButton cancel;
	private JLabel phoneLabel;
	private JLabel typeOccupLabel;
	private JLabel dowLabel;
	private JLabel timeLabel;
	private JLabel registBackground;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;

	public Run win = new Run();
	
	private ResumeRegisterController resumeResisterController = new ResumeRegisterController();
	private CheckingController checkingController = new CheckingController();

	public ResumeRegisterView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setSize(1000, 600);
		setLayout(null);
		
		label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(ResumeRegisterView.class.getResource("/resource/line_label.png")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(100, 152, 150, 2);
		add(label_11);
		
		label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(ResumeRegisterView.class.getResource("/resource/line_label.png")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(320, 152, 150, 2);
		add(label_12);
		
		label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(ResumeRegisterView.class.getResource("/resource/line_label.png")));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(540, 152, 150, 2);
		add(label_13);
		
		label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(this.getClass().getResource("/resource/line_label.png")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(780, 152, 150, 2);
		add(label_14);

		JLabel lblNewLabel = new JLabel("\uC774\uB825\uC11C \uB4F1\uB85D");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 40));
		lblNewLabel.setBounds(390, 30, 200, 40);
		add(lblNewLabel);

		JLabel label = new JLabel("\uC774\uB984");
		label.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(50, 129, 40, 20);
		add(label);

		JLabel label_1 = new JLabel("\uB098\uC774");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_1.setBounds(270, 129, 40, 20);
		add(label_1);

		JLabel label_2 = new JLabel("\uC131\uBCC4");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_2.setBounds(490, 129, 40, 20);
		add(label_2);

		JLabel label_3 = new JLabel("\uD3F0\uBC88\uD638");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_3.setBounds(710, 129, 60, 20);
		add(label_3);

		JLabel label_4 = new JLabel("\uD559\uB825");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_4.setBounds(335, 184, 80, 20);
		add(label_4);

		JLabel label_5 = new JLabel("\uACBD\uB825");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_5.setBounds(335, 226, 80, 20);
		add(label_5);

		JLabel label_6 = new JLabel("\uADFC\uBB34\uD615\uD0DC");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_6.setBounds(315, 268, 100, 20);
		add(label_6);

		JLabel label_7 = new JLabel("\uAE30\uAC04");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_7.setBounds(335, 310, 80, 20);
		add(label_7);

		JLabel label_8 = new JLabel("\uC694\uC77C");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_8.setBounds(335, 352, 80, 20);
		add(label_8);

		JLabel label_9 = new JLabel("\uC2DC\uAC04");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_9.setBounds(335, 394, 80, 20);
		add(label_9);

		JLabel label_10 = new JLabel("\uC9C0\uC5ED");
		label_10.setToolTipText("");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 20));
		label_10.setBounds(335, 436, 80, 20);
		add(label_10);

		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(10);
		tfName.setBounds(100, 124, 150, 30);
		tfName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfName.setOpaque(false);
		add(tfName);

		tfAge = new JTextField();
		tfAge.setEditable(false);
		tfAge.setHorizontalAlignment(SwingConstants.CENTER);
		tfAge.setColumns(10);
		tfAge.setBounds(320, 124, 150, 30);
		tfAge.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfAge.setOpaque(false);
		add(tfAge);

		tfGender = new JTextField();
		tfGender.setEditable(false);
		tfGender.setHorizontalAlignment(SwingConstants.CENTER);
		tfGender.setColumns(10);
		tfGender.setBounds(540, 124, 150, 30);
		tfGender.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfGender.setOpaque(false);
		add(tfGender);

		tfPhone = new JTextField();
		tfPhone.setHorizontalAlignment(SwingConstants.CENTER);
		tfPhone.setColumns(10);
		tfPhone.setBounds(780, 124, 150, 30);
		tfPhone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPhone.setOpaque(false);
		add(tfPhone);

		tfCareer = new JTextField();
		tfCareer.setHorizontalAlignment(SwingConstants.LEFT);
		tfCareer.setColumns(10);
		tfCareer.setBounds(440, 222, 150, 30);
		add(tfCareer);

		comboAcademic = new JComboBox();
		comboAcademic.setModel(new DefaultComboBoxModel(new String[] { "[\uCD5C\uC885\uD559\uB825]", "\uC911\uC878",
				"\uACE0\uC878", "\uC804\uBB38\uB300\uC878", "4\uB144\uC81C\uC878" }));
		comboAcademic.setBounds(440, 180, 150, 30);
		add(comboAcademic);

		comboTypeOccup = new JComboBox();
		comboTypeOccup.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34\uD615\uD0DC]", "\uB9E4\uC7A5\uAD00\uB9AC", "\uC8FC\uBC29",
						"\uBBF8\uB514\uC5B4", "\uC6B4\uC804", "\uC0AC\uBB34", "IT", "\uC601\uC5C5", "\uAD50\uC721" }));
		comboTypeOccup.setBounds(440, 264, 150, 30);
		add(comboTypeOccup);

		comboPeriod = new JComboBox();
		comboPeriod.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34\uAE30\uAC04]", "\uD558\uB8E8", "\uC77C\uC8FC\uC77C",
						"1\uAC1C\uC6D4 \uC774\uC0C1", "3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1" }));
		comboPeriod.setBounds(440, 306, 150, 30);
		add(comboPeriod);

		comboDow = new JComboBox();
		comboDow.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34\uC694\uC77C]", "\uD3C9\uC77C",
				"\uC8FC\uB9D0", "\uAE08,\uD1A0,\uC77C", "\uC6D4,\uC218,\uAE08", "\uD654,\uBAA9" }));
		comboDow.setBounds(440, 348, 150, 30);
		add(comboDow);

		comboTime = new JComboBox();
		comboTime.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34\uC2DC\uAC04]",
				"1\uC2DC\uAC04 ~ 3\uC2DC\uAC04", "3\uC2DC\uAC04 ~ 6\uC2DC\uAC04", "6\uC2DC\uAC04 ~ 8\uC2DC\uAC04",
				"8\uC2DC\uAC04 \uC774\uC0C1" }));
		comboTime.setBounds(440, 390, 150, 30);
		add(comboTime);

		comboRegion = new JComboBox();
		comboRegion.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34\uC9C0\uC5ED]", "\uAC15\uC6D0",
				"\uACBD\uAE30", "\uACBD\uB0A8", "\uACBD\uBD81", "\uAD11\uC8FC", "\uB300\uAD6C", "\uB300\uC804",
				"\uC11C\uC6B8", "\uC138\uC885", "\uC6B8\uC0B0", "\uC778\uCC9C", "\uC804\uB0A8", "\uC804\uBD81",
				"\uC81C\uC8FC", "\uBD80\uC0B0", "\uCDA9\uB0A8", "\uCDA9\uBD81" }));
		comboRegion.setBounds(440, 432, 150, 30);
		add(comboRegion);

		complete = new JButton("");
		complete.setIcon(new ImageIcon(ResumeRegisterView.class.getResource("/resource/complete_button_n.png")));
		complete.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		complete.setBounds(390, 490, 90, 50);
		complete.setBorderPainted(false);
		complete.setContentAreaFilled(false);
		add(complete);

		cancel = new JButton("");
		cancel.setIcon(new ImageIcon(ResumeRegisterView.class.getResource("/resource/cancel_button_n.png")));
		cancel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		cancel.setBounds(500, 490, 90, 50);
		cancel.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		add(cancel);

		phoneLabel = new JLabel("");
		phoneLabel.setForeground(Color.RED);
		phoneLabel.setBounds(780, 160, 150, 18);
		add(phoneLabel);

		typeOccupLabel = new JLabel("");
		typeOccupLabel.setForeground(Color.RED);
		typeOccupLabel.setBounds(603, 270, 150, 18);
		add(typeOccupLabel);

		dowLabel = new JLabel("");
		dowLabel.setForeground(Color.RED);
		dowLabel.setBounds(603, 354, 150, 18);
		add(dowLabel);

		timeLabel = new JLabel("");
		timeLabel.setForeground(Color.RED);
		timeLabel.setBounds(603, 396, 150, 18);
		add(timeLabel);
		
		registBackground = new JLabel("");
		registBackground.setIcon(new ImageIcon(ResumeRegisterView.class.getResource("/resource/resumeE&M_Background.png")));
		registBackground.setBounds(0, 0, 1000, 600);
		add(registBackground);

		// testPrompt();
		resumeComplete();
		resumeCancel();
	}

	public void testPrompt() {
		tfPhone.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (tfPhone.getText().isEmpty()) {
					tfPhone.setText("ex) 010-0000-0000");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (tfPhone.getText().equals("ex) 010-0000-0000")) {
					tfPhone.setText("");
				}
			}
		});
	}

	// 회원정보 불러와서 띄우기
	public void settingData() {
		Partimer temp = null;
		if ((temp = checkingController.sendUserInformation()) != null) {
			System.out.println("이력서 : " + temp.toString());
			tfName.setText(temp.getName());
			tfAge.setText(Integer.valueOf(temp.getAge()).toString());
			tfGender.setText(temp.getGender());
			tfPhone.setText(temp.getPhone());
			
			clearTextField();
		} else {
			System.out.println("회원정보 불러오기 오류");
		}
	}

	// 완료버튼 리스너
	// 새 이력서 생성 후 저장
	// 이전화면(메인)으로 돌아가기
	public void resumeComplete() {
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = tfName.getText();
				int age = Integer.parseInt(tfAge.getText());
				String gender = tfGender.getText();
				String phoneNum = tfPhone.getText();

				String academic = comboAcademic.getSelectedItem().toString();
				String career = tfCareer.getText();
				String typeOccup = comboTypeOccup.getSelectedItem().toString();
				String periodType = comboPeriod.getSelectedItem().toString();
				String dow = comboDow.getSelectedItem().toString();
				String time = comboTime.getSelectedItem().toString();
				String region = comboRegion.getSelectedItem().toString();

				// 폰번호,직종(근무형태),요일,시간 필수 기입사항! 이걸 적어야만 저장&넘어감
				if (!phoneNum.equals("") && typeOccup != "[근무형태]" && dow != "[근무요일]" && time != "[근무시간]") {
					resumeResisterController.addResume(name, age, gender, phoneNum, academic, career, typeOccup,
							periodType, dow, time, region);

					win.getContentPane().removeAll();
					win.getContentPane().add(win.getPartMainView());
					win.getContentPane().revalidate();
					win.getContentPane().repaint();

					// 등록 완료시 버튼 비활성화
					win.getPartMainView().buttonTest();
				}
				if (phoneNum.equals("")) {
					phoneLabel.setText("필수입력사항입니다");
				} else {
					phoneLabel.setText("");
				}
				if (typeOccup == "[근무형태]") {
					typeOccupLabel.setText("필수입력사항입니다");
				} else {
					typeOccupLabel.setText("");
				}
				if (dow == "[근무요일]") {
					dowLabel.setText("필수입력사항입니다");
				} else {
					dowLabel.setText("");
				}
				if (time == "[근무시간]") {
					timeLabel.setText("필수입력사항입니다");
				} else {
					timeLabel.setText("");
				}

			}
		});
	}

	// 취소버튼 리스너
	public void resumeCancel() {
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전값으로 되돌리고
				clearTextField();

				// 화면전환(뒤로가기)
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getPartMainView());
				win.getContentPane().revalidate();
				win.getContentPane().repaint();
			}
		});
	}

	public void clearTextField() {
		comboAcademic.setSelectedItem("[최종학력]");
		tfCareer.setText("");
		comboTypeOccup.setSelectedItem("[근무형태]");
		comboPeriod.setSelectedItem("[근무기간]");
		comboDow.setSelectedItem("[근무요일]");
		comboTime.setSelectedItem("[근무시간]");
		comboRegion.setSelectedItem("[근무지역]");
	}
}
