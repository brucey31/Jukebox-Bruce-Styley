package com.netbuilder.Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminView {

	public static void setupAdmin() {

		JLabel test = new JLabel("You Have Reached the Admin page");
		
		ActionListener random = new RandomPlaylistListener();
		JButton randomPlaylist = new JButton("Random PlayList Of All Songs");
		randomPlaylist.setVisible(true);
		randomPlaylist.setPreferredSize(new Dimension(300,50));
		randomPlaylist.addActionListener(random);
		
		
		JButton speechesPlaylist = new JButton("Random PlayList Of Speeches");
		speechesPlaylist.setVisible(true);
		speechesPlaylist.setPreferredSize(new Dimension(300,50));
		
		JButton reggaePlaylist = new JButton("Random PlayList Of Reggae");
		reggaePlaylist.setVisible(true);
		reggaePlaylist.setPreferredSize(new Dimension(300,50));
		
		JButton popPlaylist = new JButton("Random PlayList Of A Pop");
		popPlaylist.setVisible(true);
		popPlaylist.setPreferredSize(new Dimension(300,50));
		
		
		
		
		
		JPanel holder = new JPanel();
		FlowLayout fl3 = new FlowLayout();
		holder.setLayout(fl3);
		holder.setOpaque(true);
		holder.setSize(500, 500);
		holder.setBackground(Color.darkGray);
		holder.add(test);
		holder.add(randomPlaylist);
		holder.add(popPlaylist);
		holder.add(reggaePlaylist);
		holder.add(speechesPlaylist);
		

		JFrame adminControl = new JFrame("Admin Settings");
		adminControl.setSize(500, 500);
		adminControl.setVisible(true);
		adminControl.setContentPane(holder);
	
		adminControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminControl.setResizable(false);

	}
}
