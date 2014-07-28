package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchFuntionListener extends ClientView implements ActionListener{

	public void actionPerformed(ActionEvent evt) {

		String clickedButtonLabel = super.search.getSelectedText();

		// get it to get something that is typed in not just default value

		System.out.println(clickedButtonLabel);

		
	}
}
