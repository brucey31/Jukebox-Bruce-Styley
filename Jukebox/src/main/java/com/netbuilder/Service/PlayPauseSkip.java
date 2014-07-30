package com.netbuilder.Service;

import javax.swing.JOptionPane;

public class PlayPauseSkip extends PlayQueueArray {

	PlaySongsFromQueue psfq = new PlaySongsFromQueue();

	/**
	 * This method pauses the music of the JukeBox This method is not a
	 * requirement and may not be used
	 */
	public void pauseSong() {
		System.out.println("User is trying to pause the song");

	}

	/**
	 * This Method will start off the playQueue and instantiate a new thread to
	 * play the song independently of the program
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
	 * JukeBox
	 */
	public void skipSong() {
		System.out.println("User is trying to pause the song");
		psfq.stop();
	
			
		}
	}

