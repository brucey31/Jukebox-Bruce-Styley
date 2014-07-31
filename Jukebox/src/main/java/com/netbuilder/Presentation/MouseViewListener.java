package com.netbuilder.Presentation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This actionListener class is called when the user clicks on the search bar and clears it
 * 
 * @author Bruce Pannaman
 * @version 1.0
 *
 */
public class MouseViewListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
	ClientView.search.setText("");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
