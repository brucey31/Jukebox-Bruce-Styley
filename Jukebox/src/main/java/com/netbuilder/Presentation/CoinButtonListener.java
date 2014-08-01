package com.netbuilder.Presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.netbuilder.DataAccess.BruceTunes;

/**
 * This actionListener class is called when the user pressed the coin button to add money
 * 
 * @author Bruce Pannaman
 * @version 1.0
 */
public class CoinButtonListener implements ActionListener {

	/**
	 * this is what button has been pressed on the dialog box for money added
	 */
	int result;
	@Override
	public void actionPerformed(ActionEvent e) {
		ClientView.getClientControl().dispose();
		JFrame coinAdd = new JFrame();
		coinAdd.setSize(200, 100);
		coinAdd.setVisible(true);

		JPanel coinEntry = new JPanel();
		BorderLayout setDefaults = new BorderLayout();
		coinEntry.setLayout(setDefaults);

		//option pane to decide how much money to put in
		Object[] options = { "25p", "50p", "£1" };
		result = JOptionPane.showOptionDialog(coinAdd,
				"Enter New Credit Now!\nEach song costs 25 pence",
				"Add New Credit", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		

		if (result < 1) {
			//Persist 25p to Database
			BruceTunes.populateMoney(25);
			//Validation for User
			JOptionPane
					.showConfirmDialog(
							null,
							"25 pence has been added to available balance",
							"Money Added", JOptionPane.PLAIN_MESSAGE);
			//Refresh clientView
			ClientView.setupClient();
		}

		else if (result > 0 && result < 2) {
			//Persist 50p to Database
			BruceTunes.populateMoney(50);
			//Validation for User
			JOptionPane
			.showConfirmDialog(
					null,
					"50 pence has been added to available balance",
					"Money Added", JOptionPane.PLAIN_MESSAGE);
			//Refresh clientView
			ClientView.setupClient();
		}

		else if (result > 1) {
			//Persist £1 to Database
			BruceTunes.populateMoney(100);
			//Validation for User
			JOptionPane
			.showConfirmDialog(
					null,
					"£1 has been added to available balance",
					"Money Added", JOptionPane.PLAIN_MESSAGE);
			//Refresh clientView
			ClientView.setupClient();
		}

	}

}
