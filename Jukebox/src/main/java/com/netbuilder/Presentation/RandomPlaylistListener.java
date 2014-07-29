package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.RandomPlayQueueArray;


public class RandomPlaylistListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		RandomPlayQueueArray rpqa = new RandomPlayQueueArray();
		rpqa.SetOffShufflePlaylist();
		
	}

}
