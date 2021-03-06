package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.GenreRandomPlayQueueArray;

/**
 * This actionListener class is activated when the admin presses the speeches
 * atmosphere button and sets off a genre specific random playlist of speeches
 * and starts a new shuffle thread to play them
 * 
 * @author Bruce Pannaman
 * @version 1.0
 */
public class SpeechListener implements ActionListener {
	GenreRandomPlayQueueArray grpqr = new GenreRandomPlayQueueArray();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Speech Playlist Button has been pressed!");
		
		grpqr.setOffGenreShufflePlaylist("Speeches");
		if (!grpqr.shuffleThread.isAlive()) {
			grpqr.shuffleThread.start();
		}
	}

}
