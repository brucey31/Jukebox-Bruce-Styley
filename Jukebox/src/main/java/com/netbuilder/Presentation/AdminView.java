package com.netbuilder.Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminView {
	//ATTRIBUTES
	//This is globalised so that the admin page can be killed when the go back button is hit
	static JFrame adminControl;
	
	
	public static void setupAdmin() {

		JLabel test = new JLabel("You Have Reached\nThe Admin page",JLabel.CENTER);
		test.setVisible(true);
		test.setFont(new Font("Cambria", Font.BOLD,25));
		test.setSize(300, 50);
		test.setForeground(Color.WHITE);
		
		ActionListener random = new RandomPlaylistListener();
		JButton randomPlaylist = new JButton("Random PlayList Of All Songs");
		randomPlaylist.setVisible(true);
		randomPlaylist.setPreferredSize(new Dimension(300,50));
		randomPlaylist.addActionListener(random);
		
		ActionListener rock = new RockListener();
		JButton rockPlaylist = new JButton("Random PlayList Of Rock");
		rockPlaylist.setVisible(true);
		rockPlaylist.setPreferredSize(new Dimension(300,50));
		rockPlaylist.addActionListener(rock);
		
		ActionListener speeches = new SpeechListener();
		JButton speechesPlaylist = new JButton("Random PlayList Of Speeches");
		speechesPlaylist.setVisible(true);
		speechesPlaylist.setPreferredSize(new Dimension(300,50));
		speechesPlaylist.addActionListener(speeches);
		
		ActionListener reggae = new ReggaeListener();
		JButton reggaePlaylist = new JButton("Random PlayList Of Reggae");
		reggaePlaylist.setVisible(true);
		reggaePlaylist.setPreferredSize(new Dimension(300,50));
		reggaePlaylist.addActionListener(reggae);
		
		ActionListener pop = new PopListener();
		JButton popPlaylist = new JButton("Random PlayList Of A Pop");
		popPlaylist.setVisible(true);
		popPlaylist.setPreferredSize(new Dimension(300,50));
		popPlaylist.addActionListener(pop);
		
		ActionListener goBackButton = new GoBackListener();
		JButton GoBack = new JButton("Return to Client Screen");
		GoBack.setVisible(true);
		GoBack.setPreferredSize(new Dimension(300,50));
		GoBack.addActionListener(goBackButton);
		
		
		
		
		
		
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
		holder.add(GoBack);
		

		adminControl = new JFrame("Admin Settings");
		adminControl.setSize(500, 500);
		adminControl.setVisible(true);
		adminControl.setContentPane(holder);
	
		adminControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminControl.setResizable(false);

	}
}
