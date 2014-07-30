package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.netbuilder.DataAccess.playQueue;
import com.netbuilder.Service.PlayRandomSongsFromQueue;
import com.netbuilder.Service.PlaySongsFromQueue;
import com.netbuilder.Service.PlayQueueArray;


public class GoBackListener implements ActionListener {
	
	//ATTRIBRIUTES
	static String password;
	final String setPassword = "admin";
	PlayRandomSongsFromQueue prsfq = new PlayRandomSongsFromQueue();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Admin Go Back Button has been pressed");
		AdminView.adminControl.dispose();
		ClientView.clientControl.dispose();
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
		
		password= JOptionPane
		.showInputDialog(
				adminEntry,
				"Going back to Client View\nEnter Password",
				"");
		
		if(password.equals((setPassword))){
//			prsfq.stop();
			ClientView.SetupClient();	
		}
		else{
			System.out.println(password);
			JOptionPane
			.showConfirmDialog(
					null,
					"Uh, Uh Uhhh",
					"Password Incorrect", JOptionPane.PLAIN_MESSAGE);
			AdminView.setupAdmin();
			
		}
			
	}

}
