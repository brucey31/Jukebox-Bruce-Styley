package com.netbuilder.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import com.netbuilder.DataAccess.Music;

/**
 * This Class contains the methods to deal with adding, moving and moving through the
 * playQueue
 * 
 * @author Bruce Pannaman
 * @version
 * 
 */
public class PlayQueueArray {

	List<Music> playQueue = new ArrayList<Music>();
	
	int songAdded = 3;

	/**
	 * This Method will add an int to the playQueue array that will refer to a
	 * musicID thus a song in the database
	 * 
	 * @param songAdded
	 * @return
	 */
	public List<Music> addToQueue(Music song) {
		
	playQueue.add(song);
		
		System.out.println(playQueue);

		return playQueue;
	}
	
	
	public List<Music> addMultipleToQueue(List<Music> songs) {
		for(Music music : songs)
		{
	playQueue.add(music);
		}
		System.out.println(playQueue);

		return playQueue;
	}
	

	public void playSongsFromQueue(List<Music> playQueue){
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();
		//I have fed into this method a list that holds music objects, below I need to get the title out of that object
		playQueue
		
		String title;
//I need to set the parameter for the below to a String that is the same as a title of the song to be player
		
		List<String> URL = em
				.createQuery(
						"select c.file_Path from Music c where Title LIKE:p")
				.setParameter("p", title).setMaxResults(6).getResultList();

		for (String string : URL) {

			System.out
					.println(URL.toString().replace("[", "").replace("]", ""));

			try {
				String soundFile = URL.toString().replace("[", "")
						.replace("]", "");
				InputStream in = new FileInputStream(soundFile);
				AudioStream audioStream = new AudioStream(in);
				AudioPlayer.player.start(audioStream);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	}

}
