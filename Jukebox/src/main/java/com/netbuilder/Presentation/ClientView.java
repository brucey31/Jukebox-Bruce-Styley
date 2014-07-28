package com.netbuilder.Presentation;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import com.netbuilder.DataAccess.MoneyController;

/**
 * This Class contains the GUI screen for the standard user functionality (Not
 * admin privilages)
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class ClientView {
	
	//Attributes for the GUI

JTextField search = new JTextField("What do you want to Listen to",
		JTextField.CENTER);



	/**
	 * this is the main view that the client will see
	 */
	public void setupClient() {

		// this is the money balance part of the display, this label will display the total balance available
		JLabel moneyBalance = new JLabel("Credit Available " + String.valueOf(MoneyController.countMoney())+ "Pence");
		moneyBalance.setVisible(true);
		moneyBalance.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		moneyBalance.setBackground(Color.BLACK);
		moneyBalance.setForeground(Color.BLUE);
		
		//this coin button will be the button to add more money
//		ImageIcon PlayButton = new ImageIcon("Coin.png");
		JButton coins = new JButton("+$+");
		coins.setOpaque(false);
		coins.setFont(new Font("Sans-Serif", Font.PLAIN,10));
		coins.setPreferredSize(new Dimension(30,30));


		//this small discreet Button will get you to the admin page to set shuffle mode
		JButton admin = new JButton("•");
		admin.setOpaque(false);
		admin.setFont(new Font("Sans-Serif", Font.PLAIN,10));
		admin.setPreferredSize(new Dimension(20,20));
		
		JPanel money = new JPanel();
		money.setOpaque(true);
		money.setBackground(Color.darkGray);
		money.setPreferredSize(new Dimension(1400, 40));
		money.add(moneyBalance);
		money.add(coins);
		

		// This is the playButton JButton
		ImageIcon PlayButton = new ImageIcon("Play Button.png");
		JButton play = new JButton("", PlayButton);
		play.setOpaque(false);
		play.setVisible(true);
		play.setBackground(Color.darkGray);
		play.setPreferredSize(new Dimension(180, 180));

		// This is the pauseButton JButton
		 ImageIcon PauseButton = new
		 ImageIcon("/Users/Brucee/Documents/Git Repository/Jukebox-Bruce-Styley/Jukebox/Pause Button.png");
		JButton pause = new JButton("",PauseButton);
		pause.setOpaque(false);
		pause.setPreferredSize(new Dimension(180, 180));

		// This is the Skip Button JButton
		 ImageIcon SkipButton = new
		 ImageIcon("/Users/Brucee/Documents/Git Repository/Jukebox-Bruce-Styley/Jukebox/Skip Button.png");
		JButton skip = new JButton("",SkipButton);
		skip.setOpaque(false);

		// this panel collects the control Buttons
		JPanel ButtonControl = new JPanel();
		ButtonControl.setOpaque(false);
		ButtonControl.setBackground(Color.DARK_GRAY);
		ButtonControl.setPreferredSize(new Dimension(600, 200));
		ButtonControl.add(play);
		ButtonControl.add(pause);
		ButtonControl.add(skip);

		
		
		// This is the search bar for clients to search for music
		ActionListener searchInput = new SearchFuntionListener();
		
		search.setVisible(true);
		search.setEditable(true);
		search.setBackground(Color.lightGray);
		search.setForeground(Color.DARK_GRAY);
		search.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		search.addActionListener(searchInput);
		search.setHorizontalAlignment(JTextField.CENTER);


		// this panel contains everything to do with searching for music
		JPanel searchBar = new JPanel();
		FlowLayout fl2 = new FlowLayout();
		searchBar.setLayout(fl2);
		searchBar.setOpaque(true);
		searchBar.setBackground(Color.darkGray);
		searchBar.setSize(200, 60);
		searchBar.add(search);

		// these are the buttons that will be called when the search result is
		// found
		JButton firstResult = new JButton();
		firstResult.setPreferredSize(new Dimension(800, 50));
		firstResult.setVisible(true);
		firstResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result is
		// found
		JButton secondResult = new JButton();
		secondResult.setSize(800, 50);
		secondResult.setVisible(true);
		secondResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result is
		// found
		JButton thirdResult = new JButton();
		thirdResult.setSize(800, 50);
		thirdResult.setVisible(true);
		thirdResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result is
		// found
		JButton fourthResult = new JButton();
		fourthResult.setSize(800, 50);
		fourthResult.setVisible(true);
		fourthResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result is
		// found
		JButton fifthResult = new JButton();
		fifthResult.setBounds(0, 0, 800, 800);
		fifthResult.setVisible(true);
		fifthResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result is
		// found
		JButton sixthResult = new JButton();
		sixthResult.setSize(800, 50);
		sixthResult.setVisible(true);
		sixthResult.setBackground(Color.darkGray);

		// this JPanel will hold the result panels
		JPanel resultPanel = new JPanel();
		GridLayout gl2 = new GridLayout(6, 1);
		resultPanel.setLayout(gl2);
		resultPanel.setOpaque(false);
		resultPanel.setSize(1000, 500);
		resultPanel.add(firstResult);
		resultPanel.add(secondResult);
		resultPanel.add(thirdResult);
		resultPanel.add(fourthResult);
		resultPanel.add(fifthResult);
		resultPanel.add(sixthResult);

		// This is the main Label of the page that reads BRUCETUNES
		JLabel titleLabel = new JLabel("BruceTunes", JLabel.LEFT);
		titleLabel.setFont(new Font("Comic-Sans", Font.ITALIC, 55));
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setForeground(Color.BLUE);

		// This Panel Holds the Title piece for the page
		JPanel title = new JPanel();
		FlowLayout fl1 = new FlowLayout();
		title.setLayout(fl1);
		title.setOpaque(true);
		title.setBackground(Color.darkGray);
		title.setPreferredSize(new Dimension(700, 60));
		title.add(titleLabel);

		// This is the holder for everything on the JFrame
		JPanel holder = new JPanel();
		FlowLayout fLForAllItems = new FlowLayout();
		// BorderLayout bLForAllItems = new BorderLayout();
		// holder.setLayout(bLForAllItems);
		holder.setLayout(fLForAllItems);
		holder.setOpaque(true);
		holder.setSize(1400, 800);
		holder.setBackground(Color.darkGray);
		holder.add(money);
		money.add(admin);
		holder.add(ButtonControl);

		holder.add(searchBar);
		holder.add(resultPanel);
		holder.add(title);

		// This Jframe will contain everything
		JFrame clientControl = new JFrame("BruceTunes - By Bruce Pannaman");
		clientControl.setSize(1400, 800);
		clientControl.setVisible(true);
		clientControl.setContentPane(holder);
		// clientControl.pack();
		clientControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientControl.setResizable(false);

	}
}
