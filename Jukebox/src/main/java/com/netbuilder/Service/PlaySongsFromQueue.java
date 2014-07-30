package com.netbuilder.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

class PlaySongsFromQueue extends PlayQueueArray implements Runnable {

	String soundFile;

	@Override
	public void run() {
		for (int i = 0; i < playQueue.size(); i++) {

			for (String s : URL) {

				System.out.println("This is the URL without the brackets\n"
						+ s.toString().replace("[", "")
								.replace("]", ""));

				soundFile = s.toString().replace("[", "")
						.replace("]", "");

				try {
					System.out.println("This is what it thinks soundFile is\n"
							+ soundFile);
					InputStream in = new FileInputStream(soundFile);
					AudioStream audioStream = new AudioStream(in);
					AudioPlayer.player.start(audioStream);

					// waits till the end of the song
					try {
						Thread.sleep(playQueue.get(i).getLength());
					} catch (InterruptedException e1) {
						System.out.println("Thread one was interupted");
						e1.printStackTrace();
					}

				} catch (FileNotFoundException e) {

					e.printStackTrace();

				} catch (IOException e) {

					Thread.currentThread().interrupt();
				}
			}
		}

	}

	public void stop() {
		System.out.println("User is trying to stop the thread");
		Thread.currentThread().destroy();
	}

}
