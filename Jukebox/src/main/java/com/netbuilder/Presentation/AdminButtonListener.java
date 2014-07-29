package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminButtonListener implements ActionListener {
static String password;
final String setPassword = "admin";
	@Override
	public void actionPerformed(ActionEvent e) {
		ClientView.clientControl.dispose();
		JFrame adminEntry = new JFrame();
		adminEntry.setSize(200, 100);
		adminEntry.setVisible(true);

		JPanel passwordEntry = new JPanel();
		BorderLayout setDefaults = new BorderLayout();
		passwordEntry.setLayout(setDefaults);
		
		password= JOptionPane
		.showInputDialog(
				adminEntry,
				"Entering a Restricted Admin Area\nEnter Password",
				"");
		
		if(password.equals(setPassword)){
			AdminView.setupAdmin();
		}
		else{
			System.out.println(password);
			JOptionPane
			.showConfirmDialog(
					null,
					"Uh, Uh Uhhh",
					"Password Incorrect", JOptionPane.PLAIN_MESSAGE);
		
		}
		
	}

}
