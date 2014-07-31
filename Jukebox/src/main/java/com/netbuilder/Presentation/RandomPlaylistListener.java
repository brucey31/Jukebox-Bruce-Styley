package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.RandomPlayQueueArray;

/**
 * This actionListener class is activated when the admin presses the random
 * playlist shuffle button and activated the SetOffShufflePlaylist method and
 * creates a random playlist of songs then starts a new shuffle thread to play them
 * 
 * @author Bruce Pannaman
 * @version 1.0
 */
public class RandomPlaylistListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		RandomPlayQueueArray rpqa = new RandomPlayQueueArray();
		rpqa.SetOffShufflePlaylist();
		if (!rpqa.shuffleThread.isAlive()) {
			rpqa.shuffleThread.start();
		}

	}

}
