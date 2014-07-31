package com.netbuilder.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.netbuilder.DataAccess.JukeBox;
import com.netbuilder.DataAccess.Music;

/**
 * This Class contains the methods to deal with adding, moving and moving
 * through the playQueue
 * 
 * @author Bruce Pannaman
 * @version
 * 
 */
public class PlayQueueArray {

	/**
	 * This ArrayList is used throughout the service layer and protected so that it can be used in subsequent
	 * children... Go PolyMorphism!!
	 */
	protected volatile static List<Music> playQueue = new ArrayList<Music>();

	/**
	 * This list contains the playQueue list but instead of music objects it
	 * contains filePath strings and is used in the separate threads to play
	 * songs
	 */
	protected volatile static List<String> URL = new ArrayList<String>();;

	/**
	 * This instantiates a new Thread Called "musicThread" which plays plays the
	 * play queue that has been selected by the user
	 */
	public static Thread musicThread = new Thread(new PlaySongsFromQueue());

	/**
	 * This instantiates a new Thread Called "shuffleThread" which plays plays
	 * the play queue that has been selected by the shuffle function
	 */
	public static Thread shuffleThread = new Thread(
			new PlayRandomSongsFromQueue());

	/**
	 * This method will add a singular song to the playQueue thus is not used
	 * because we want to add multiple songs to the playQueue.
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
	 * This Method will add multiple songs to the playQueue arrayList one by one
	 * 
	 * @param songs
	 * @return
	 */
	public List<Music> addMultipleToQueue(List<Music> songs) {
		JukeBox.populatePurchase();
		for (Music music : songs) {
			playQueue.add(music);
		}
		System.out.println("This is the play queue as it stands\n\n"
				+ playQueue);

		return playQueue;
	}

	/**
	 * This method prepares the playQueue to be played; The trackCount of where
	 * playPlayQueue in its loop is taken. It then adds the URL of each element
	 * of the playQueue and writes it to another list called URL that is called
	 * in the separate thread
	 * 
	 * @param trackCount
	 */
	public void preparePlayQueueToBePlayed(int trackCount) {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		// Below are tests to check the parameters being inputed to the SQL
		// Query
		// System.out.println(playQueue.get(trackCount).toString());
		// System.out.println(playQueue.get(trackCount).getTitle());

		// @SuppressWarnings("Unchecked")-Sometimes Java generics just doesn't
		// let you do what you want to, and
		// you need to effectively tell the compiler that what you're doing
		// really will be legal at execution time.

		List<String> temp = em
				.createQuery(
						"select c.file_Path from Music c where Title LIKE:p")
				.setParameter("p", playQueue.get(trackCount).getTitle())
				.setMaxResults(6).getResultList();
		System.out.println("This is the temp list" + temp);

		for (int i = 0; i < temp.size(); i++) {
			URL.add(temp.get(i).toString());
			System.out.println("This is the URL List\n" + URL);
		}
	}

	/**
	 * This method calls every element in the playQueue and runs it through
	 * preparePlayQueueToBePlayed then starts the playQueue playing in the
	 * musicThread
	 */
	public void playPLayQueue() {

		for (int i = 0; i < playQueue.size(); i++) {

			preparePlayQueueToBePlayed(i);
		}

		// this will one make a new thread if there isnt one already
		if (!musicThread.isAlive()) {
			musicThread.start();
		}
	}

	/**
	 * This method calls every element in the playQueue and runs it through
	 * preparePlayQueueToBePlayed then starts the playQueue playing in the
	 * shuffleThread
	 */
	public void playRandomPLayQueue() {

		for (int i = 0; i < playQueue.size(); i++) {

			preparePlayQueueToBePlayed(i);
		}

		// this will one make a new thread if there isnt one already
		if (!shuffleThread.isAlive()) {
			shuffleThread.start();
		}
	}

	// GETTERS AND SETTERS

	public static List<Music> getPlayQueue() {
		return playQueue;
	}

	public static void setPlayQueue(List<Music> playQueue) {
		PlayQueueArray.playQueue = playQueue;
	}

}
