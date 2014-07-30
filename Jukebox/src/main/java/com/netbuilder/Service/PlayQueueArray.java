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
	 * This ArrayList is protected so that it can be used in subsequent
	 * children... Go PolyMorphism!!
	 */
	protected static List<Music> playQueue = new ArrayList<Music>();

	/**
	 * this list is used in the separate thread to play songs
	 */
	protected static List<String> URL = new ArrayList<String>();;

	/**
	 * This instantiates a new Thread Called "one" which plays plays the playqueue
	 */
	public static Thread musicThread = new Thread(new PlaySongsFromQueue());

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
	 * This method takes the trackcount of where playPlayQueue in in its loop
	 * and adds the URL of each element of the playqueue and writes it to
	 * another list called URL that is called in the separate thread
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

		//
		// for (String string : URL) {
		//
		// System.out
		// .println(URL.toString().replace("[", "").replace("]", ""));
		//
		// soundFile = URL.toString().replace("[", "")
		// .replace("]", "");



		// try {
		// InputStream in = new FileInputStream(soundFile);
		// AudioStream audioStream = new AudioStream(in);
		// AudioPlayer.player.start(audioStream);
		//
		// } catch (FileNotFoundException e) {
		//
		// e.printStackTrace();
		//
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }
	}

	/**
	 * This method calls the takes every element in the playqueue and runs it
	 * through
	 */
	public void playPLayQueue() {

		for (int i = 0; i < playQueue.size(); i++) {

			preparePlayQueueToBePlayed(i);
		}

		// this will one make a new thread if there isnt one already
		if (!musicThread.isAlive()) {
			musicThread.start();
		}

		// while (!one.isAlive()) {

		// wait for the end of the song before replaying the for loop
		// and
		// doing the next one
		// try {
		// Thread.sleep(playQueue.get(i).getLength());
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		//
		// }

	}

}
