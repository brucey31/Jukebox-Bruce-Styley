package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.GenreRandomPlayQueueArray;

/**
 * This actionListener class is activated when the admin presses the pop
 * atmosphere button and sets off a genre specific random playlist of pop songs
 * and starts a new shuffle thread to play them
 * 
 * @author Bruce Pannaman
 * @version 1.0
 */
public class PopListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pop Playlist Button has been pressed!");
		GenreRandomPlayQueueArray grpqr = new GenreRandomPlayQueueArray();
		grpqr.setOffGenreShufflePlaylist("Pop");
		if (!grpqr.shuffleThread.isAlive()) {
			grpqr.shuffleThread.start();
		}

	}
}
