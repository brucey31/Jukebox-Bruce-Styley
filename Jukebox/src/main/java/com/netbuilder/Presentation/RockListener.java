package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.netbuilder.Service.GenreRandomPlayQueueArray;

public class RockListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Rock Playlist Button has been pressed!");
		GenreRandomPlayQueueArray grpqr = new GenreRandomPlayQueueArray();
		grpqr.SetOfGenreShufflePlaylist("Rock");
		if (!grpqr.one.isAlive()){
			grpqr.one.start();}
		
	}

}
