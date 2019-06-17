package com.job.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import com.job.view.NoticeRegisterView;

import com.job.model.Resume;
import com.job.run.Run;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

//현식
public class OwnerDetailView extends JPanel {
	private Resume temp1 = null;
	private JLabel lbName;
	private JLabel lbAge;
	private JLabel lbGender;
	private JLabel lbPhone;
	private JLabel lbAcademic;
	private JLabel lbc;
	private JLabel lbcategory;
	private JLabel lbTimeOccup;
	private JLabel lbDow;
	private JLabel lbTimeType;
	private JLabel lbAddr;

	public Run win = new Run();

	public OwnerDetailView(Run win) {
		setLayout(null);
		setSize(581,800);

		Color fontColor = new Color(0x4f4f4f);

		lbName = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbName.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbName.setBounds(141, 157, 123, 32);
		lbName.setForeground(fontColor);
		add(lbName);

		lbAge = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbAge.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAge.setBounds(392, 159, 123, 32);
		lbAge.setForeground(fontColor);
		add(lbAge);

		lbGender = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbGender.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbGender.setBounds(137, 251, 123, 32);
		lbGender.setForeground(fontColor);
		add(lbGender);

		lbPhone = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbPhone.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbPhone.setBounds(389, 248, 164, 32);
		lbPhone.setForeground(fontColor);
		add(lbPhone);

		lbAcademic = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbAcademic.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAcademic.setBounds(139, 428, 123, 32);
		lbAcademic.setForeground(fontColor);
		add(lbAcademic);

		lbc = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbc.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbc.setBounds(391, 341, 123, 32);
		lbc.setForeground(fontColor);
		add(lbc);

		lbcategory = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbcategory.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbcategory.setBounds(349, 504, 165, 32);
		lbcategory.setForeground(fontColor);
		add(lbcategory);

		lbTimeOccup = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbTimeOccup.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbTimeOccup.setBounds(349, 584, 166, 32);
		lbTimeOccup.setForeground(fontColor);
		add(lbTimeOccup);

		lbDow = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbDow.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbDow.setBounds(349, 653, 166, 32);
		lbDow.setForeground(fontColor);
		add(lbDow);

		lbTimeType = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbTimeType.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbTimeType.setBounds(293, 428, 123, 32);
		lbTimeType.setForeground(fontColor);
		add(lbTimeType);

		lbAddr = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		lbAddr.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbAddr.setBounds(141, 341, 123, 32);
		lbAddr.setForeground(fontColor);
		add(lbAddr);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(430, 695, 123, 52);
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("/resource/BackButton.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
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

		JLabel lbBack = new JLabel("");
		lbBack.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		lbBack.setBounds(0, 0, 581, 783);
		lbBack.setIcon(new ImageIcon(this.getClass().getResource("/resource/SearchView2.jpg")));
		add(lbBack);
		btnNewButton.addActionListener(new ActionListener() {
			// 뒤로가기
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
	}

	public void OwnerDetailButton1(Resume temp) {

		lbName.setText(temp.getName());
		lbAge.setText(Integer.toString(temp.getAge()));
		lbGender.setText(temp.getGender());
		lbPhone.setText(temp.getPhone());
		lbAcademic.setText(temp.getAcademic());
		lbc.setText(temp.getCareer());
		lbcategory.setText(temp.getTypeOccup());
		lbTimeOccup.setText(temp.getPeriodType());
		lbDow.setText(temp.getDow());
		lbTimeType.setText("");
		lbAddr.setText(temp.getRegion());

	}
}
