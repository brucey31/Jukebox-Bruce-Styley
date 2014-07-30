package com.netbuilder.Service;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import sun.audio.*;

class PlaySongsFromQueue extends PlayQueueArray implements Runnable {

	String soundFile;
	InputStream in;
	AudioStream audioStream;
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
						// and playQueue so that it doesn't loop the purchased songs
						playQueue.remove(i);
						

					}

					catch (InterruptedException e1) {
						System.out.println("Thread musicThread was interupted");
						// this will stop the audio player playing the current song
						player.player.stop(audioStream);
						// this removes the song that was played from the URL
						// and playQueue so that it doesn't loop the purchased songs
						playQueue.remove(i);
					
						
						
					}

				} catch (FileNotFoundException e) {

					e.printStackTrace();

				} catch (IOException e) {

					Thread.currentThread().interrupt();
				}
			}
		}
		playPLayQueue();
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		System.out.println("User is trying to stop the thread");

		// this will stop the wait till the song has ended
		musicThread.interrupt();

		// this will stop the audio player playing the current song
//		this.player.player.stop(audioStream);

	}
}
