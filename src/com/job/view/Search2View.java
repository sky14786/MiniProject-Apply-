package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.job.controller.SearchController;
import com.job.model.Resume;
import com.job.run.Run;

public class Search2View extends JPanel {

	private Run win = new Run();
	private String inputvar;
	private ArrayList<Resume> rs4 = new ArrayList<Resume>();
	private SearchController sc = new SearchController();
	SearchView search = new SearchView(win);
	private JLabel lbName;
	private JLabel lbAge;
	private JLabel lbGender;
	private JLabel lbPhone;
	private JLabel lbRegion;
	private JLabel lbCareer;
	private JLabel lbAcademic;
	private JLabel lbTypeOccup;
	private JLabel lbPeriodType;
	private JLabel lbDow;

	public Search2View(Run win) {
		this.win = win;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		// 메인메뉴로 뒤로가기
		JButton button_4 = new JButton("");
		button_4.setBounds(430, 695, 123, 52);
		button_4.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.getContentPane().removeAll();
				win.getContentPane().add(win.getSearchView());
				revalidate();
				repaint();
				win.setSize(1000, 620);
				win.setVisible(false);
				win.setVisible(true);
			}
		});
		setVisible(true);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(242, 35, 84, 48);
		add(lblNewLabel);

		// 여기서부터 이력서 입력정보들어가는곳

		lbName = new JLabel();
		lbName.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbName.setBounds(140, 157, 123, 32);
		add(lbName);

		lbAge = new JLabel();
		lbAge.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAge.setBounds(387, 157, 123, 32);
		add(lbAge);

		lbGender = new JLabel();
		lbGender.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbGender.setBounds(140, 247, 123, 32);
		add(lbGender);

		lbRegion = new JLabel();
		lbRegion.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbRegion.setBounds(140, 338, 123, 32);
		add(lbRegion);

		lbAcademic = new JLabel();
		lbAcademic.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAcademic.setBounds(140, 426, 123, 32);
		add(lbAcademic);

		lbPhone = new JLabel();
		lbPhone.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbPhone.setBounds(387, 247, 156, 32);
		add(lbPhone);

		lbCareer = new JLabel();
		lbCareer.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbCareer.setBounds(387, 338, 123, 32);
		add(lbCareer);

		lbTypeOccup = new JLabel();
		lbTypeOccup.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbTypeOccup.setBounds(347, 503, 105, 32);
		add(lbTypeOccup);

		lbPeriodType = new JLabel();
		lbPeriodType.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbPeriodType.setBounds(347, 583, 113, 32);
		add(lbPeriodType);

		lbDow = new JLabel();
		lbDow.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbDow.setBounds(347, 653, 123, 32);
		add(lbDow);

		setBounds(100, 100, 581, 793);

		JLabel lbBack = new JLabel("");
		lbBack.setBounds(0, 0, 581, 783);
		lbBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchView2.jpg")));
		add(lbBack);
		setVisible(true);
	}

	public void dataSetting(Run win, Resume player) {

		lbName.setText(player.getName());
		lbAge.setText(String.valueOf(player.getAge()));
		lbGender.setText(player.getGender());
		lbPhone.setText(player.getPhone());
		lbRegion.setText(player.getRegion());
		lbCareer.setText(player.getCareer());
		lbAcademic.setText(player.getAcademic());
		lbTypeOccup.setText(player.getTypeOccup());
		lbPeriodType.setText(player.getPeriodType());
		lbDow.setText(player.getDow());

	}
}
