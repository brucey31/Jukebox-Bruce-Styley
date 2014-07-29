package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.netbuilder.DataAccess.JukeBox;

public class CoinButtonListener implements ActionListener {
//ATTRIBUTES
	//this is what button has been pressed on the dialog box for money added
	int result;
	@Override
	public void actionPerformed(ActionEvent e) {
		ClientView.clientControl.dispose();
		JFrame coinAdd = new JFrame();
		coinAdd.setSize(200, 100);
		coinAdd.setVisible(true);

		JPanel coinEntry = new JPanel();
		BorderLayout setDefaults = new BorderLayout();
		coinEntry.setLayout(setDefaults);

		Object[] options = { "25p", "50p", "£1" };
		result = JOptionPane.showOptionDialog(coinAdd,
				"Enter New Credit Now!\nEach song costs 25 pence",
				"Add New Credit", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		

		if (result < 1) {
			JukeBox.populateMoney(25);
			JOptionPane
					.showConfirmDialog(
							null,
							"25 pence has been added to available balance",
							"Money Added", JOptionPane.PLAIN_MESSAGE);
			ClientView.SetupClient();
		}

		else if (result > 0 && result < 2) {
			JukeBox.populateMoney(50);
			JOptionPane
			.showConfirmDialog(
					null,
					"50 pence has been added to available balance",
					"Money Added", JOptionPane.PLAIN_MESSAGE);
			ClientView.SetupClient();
		}

		else if (result > 1) {
			JukeBox.populateMoney(100);
			JOptionPane
			.showConfirmDialog(
					null,
					"£1 pence has been added to available balance",
					"Money Added", JOptionPane.PLAIN_MESSAGE);
			ClientView.SetupClient();
		}

	}

}
