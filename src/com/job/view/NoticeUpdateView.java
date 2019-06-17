package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.job.controller.NoticeUpdateController;
import com.job.model.Notice;
import com.job.run.Run;
import javax.swing.ImageIcon;
import java.awt.Color;

//준영, 현식(삭제)
public class NoticeUpdateView extends JPanel {
	private JTextField tfBKeyword1;
	private JTextField tfBKeyword2;
	private JTextField tfBKeyword3;
//	private JTextField tfAddr;
//	private JTextField tfCategory;
	private JTextField tfTimeToTime;
	private JTextField tfPay;
	private JTextField tfBName;
	private JButton btnBack, btnUpdate, btnDelete;
	private JComboBox periodType, timeType, typeCategory, typeRegion;
	private JTextArea taETC;
	private JLabel lbErrorMsg;
	public Run win = new Run();
	private NoticeUpdateController noticeUpdateController = new NoticeUpdateController();

	public NoticeUpdateView(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		Color fontColor = new Color(0x4f4f4f);

		lbErrorMsg = new JLabel("");
		lbErrorMsg.setForeground(Color.RED);
		lbErrorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lbErrorMsg.setFont(new Font("나눔스퀘어", Font.PLAIN, 22));
		lbErrorMsg.setBounds(483, 29, 423, 44);
		add(lbErrorMsg);

		btnDelete = new JButton("");
		btnDelete.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnDelete.setBounds(23, 510, 146, 53);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setIcon(new ImageIcon(this.getClass().getResource("/resource/NoticeDeleteBtn.png")));
		add(btnDelete);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnBack.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnBack.setBounds(804, 510, 146, 53);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		add(btnBack);

		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(this.getClass().getResource("/resource/ButtonNoticeUpdate.png")));
		btnUpdate.setFont(new Font("나눔스퀘어", Font.PLAIN, 26));
		btnUpdate.setBounds(410, 510, 146, 53);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		add(btnUpdate);

		taETC = new JTextArea();
		taETC.setForeground(fontColor);
		taETC.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		taETC.setBounds(630, 231, 346, 227);
		taETC.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		taETC.setOpaque(false);
		add(taETC);

		timeType = new JComboBox();
		timeType.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		timeType.setBounds(219, 440, 122, 35);
		timeType.setModel(new DefaultComboBoxModel(new String[] { "\uC2DC\uAC04 \uC120\uD0DD",
				"1\uC2DC\uAC04 ~ 3\uC2DC\uAC04", "3\uC2DC\uAC04 ~ 6\uC2DC\uAC04", "6\uC2DC\uAC04 ~ 8\uC2DC\uAC04",
				"8\uC2DC\uAC04\uC774\uC0C1" }));
		add(timeType);

		periodType = new JComboBox();
		periodType.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		periodType.setBounds(434, 440, 122, 35);
		periodType.setModel(new DefaultComboBoxModel(
				new String[] { "\uAE30\uAC04 \uC120\uD0DD", "\uD558\uB8E8", "\uC77C\uC8FC\uC77C",
						"1\uAC1C\uC6D4 \uC774\uC0C1", "3\uAC1C\uC6D4 \uC774\uC0C1", "6\uAC1C\uC6D4 \uC774\uC0C1" }));
		add(periodType);

		tfBKeyword3 = new JTextField();
		tfBKeyword3.setForeground(fontColor);
		tfBKeyword3.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfBKeyword3.setColumns(10);
		tfBKeyword3.setBounds(493, 282, 107, 35);
		tfBKeyword3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfBKeyword3.setOpaque(false);

		add(tfBKeyword3);

		tfBKeyword2 = new JTextField();
		tfBKeyword2.setForeground(fontColor);
		tfBKeyword2.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfBKeyword2.setColumns(10);
		tfBKeyword2.setBounds(492, 212, 108, 35);
		tfBKeyword2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfBKeyword2.setOpaque(false);
		add(tfBKeyword2);

		tfBKeyword1 = new JTextField();
		tfBKeyword1.setForeground(fontColor);
		tfBKeyword1.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfBKeyword1.setColumns(10);
		tfBKeyword1.setBounds(496, 141, 109, 35);
		tfBKeyword1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfBKeyword1.setOpaque(false);
		add(tfBKeyword1);

//		tfAddr = new JTextField();
//		tfAddr.setForeground(fontColor);
//		tfAddr.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
//		tfAddr.setColumns(10);
//		tfAddr.setBounds(651, 115, 211, 35);
//		tfAddr.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//		tfAddr.setOpaque(false);
//		add(tfAddr);
//
//		tfCategory = new JTextField();
//		tfCategory.setForeground(fontColor);
//		tfCategory.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
//		tfCategory.setColumns(10);
//		tfCategory.setBounds(652, 45, 210, 35);
//		tfCategory.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//		tfCategory.setOpaque(false);
//		add(tfCategory);

		tfTimeToTime = new JTextField();
		tfTimeToTime.setForeground(fontColor);
		tfTimeToTime.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfTimeToTime.setColumns(10);
		tfTimeToTime.setBounds(163, 286, 210, 35);
		tfTimeToTime.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfTimeToTime.setOpaque(false);
		add(tfTimeToTime);

		tfPay = new JTextField();
		tfPay.setForeground(fontColor);
		tfPay.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfPay.setColumns(10);
		tfPay.setBounds(164, 216, 209, 35);
		tfPay.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfPay.setOpaque(false);
		add(tfPay);

