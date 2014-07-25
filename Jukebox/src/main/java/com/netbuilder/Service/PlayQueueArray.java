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

	public List<Music> playQueue = new ArrayList<Music>();
	
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
	
	
	/**
	 * 
	 * This Method will add multiple songs to the playQueue arraylist
	 * @param songs
	 * @return
	 */
	public List<Music> addMultipleToQueue(List<Music> songs) {
		for(Music music : songs)
		{
	playQueue.add(music);
		}
		System.out.println(playQueue);

		return playQueue;
	}
	

	/**
	 * This method takes an int parameter and plays the song of the index of the int parameter in the playQueue Array
	 * @param trackCount
	 */
	public void playSongsFromQueue(int trackCount){
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
//		System.out.println(playQueue.get(trackCount).toString());
//		System.out.println(playQueue.get(trackCount).getTitle());
		
//I need to set the parameter for the below to a String that is the same as a title of the song to be player
		
		List<String> URL = em
				.createQuery(
						"select c.file_Path from Music c where Title LIKE:p")
				.setParameter("p", playQueue.get(trackCount).getTitle()).setMaxResults(6).getResultList();

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
	

/**
 * This method will test how long the playQueue is and play each song in turn waiting for the 
 */
public void playEntirePlaylist(){
	
//	playQueue.size() = int playlistSize;
	
	for(int i=0; i< playQueue.size();i++){
		playSongsFromQueue(i);
		
		//wait for the end of the song before replaying the for loop and doing the next one
		try {
			Thread.sleep(playQueue.get(i).getLength());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}}
