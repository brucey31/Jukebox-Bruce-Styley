package com.netbuilder.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * This class is my shuffleThread that is separate from my main program and plays
 * the shuffle mode specified playlist
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class PlayRandomSongsFromQueue extends PlayQueueArray implements
		Runnable {

	/**
	 * This is the FilePath string to be used
	 */
	String soundFile;
	InputStream in;
	/**
	 * This Sun audioStream sets up the music
	 */
	AudioStream audioStream;
	/**
	 * This sun audioPlayer plays the music
	 */
	AudioPlayer player;

	@Override
	public void run() {
		for (int i = 0; i < playQueue.size(); i++) {

			for (String s : URL) {

				System.out.println("This is the URL without the brackets\n"
						+ s.toString().replace("[", "").replace("]", ""));

				soundFile = s.toString().replace("[", "").replace("]", "");

				try {
					System.out.println("This is what it thinks soundFile is\n"
							+ soundFile);

					in = new FileInputStream(soundFile);
					audioStream = new AudioStream(in);
					player.player.start(audioStream);

					// waits till the end of the song
					try {
						Thread.sleep(playQueue.get(i).getLength());
						// this removes the song that was played from the URL
						// and playQueue so that it doesn't loop the purchased
						// songs
						playQueue.remove(i);

					}

					catch (InterruptedException e1) {
						// when the Thread has been because of a skip button or
						// something it has to kill the wait till the song has
						// finished and kill the player from before
						System.out
								.println("Thread shuffleThread was interupted");
						// this will stop the audio player playing the current
						// song
						player.player.stop(audioStream);
						// this removes the song that was played from the URL
						// and playQueue so that it doesn't loop the purchased
						// songs
						playQueue.remove(i);

					}

				} catch (FileNotFoundException e) {

					e.printStackTrace();

				} catch (IOException e) {

					Thread.currentThread().interrupt();
				}
			}
		}
		playRandomPLayQueue();
		Thread.currentThread().stop();

	}

	@SuppressWarnings("deprecation")
	public void stop() {
		System.out.println("admin is trying to stop the random thread");

		// this will kill the whole shuffle playlist created by either shuffle
		// function
		while (!PlayQueueArray.getPlayQueue().isEmpty()) {
			shuffleThread.interrupt();
			shuffleThread.destroy();

		}
		shuffleThread.interrupt();
		shuffleThread.destroy();

	}
	
	//GETTERS AND SETTERS

	public AudioPlayer getPlayer() {
		return player;
	}

	public void setPlayer(AudioPlayer player) {
		this.player = player;
	}

}
