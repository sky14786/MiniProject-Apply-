package com.job.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.job.run.Run;

public class SignUpCategory extends JPanel {
	private JButton btnPartimer, btnOwner;
	private LoginView loginview;
	public Run win;

	public SignUpCategory(Run win) {
		initialize();
		this.win = win;

	}

	private void initialize() {

		setLayout(null);

		btnPartimer = new JButton("");
		btnPartimer.setBounds(223, 0, 221, 271);
		add(btnPartimer);
		btnPartimer.setIcon(new ImageIcon(this.getClass().getResource("/resource/PartimerSignUpButton.jpg")));
		btnPartimer.setFont(new Font("배달의민족 주아", Font.PLAIN, 60));
		btnPartimer.setContentAreaFilled(false);
		btnPartimer.setBorderPainted(false);

		btnOwner = new JButton("");
		btnOwner.setBounds(0, 0, 211, 271);
		add(btnOwner);
		btnOwner.setIcon(new ImageIcon(this.getClass().getResource("/resource/OwnerSignUpButton.jpg")));
		btnOwner.setFont(new Font("배달의민족 주아", Font.PLAIN, 60));
		btnOwner.setContentAreaFilled(false);
		btnOwner.setBorderPainted(false);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 444, 271);
		add(label);
		label.setIcon(new ImageIcon(this.getClass().getResource("/resource/categoryBack.jpg")));

		settingButton();

	}

	private void settingButton() {
		btnOwner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showOwnerSignUpView();
			}
		});

		btnPartimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showPartimerSignUpView();
			}
		});
	}

	private void showOwnerSignUpView() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getOwnerSignUpView());
		win.setSize(1000, 600);
		revalidate();
		repaint();
	}

	private void showPartimerSignUpView() {
		win.getContentPane().removeAll();
		win.getContentPane().add(win.getPartimerSignView());
		win.setSize(1000, 600);
		revalidate();
		repaint();
	}

}
