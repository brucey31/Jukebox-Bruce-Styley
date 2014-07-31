package com.netbuilder.Service;

import javax.swing.JOptionPane;

/**
 * This class holds methods that pause, skip and play music (I.e. controller
 * methods)
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class PlayPauseSkip extends PlayQueueArray {

	// Here I initialize the separate Threads
	PlaySongsFromQueue psfq = new PlaySongsFromQueue();
	PlayRandomSongsFromQueue prsfq = new PlayRandomSongsFromQueue();

	/**
	 * This method pauses the music of the JukeBox This method is not a
	 * requirement and may not be used if I run out of time in the sprint
	 */
	public void pauseSong() {
		System.out.println("User is trying to pause the song");

	}

	/**
	 * This Method will start off the playQueue by calling playPlayQueue,
	 * preparing every song to be played and then starting musicThread to play
	 * it
	 */
	public void playSong() {
		System.out.println("User is trying to set off the playlist");

		if (!playQueue.isEmpty()) {
			playPLayQueue();
		}

		if (playQueue.isEmpty()) {
			JOptionPane
					.showMessageDialog(
							null,
							"There are no songs\nIn the Play Queue\nBuy a song to play it",
							"Nothing in Play Queue", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * This Method skips the Jukebox along the playQueue to the next song in the
	 * JukeBox. This works for both shuffle and music threads
	 */
	public void skipSong() {
		System.out.println("User is trying to skip the song");
		if (musicThread.isAlive()) {
			psfq.stop();
		}

		if (shuffleThread.isAlive()) {
			prsfq.stop();
		}

		if (!shuffleThread.isAlive() && !musicThread.isAlive()) {
			System.out
					.println("The Skip Button was pressed and neither string was alive\n");
		}

	}
}
