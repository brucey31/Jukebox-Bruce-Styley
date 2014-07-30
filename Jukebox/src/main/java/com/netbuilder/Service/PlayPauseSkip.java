package com.netbuilder.Service;

import sun.audio.AudioPlayer;

public class PlayPauseSkip extends PlayQueueArray {

	PlaySongsFromQueue psfq = new PlaySongsFromQueue();

	/**
	 * This method pauses the music
	 * This method is not a requirement and may not be used
	 */
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
	
	public void skipSong(){
		
	}
}
