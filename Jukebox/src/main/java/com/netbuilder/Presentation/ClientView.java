package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

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
@SuppressWarnings("serial")
public class ClientView extends JPanel {

	/**
	 * This search field is used in SearchFunctionListener
	 */
	private static JTextField search = new RoundJTextField("What do you want to listen to",20);

	/**
	 * This string changes what the result buttons say and is changes using
	 * SearchFunctionListener
	 */
	static String resultString;

	/**
	 * This is the JFrame that needs to be killed every page refresh
	 */
	private static JFrame clientControl;
	

	/**
	 * This method calls up the initial clientView screen
	 * this is the main view that the client will see
	 */
	public static void setupClient() {

		// this is the money balance part of the display, this label will
		// display the total balance available
		JLabel moneyBalance = new JLabel("Credit Available "
				+ String.valueOf(MoneyController.countMoney()) + "P");
		moneyBalance.setVisible(true);
		moneyBalance.setFont(new Font("Comic-Sans", Font.PLAIN, 30));
		moneyBalance.setBackground(Color.BLACK);
		moneyBalance.setForeground(Color.BLUE);

		// this coin button will be the button to add more money
		ImageIcon CoinButton = new ImageIcon("Coin.png");
		ActionListener moreMoney = new CoinButtonListener();
		JButton coins = new JButton("", CoinButton);
		coins.setOpaque(false);
		coins.setFont(new Font("Sans-Serif", Font.PLAIN, 10));
		coins.setPreferredSize(new Dimension(60, 60));
		coins.setBackground(Color.darkGray);
		coins.addActionListener(moreMoney);

		JLabel spacer = new JLabel("");
		spacer.setVisible(true);
		spacer.setPreferredSize(new Dimension(500, 30));

		// this small discreet Button will get you to the admin page to set
		// shuffle mode
		ActionListener adminClick = new AdminButtonListener();
		JButton admin = new JButton("•");
		admin.setOpaque(false);
		admin.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		admin.setPreferredSize(new Dimension(30, 30));
		admin.setForeground(Color.WHITE);
		admin.addActionListener(adminClick);
		admin.setContentAreaFilled(false);
		admin.setBorderPainted(false);

		JPanel money = new JPanel();
		money.setOpaque(false);
		money.setBackground(Color.darkGray);
		money.setPreferredSize(new Dimension(1400, 60));
		money.add(moneyBalance, JLabel.CENTER);
		money.add(coins);
		money.add(spacer);
		money.add(admin);

		// This is the playButton JButton
		ActionListener playlistener = new PlayButtonListener();
		ImageIcon PlayButton = new ImageIcon("Play Button.png");
		JButton play = new JButton("", PlayButton);
		play.setOpaque(false);
		play.setVisible(true);
		play.setBackground(Color.darkGray);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);
		play.addActionListener(playlistener);

		// This is the pauseButton JButton
		ActionListener pauselistener = new PauseButtonListener();
		ImageIcon PauseButton = new ImageIcon("Pause Button.png");
		JButton pause = new JButton("", PauseButton);
		pause.setOpaque(false);
		pause.setBorderPainted(false);
		pause.setContentAreaFilled(false);
		pause.addActionListener(pauselistener);

		// This is the Skip Button JButton
		ActionListener skiplistener = new SkipActionListener();
		ImageIcon SkipButton = new ImageIcon("Skip Button.png");
		JButton skip = new JButton("", SkipButton);
		skip.setOpaque(false);
		skip.setContentAreaFilled(false);
		skip.setBorderPainted(false);
		skip.addActionListener(skiplistener);

		// this panel collects the control Buttons
		JPanel ButtonControl = new JPanel();
		FlowLayout fl3 = new FlowLayout();
		ButtonControl.setLayout(fl3);
		ButtonControl.setOpaque(false);
		ButtonControl.setBackground(Color.DARK_GRAY);
		ButtonControl.setSize(800, 300);
		ButtonControl.add(play);
		ButtonControl.add(pause);
		ButtonControl.add(skip);

		// This is the search bar for clients to search for music
		ActionListener searchInput = new SearchFunctionListener();
		MouseListener mouse = new MouseViewListener();
		search.setVisible(true);
		search.setEditable(true);
		search.setBackground(Color.DARK_GRAY);
		search.setForeground(Color.lightGray);
		search.setFont(new Font("Comic-Sans", Font.PLAIN, 25));
		search.setPreferredSize(new Dimension(400, 60));
		search.addActionListener(searchInput);
		search.setHorizontalAlignment(JTextField.CENTER);
		search.addMouseListener(mouse);

