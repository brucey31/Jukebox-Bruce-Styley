package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.netbuilder.DataAccess.Music;
import com.netbuilder.Service.PlayRandomSongsFromQueue;
import com.netbuilder.Service.PlaySongsFromQueue;
import com.netbuilder.Service.PlayQueueArray;

/**
 * This actionListener class is activated when the admin wants to go back to the
 * clientpage. Another password validation takes place and then the system
 * resets to clear the shuffle playList
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class GoBackListener implements ActionListener {

	// ATTRIBRIUTES
	/**
	 * This is the password that the admin types in
	 */
	static String password;
	/**
	 * This is the set admin password for the system
	 */
	final String setPassword = "admin";
	PlayRandomSongsFromQueue prsfq = new PlayRandomSongsFromQueue();

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Admin Go Back Button has been pressed");
		AdminView.getAdminControl().dispose();
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

		password = JOptionPane.showInputDialog(adminEntry,
				"Going back to Client View\nEnter Password", "");
		
		// Validation for password
		if (password.equals((setPassword))) {
			// prsfq.stop();
			
			// Ran out of time to sort playQueue problem out so the whole system
			// resets when you exit the admin mode to completely clear playQueue
			System.exit(0);
			ClientView.SetupClient();

		} else {
			System.out.println(password);
			JOptionPane.showConfirmDialog(null, "Uh, Uh Uhhh",
					"Password Incorrect", JOptionPane.PLAIN_MESSAGE);
			AdminView.setupAdmin();

		}

	}

}
