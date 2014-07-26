package com.netbuilder.Service;

import sun.audio.AudioPlayer;

/**
 * This Class will contain methods to control the player:
 * 1) skip to the next song in the playQueue
 * 2) Pause the music
 * @author Bruce Pannaman
 * @version 1.0
 * 
 *
 */
public class ListeningControls extends PlayQueueArray {
	
	@SuppressWarnings("deprecation")
	public void skipSong(){
		AudioPlayer.player.stop();
		
	}
	
	@SuppressWarnings("deprecation")
	public void pauseSong(){
		AudioPlayer.player.suspend();
	}
	
	@SuppressWarnings("deprecation")
	public void unPauseSong(){
		AudioPlayer.player.resume();
	}

}
