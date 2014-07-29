package com.netbuilder.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

class PlaySongsFromQueue extends PlayQueueArray implements Runnable {

	@Override
	public void run() {
		try {
			PlayQueueArray pqa = new PlayQueueArray();

			InputStream in = new FileInputStream(pqa.soundFile);
			AudioStream audioStream = new AudioStream(in);
			AudioPlayer.player.start(audioStream);

			try {
				for (int i = 0; i < playQueue.size(); i++) {
					Thread.sleep(playQueue.get(i).getLength());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
