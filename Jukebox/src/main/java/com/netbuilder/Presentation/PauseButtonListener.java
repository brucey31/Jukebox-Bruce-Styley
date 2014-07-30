package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.PlayPauseSkip;

public class PauseButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PlayPauseSkip pps = new PlayPauseSkip();
		pps.pauseSong();
		
	}

}
