package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.PlayPauseSkip;

/**
 * This actionListener class is activated when the user presses the play button.
 * @author Bruce Pannaman		
 * @version 1.0
 */
public class PlayButtonListener implements ActionListener{
	PlayPauseSkip pps = new PlayPauseSkip();
	@Override
	public void actionPerformed(ActionEvent e) {
		
		pps.playSong();
		
	}

}
