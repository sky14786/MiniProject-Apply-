package com.job.view;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.job.model.Notice;
import javax.swing.ImageIcon;

public class JobSearchView2 extends JFrame {

	// private JPanel contentPane;
	private JobSearchView sub;
	public JLabel labelBname;
	private Notice temp3 = null;
	private JPanel contentPane;
	private JLabel labelPay;
	private JLabel labelTimeTotime;
	private JLabel labelTypeOccup;
	private JLabel labelRegion;
	private JLabel labelperiodType;
	private JLabel labelTypeTime;
	private JLabel labelKey1;
	private JLabel labelKey2;
	private JLabel labelKey3;
	private JLabel labelEtc;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JobSearchView2() {

		setBounds(100, 100, 450, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getContentPane().setLayout(null);

		labelBname = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelBname.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelBname.setBounds(92, 65, 333, 27);
		getContentPane().add(labelBname);

		labelPay = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelPay.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelPay.setBounds(72, 111, 349, 27);
		contentPane.add(labelPay);

		labelTimeTotime = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelTimeTotime.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelTimeTotime.setBounds(72, 157, 349, 27);
		contentPane.add(labelTimeTotime);

		labelTypeOccup = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelTypeOccup.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelTypeOccup.setBounds(114, 204, 311, 27);
		contentPane.add(labelTypeOccup);

		labelRegion = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelRegion.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelRegion.setBounds(76, 248, 349, 27);
		contentPane.add(labelRegion);

		labelperiodType = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelperiodType.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelperiodType.setBounds(114, 296, 311, 27);
		contentPane.add(labelperiodType);

		labelTypeTime = new JLabel("\uC815\uBCF4 \uC5C6\uC74C");
		labelTypeTime.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 18));
		labelTypeTime.setBounds(114, 342, 311, 27);
		contentPane.add(labelTypeTime);

		labelKey1 = new JLabel("\uD0A4\uC6CC\uB4DC 1");
		labelKey1.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		labelKey1.setBounds(92, 389, 311, 27);
		contentPane.add(labelKey1);

		labelKey2 = new JLabel("\uD0A4\uC6CC\uB4DC 2");
		labelKey2.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		labelKey2.setBounds(92, 426, 311, 27);
		contentPane.add(labelKey2);

		labelKey3 = new JLabel("\uD0A4\uC6CC\uB4DC 3");
		labelKey3.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		labelKey3.setBounds(92, 463, 311, 27);
		contentPane.add(labelKey3);

		labelEtc = new JLabel("\uB0B4\uC6A9 \uC5C6\uC74C");
		labelEtc.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		labelEtc.setBounds(10, 521, 411, 144);
		contentPane.add(labelEtc);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(this.getClass().getResource("/resource/SeeMoreViewMain.jpg")));
		background.setBounds(0, 0, 434, 674);
		contentPane.add(background);

	}

	public void subSearch2(Notice temp) {
		this.temp3 = temp;

		JobSearchView2 frame = new JobSearchView2();

		// È­¸é¿¡ ±¸ÀÎ°ø°í¿¡ ´ëÇÑ Á¤º¸ Ãâ·Â
		frame.labelBname.setText(temp3.getbName());
		frame.labelPay.setText(String.valueOf(temp3.getPay()));
		frame.labelTimeTotime.setText(temp3.getTimeType());
		frame.labelTypeOccup.setText(temp3.getCategory());
		frame.labelRegion.setText(temp3.getAddr());
		frame.labelperiodType.setText(temp3.getPeriodType());
		frame.labelTypeTime.setText(temp3.getTimeTotime());
		frame.labelKey1.setText(temp3.getbKeyword1());
		frame.labelKey2.setText(temp3.getbKeyword2());
		frame.labelKey3.setText(temp3.getbKeyword3());
		frame.labelEtc.setText(temp3.getEtc());

		frame.setVisible(true);
	}
}
