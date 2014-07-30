package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.PlayPauseSkip;

public class SkipActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("The User is trying to skip the song");
		PlayPauseSkip pps = new PlayPauseSkip();
		pps.skipSong();
		
	}

}
