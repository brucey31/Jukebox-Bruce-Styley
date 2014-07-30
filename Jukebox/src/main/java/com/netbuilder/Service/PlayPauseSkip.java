package com.netbuilder.Service;

import sun.audio.AudioPlayer;

public class PlayPauseSkip extends PlayQueueArray {

	PlaySongsFromQueue psfq = new PlaySongsFromQueue();

	public void pauseSong() {
		System.out.println("User is trying to pause the song");
		psfq.stop();

	}

	/**
	 * This Method will start off the playQueue and instantiate a new thread to
	 * play the song independently of the program
	 */
	public void playSong() {
		System.out.println("User is trying to set off the playlist");
		playPLayQueue();
	}
}
