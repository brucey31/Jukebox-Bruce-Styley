package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * This actionListener class is called when the admin button is pressed and goes through a login page
 * 
 * @author Bruce Pannaman
 * @version 1.0
 *
 */
public class AdminButtonListener implements ActionListener {
/**
 * This is the password the admin has entered
 */
static String password;
/**
 * This is the set password for the admin account
 */
final String setPassword = "admin";

	@Override
	public void actionPerformed(ActionEvent e) {
		//Kills the clientView
		ClientView.getClientControl().dispose();
		JFrame adminEntry = new JFrame();
		adminEntry.setSize(200, 100);
		adminEntry.setVisible(true);

		JPanel passwordEntry = new JPanel();
		BorderLayout setDefaults = new BorderLayout();
		passwordEntry.setLayout(setDefaults);
		
		JLabel label = new JLabel("Enter a password:");
		JPasswordField pass = new JPasswordField(5);
		passwordEntry.add(label);
		passwordEntry.add(pass);
		
		//login JOptionPane
		password= JOptionPane
		.showInputDialog(
				adminEntry,
				"Entering a Restricted Admin Area\nEnter Password",
				"");
		
		// Validation for password
				try {
					if (password == null || (password != null && ("".equals(password)))) {
						ClientView.setupClient();
					}

					if (password.equals((setPassword))) {
						AdminView.setupAdmin();

					}

					if (!password.equals(setPassword)) {
						System.out.println("Wrong Password attempt" + password);
						JOptionPane.showConfirmDialog(null, "Uh, Uh Uhhh",
								"Password Incorrect", JOptionPane.PLAIN_MESSAGE);
						AdminView.setupAdmin();
					}
				} catch (NullPointerException err) {
					System.out.println("Password validation has failed");
					err.printStackTrace();
				}
		
	}

}
