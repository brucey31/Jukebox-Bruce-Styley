package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This Class contains the GUI screen for the standard user functionality (Not admin privilages)
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class ClientView {

	/**
	 * this is the main view that the client will see
	 */
	public void setupClient() {

		//This is the main Label of the page that reads BRUCETUNES
		JLabel titleLabel = new JLabel("BruceTunes", JLabel.CENTER);
		titleLabel.setFont(new Font("Comic-Sans", Font.ITALIC ,55));
		titleLabel.setBackground(Color.BLACK);
		titleLabel.setForeground(Color.BLUE);
		
	
		// This Panel Holds the Title piece for the page
		JPanel title = new JPanel();
		FlowLayout fl1 = new FlowLayout();
		title.setLayout(fl1);
		title.setOpaque(true);
		title.setBackground(Color.darkGray);
		title.setSize(100, 50);
		title.add(titleLabel);
		
		
		JLabel moneyBalance = new JLabel("e.g. 80p", JLabel.CENTER);
		moneyBalance.setVisible(true);
		moneyBalance.setFont(new Font("Times New Roman",Font.PLAIN, 20));
		moneyBalance.setBackground(Color.BLACK);
		moneyBalance.setForeground(Color.BLUE);
		
		JPanel money = new JPanel();
		money.setOpaque(true);	
		money.setBackground(Color.darkGray);
		
		money.add(moneyBalance);
			
		
		//This is the search bar for clients to search for music
		JTextField search = new JTextField("What do you want to Listen to?", JTextField.CENTER);
		search.setVisible(true);
		search.setEditable(true);
		search.setBackground(Color.WHITE);
		search.setForeground(Color.BLACK);
		search.setFont(new Font("Times New Roman", Font.PLAIN,25));
		
		MONEY BALENCE HAS TO GO AT TOP USE FLOW LAYOUT FOR THE MAIN HOLDER BUT MAKE NEW JPANELS TO GROUP PARTS TOGETHER SUCH AS TITLE AND SEARCH PANELS
		
		//This Button will start the search
		JButton searchButton = new JButton("Search");
		searchButton.setSize(50,20);
		searchButton.setVisible(true);
		searchButton.setBackground(Color.LIGHT_GRAY);
		
		//this panel contains everything to do with searching for music
		JPanel searchBar = new JPanel();
		FlowLayout fl2 = new FlowLayout();
		searchBar.setLayout(fl2);
		searchBar.setOpaque(true);
		searchBar.setBackground(Color.darkGray);
		searchBar.setSize(200, 60);
		searchBar.add(searchButton);
		searchBar.add(search);
		
		//This panel will list the results for the search
		JPanel results = new JPanel();
		

		// This is the holder for everything on the JFrame
		JPanel holder = new JPanel();
		FlowLayout fLForAllItems = new FlowLayout();
//		BorderLayout bLForAllItems = new BorderLayout();
//		holder.setLayout(bLForAllItems);
		holder.setLayout(fLForAllItems);
		holder.setOpaque(true);
		holder.setSize(1400,800);
		holder.setBackground(Color.darkGray);
		holder.add(money);
		holder.add( title);
		holder.add( searchBar);
		
		

		// This Jframe will contain everything
		JFrame clientControl = new JFrame("BruceTunes - By Bruce Pannaman");
		clientControl.setSize(1400, 800);
		clientControl.setVisible(true);
		clientControl.setContentPane(holder);
			clientControl.pack();
		clientControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientControl.setResizable(false);

	}
}
