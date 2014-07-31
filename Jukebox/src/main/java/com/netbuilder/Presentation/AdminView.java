package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class hold the GUI that is show when the admin has logged in and is
 * setting an atmosphere or setting off a shuffle playlist
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class AdminView {
	
	/**
	 * This is globalised so that the admin page can be killed when the go back
	 * button is hit
	 */
	private static JFrame adminControl;

	/**
	 * This method calls up the admin screen once the admin has logged in
	 */
	public static void setupAdmin() {

		JLabel test = new JLabel("You have reached the Admin page",
				JLabel.CENTER);
		test.setVisible(true);
		test.setFont(new Font("Comic-Sans", Font.BOLD, 25));
		test.setSize(300, 50);
		test.setForeground(Color.WHITE);

		ActionListener random = new RandomPlaylistListener();
		JButton randomPlaylist = new JButton("Random PlayList Of All Songs");
		randomPlaylist.setVisible(true);
		randomPlaylist.setPreferredSize(new Dimension(300, 50));
		randomPlaylist.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		randomPlaylist.setForeground(Color.WHITE);
		randomPlaylist.addActionListener(random);
		randomPlaylist.setOpaque(false);
		randomPlaylist.setBorderPainted(false);
		randomPlaylist.setContentAreaFilled(false);

		ActionListener rock = new RockListener();
		JButton rockPlaylist = new JButton("Random PlayList Of Rock");
		rockPlaylist.setVisible(true);
		rockPlaylist.setPreferredSize(new Dimension(300, 50));
		rockPlaylist.addActionListener(rock);
		rockPlaylist.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		rockPlaylist.setForeground(Color.WHITE);
		rockPlaylist.setOpaque(false);
		rockPlaylist.setBorderPainted(false);
		rockPlaylist.setContentAreaFilled(false);

		ActionListener speeches = new SpeechListener();
		JButton speechesPlaylist = new JButton("Random PlayList Of Speeches");
		speechesPlaylist.setVisible(true);
		speechesPlaylist.setPreferredSize(new Dimension(300, 50));
		speechesPlaylist.addActionListener(speeches);
		speechesPlaylist.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		speechesPlaylist.setForeground(Color.WHITE);
		speechesPlaylist.setOpaque(false);
		speechesPlaylist.setBorderPainted(false);
		speechesPlaylist.setContentAreaFilled(false);

		ActionListener reggae = new ReggaeListener();
		JButton reggaePlaylist = new JButton("Random PlayListOf Reggae");
		reggaePlaylist.setVisible(true);
		reggaePlaylist.setPreferredSize(new Dimension(300, 50));
		reggaePlaylist.addActionListener(reggae);
		reggaePlaylist.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		reggaePlaylist.setForeground(Color.WHITE);
		reggaePlaylist.setOpaque(false);
		reggaePlaylist.setBorderPainted(false);
		reggaePlaylist.setContentAreaFilled(false);

		ActionListener pop = new PopListener();
		JButton popPlaylist = new JButton("Random PlayList Of A Pop");
		popPlaylist.setVisible(true);
		popPlaylist.setPreferredSize(new Dimension(300, 50));
		popPlaylist.addActionListener(pop);
		popPlaylist.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		popPlaylist.setForeground(Color.WHITE);
		popPlaylist.setOpaque(false);
		popPlaylist.setBorderPainted(false);
		popPlaylist.setContentAreaFilled(false);

		ActionListener goBackButton = new GoBackListener();
		JButton GoBack = new JButton("Return to Client Screen");
		GoBack.setVisible(true);
		GoBack.setPreferredSize(new Dimension(300, 50));
		GoBack.addActionListener(goBackButton);
		GoBack.setFont(new Font("Comic-Sans", Font.BOLD, 20));
		GoBack.setForeground(Color.WHITE);
		GoBack.setOpaque(false);
		GoBack.setBorderPainted(false);
		GoBack.setContentAreaFilled(false);

		// this holds everything in the Page
		JPanel holder = new JPanel();
		FlowLayout fl3 = new FlowLayout();
		holder.setLayout(fl3);
		holder.setOpaque(false);
		holder.setSize(500, 500);
		holder.add(test);
		holder.add(randomPlaylist);
		holder.add(popPlaylist);
		holder.add(rockPlaylist);
		holder.add(reggaePlaylist);
		holder.add(speechesPlaylist);
		holder.add(GoBack);

		// this JLabel sets the background
		JLabel ContentPane = new JLabel();
		ImageIcon backgroundImage = new ImageIcon("AbstractMusicBackground.jpg");
		ContentPane.setIcon(backgroundImage);
		ContentPane.setLayout(new BorderLayout());
		ContentPane.add(holder);

		adminControl = new JFrame("Admin Settings");
		adminControl.setSize(500, 500);
		adminControl.setVisible(true);
		adminControl.setContentPane(ContentPane);
		adminControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminControl.setResizable(false);

	}

	public static JFrame getAdminControl() {
		return adminControl;
	}

	public static void setAdminControl(JFrame adminControl) {
		AdminView.adminControl = adminControl;
	}
	
}