		// this panel contains everything to do with searching for music
		JPanel searchBar = new JPanel();
		FlowLayout fl2 = new FlowLayout();
		searchBar.setLayout(fl2);
		searchBar.setOpaque(false);
		searchBar.setBackground(Color.darkGray);
		searchBar.setSize(200, 60);
		searchBar.add(search);

		// these are the buttons that will be called when the search result
		// is
		// found

		ActionListener playResult = new ResultListener();
		JButton firstResult = new JButton(resultString);
		firstResult.setPreferredSize(new Dimension(800, 100));
		firstResult.setVisible(true);
		firstResult.setOpaque(false);
		firstResult.setContentAreaFilled(false);
		firstResult.setBorderPainted(false);
		firstResult.setFont(new Font("Comic-Sans", Font.BOLD, 40));
		firstResult.setForeground(Color.WHITE);
		firstResult.addActionListener(playResult);

		// these are the buttons that will be called when the search result
		// is
		// found
		JButton secondResult = new JButton();
		secondResult.setPreferredSize(new Dimension(800, 50));
		secondResult.setVisible(true);
		secondResult.setOpaque(false);
		secondResult.setOpaque(false);
		secondResult.setContentAreaFilled(false);
		secondResult.setBorderPainted(false);
		secondResult.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		secondResult.setForeground(Color.WHITE);
		secondResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result is
		// found

		JButton thirdResult = new JButton();
		thirdResult.setPreferredSize(new Dimension(800, 50));
		thirdResult.setVisible(true);
		thirdResult.setOpaque(false);
		thirdResult.setOpaque(false);
		thirdResult.setContentAreaFilled(false);
		thirdResult.setBorderPainted(false);
		thirdResult.setFont(new Font("Comic-Sans", Font.BOLD, 16));
		thirdResult.setForeground(Color.WHITE);
		thirdResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result
		// is
		// found
		JButton fourthResult = new JButton();
		fourthResult.setSize(800, 50);
		fourthResult.setVisible(false);
		fourthResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result
		// is
		// found
		JButton fifthResult = new JButton();
		fifthResult.setBounds(0, 0, 800, 800);
		fifthResult.setVisible(false);
		fifthResult.setBackground(Color.darkGray);

		// these are the buttons that will be called when the search result
		// is
		// found
		JButton sixthResult = new JButton();
		sixthResult.setSize(800, 50);
		sixthResult.setVisible(false);
		sixthResult.setBackground(Color.darkGray);

		// this JPanel will hold the result panels
		JPanel resultPanel = new JPanel();
		GridLayout gl2 = new GridLayout(6, 1);
		resultPanel.setLayout(gl2);
		resultPanel.setOpaque(false);
		resultPanel.add(firstResult);
		resultPanel.add(secondResult);
		resultPanel.add(thirdResult);
		resultPanel.setPreferredSize(new Dimension(800, 200));

		// This is the main Label of the page that reads BRUCETUNES
		ImageIcon backGroundImage = new ImageIcon("animatedmusicmeter.gif");
		JLabel titleLabel = new JLabel(backGroundImage);
		titleLabel.setPreferredSize(new Dimension(600, 320));

		// This Panel Holds the Title piece for the page
		JPanel title = new JPanel();
		FlowLayout fl1 = new FlowLayout();
		title.setLayout(fl1);
		title.setOpaque(false);
		title.setPreferredSize(new Dimension(600, 320));
		title.add(titleLabel);

		// This is the holder for all the Items on the GUI
		JPanel holder = new JPanel();
		FlowLayout fLForAllItems = new FlowLayout();
		holder.setLayout(fLForAllItems);
		holder.setOpaque(false);
		holder.setSize(1400, 800);
		holder.setBackground(Color.darkGray);
		holder.add(money);
		holder.add(ButtonControl);
		holder.add(searchBar);
		holder.add(resultPanel);
		holder.add(title);

		// this JLabel contains the background image
		JLabel ContentPane = new JLabel();
		ImageIcon backImage = new ImageIcon("AbstractMusicBackground.jpg");
		ContentPane.setIcon(backImage);
		ContentPane.setLayout(new BorderLayout());
		ContentPane.add(holder);

		// This Jframe will contain everything
		clientControl = new JFrame("BruceTunes - By Bruce Pannaman");
		clientControl.setSize(1400, 800);
		clientControl.setVisible(true);
		clientControl.setContentPane(ContentPane);
		// clientControl.pack();
		clientControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientControl.setResizable(false);

	}
	
	//GETTERS AND SETTERS
	public static JTextField getSearch() {
		return search;
	}

	public static void setSearch(JTextField search) {
		ClientView.search = search;
	}



	public static JFrame getClientControl() {
		return clientControl;
	}

	public static void setClientControl(JFrame clientControl) {
		ClientView.clientControl = clientControl;
	}
}
