package com.netbuilder.Service;

public class PlayPauseSkip {
	
	PlaySongsFromQueue psfq = new PlaySongsFromQueue();

	public void pauseSong(){
		System.out.println("User is trying to pause the song");
	psfq.t.suspend();
}
	
	public void playSong(){
		System.out.println("User is trying to resume the song");
		psfq.t.resume();
	}
}
