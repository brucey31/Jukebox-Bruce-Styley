package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GoBackListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Admin Go Back Button has been pressed");
		AdminView.adminControl.dispose();
		ClientView.SetupClient();		
	}

}
