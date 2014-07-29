package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.GenreRandomPlayQueueArray;

public class PopListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	System.out.println("Pop Playlist Button has been pressed!");
	GenreRandomPlayQueueArray grpqr = new GenreRandomPlayQueueArray();
	grpqr.SetOfGenreShufflePlaylist("Pop");
		
	}

}