		tfBName = new JTextField();
		tfBName.setForeground(fontColor);
		tfBName.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		tfBName.setColumns(10);
		tfBName.setBounds(162, 146, 211, 35);
		tfBName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		tfBName.setOpaque(false);
		add(tfBName);

		typeRegion = new JComboBox();
		typeRegion.setModel(new DefaultComboBoxModel(new String[] { "[\uADFC\uBB34 \uC9C0\uC5ED]", "\uAC15\uC6D0",
				"\uACBD\uAE30", "\uACBD\uB0A8", "\uACBD\uBD81", "\uAD11\uC8FC", "\uB300\uAD6C", "\uB300\uC804",
				"\uC11C\uC6B8", "\uC138\uC885", "\uC6B8\uC0B0", "\uC778\uCC9C", "\uC804\uB0A8", "\uC804\uBD81",
				"\uC81C\uC8FC", "\uBD80\uC0B0", "\uCDA9\uB0A8", "\uCDA9\uBD81" }));
		typeRegion.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		typeRegion.setBounds(434, 375, 122, 35);
		add(typeRegion);

		typeCategory = new JComboBox();
		typeCategory.setModel(new DefaultComboBoxModel(
				new String[] { "[\uADFC\uBB34 \uD615\uD0DC]", "\uB9E4\uC7A5\uAD00\uB9AC", "\uC8FC\uBC29",
						"\uBBF8\uB514\uC5B4", "\uC6B4\uC804", "\uC0AC\uBB34", "IT", "\uC601\uC5C5", "\uAD50\uC721" }));
		typeCategory.setFont(new Font("나눔스퀘어", Font.PLAIN, 14));
		typeCategory.setBounds(219, 377, 122, 35);
		add(typeCategory);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(this.getClass().getResource("/resource/NoticeUpdate-2.jpg")));
		label_10.setBounds(0, 0, 1000, 600);
		add(label_10);

		resetTextField();
		settingData();
		settingButton();
	}

	// 업데이트 뷰 전환시 데이터 셋팅 메소드
	public void settingData() {
		Notice temp = null;
		if ((temp = noticeUpdateController.sendUserInformation()) != null) {
			typeRegion.setSelectedItem(temp.getAddr());
			tfBKeyword1.setText(temp.getbKeyword1());
			tfBKeyword2.setText(temp.getbKeyword2());
			tfBKeyword3.setText(temp.getbKeyword3());
			tfBName.setText(temp.getbName());
			typeCategory.setSelectedItem(temp.getCategory());
			tfPay.setText(Double.toString(temp.getPay()));
			tfTimeToTime.setText(temp.getTimeTotime());
			timeType.setSelectedItem(temp.getTimeType());
			periodType.setSelectedItem(temp.getPeriodType());
			taETC.setText(temp.getEtc());
		} else {
			lbErrorMsg.setText("등록X");
			resetTextField();
		}

	}

	// 버튼 셋팅 메소드
	private void settingButton() {
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backMove();
				resetTextField();
				settingData();
				win.getOwnerMainView().showResume();
			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
				resetTextField();
			}
		});

	}

	// 업데이트 메소드
	private void update() {
		// 입력 및 선택사항이 기본값일 경우
		if (!(typeRegion.getSelectedItem().toString().equals("[근무 지역]") && tfBName.getText().equals("")
				&& typeCategory.getSelectedItem().toString().equals("[근무 형태]") && tfPay.getText().equals("")
				&& tfTimeToTime.getText().equals("") && timeType.getSelectedItem().toString().equals("시간 선택")
				&& periodType.getSelectedItem().toString().equals("기간 선택"))) {
			// 업데이트 메소드 실행
			noticeUpdateController.updateNotice(tfBName.getText(), Double.parseDouble(tfPay.getText()),
					tfTimeToTime.getText(), typeCategory.getSelectedItem().toString(),
					typeRegion.getSelectedItem().toString(), periodType.getSelectedItem().toString(),
					timeType.getSelectedItem().toString(), tfBKeyword1.getText(), tfBKeyword2.getText(),
					tfBKeyword3.getText(), taETC.getText());

			resetTextField();
			backMove();

		} else {
			lbErrorMsg.setText("빈칸 없이 입력해 주세요.");
		}
	}

	// 뒤로가기 메소드
	private void backMove() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getOwnerMainView());
		win.setSize(1000, 620);
		revalidate();
		repaint();
		win.setVisible(false);
		win.setVisible(true);
	}

	// 입력 및 선택사항 기본 설정 메소드
	private void resetTextField() {
//		tfAddr.setText("");
		tfBKeyword1.setText("");
		tfBKeyword2.setText("");
		tfBKeyword3.setText("");
		tfBName.setText("");
//		tfCategory.setText("");
		tfPay.setText("");
		tfTimeToTime.setText("");
		timeType.setSelectedItem("시간 선택");
		periodType.setSelectedItem("기간 선택");
		typeCategory.setSelectedItem("[근무 형태]");
		typeRegion.setSelectedItem("[근무 지역]");
		taETC.setText("");
		lbErrorMsg.setText("");
	}

	// 구인공고 삭제 메소드
	private void delete() {
		noticeUpdateController.deleteNotice();
		noticeUpdateController.deleteConnection();
		noticeUpdateController.applyUpdate();
		win.getOwnerMainView().isNoticeTest();
	}
}
