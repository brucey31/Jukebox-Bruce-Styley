package com.netbuilder.Presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminView {

	public static void setupAdmin() {

		JLabel test = new JLabel("You Have Reached the Admin page");
		
		
		JPanel holder = new JPanel();
		FlowLayout fl3 = new FlowLayout();
		holder.setLayout(fl3);
		holder.setOpaque(true);
		holder.setSize(500, 500);
		holder.setBackground(Color.darkGray);
		holder.add(test);

		JFrame adminControl = new JFrame("Admin Settings");
		adminControl.setSize(500, 500);
		adminControl.setVisible(true);
		adminControl.setContentPane(holder);
	
		adminControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminControl.setResizable(false);

	}
}
