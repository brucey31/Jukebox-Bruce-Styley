package com.netbuilder.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.netbuilder.DataAccess.Music;

/**
 * This class is a child of RandomPlayQueueArray which is a child of
 * PlayQueueArray because they can share the same list playQueue, the same
 * boolean stopRandomMode to stop shuffle playlists and calls the same methods
 * (playSongsFromQueue) that take different inputs
 * 
 * @author Bruce Pannaman
 * @version
 * 
 */
public class GenreRandomPlayQueueArray extends RandomPlayQueueArray {


	public List<Music> SetOfGenreShufflePlaylist(String genreSelection) {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		// the start of the conversation between java and database
		em.getTransaction().begin();

		// this query pull the entire Music Catalog into the list
		List<Music> list = em
				.createQuery("Select c from Music c where Genre LIKE:p",
						Music.class).setParameter("p", genreSelection)
				.getResultList();

		// this is how many rows are in the Music table of the database i.e. max
		// variable
		list.size();

		// this while loop will keep the method picking random playlists of
		// length of the Music Catalog going until it is stopped by the boolean
		// at the top

		while (stopRandomMode) {
			// for as many times as there are songs in the database
			for (int i = 0; i <= list.size(); i++) {

				// needs to pick a song from the list at random
				int randomSongId = (int) (Math.random() * ((list.size() - 1) + 1));
				// this line will add that track we chose at random to the
				// playQueue
				playQueue.add(list.get(randomSongId));
			}
			System.out.println("Below is the auto-selected shuffle playlist"
					+ playQueue);

			// this playListStarter makes sure that the method moves onto the
			// next track once it has finished the playSongsFromQueue method
			// It is a placeholder for playQueue created randomly above
			int playListStarter = 0;

			// this for loop will play each song until it is finished and then
			// play the next one
			for (int j = 0; j <= playQueue.size(); j++) {

				// this method isn't in this class but a parent class EXAMPLE OF
				// POLYMORPHISM
				playSongsFromQueue(playListStarter);
				// wait for the end of the song before replaying the for loop
				// and doing the next one
				try {
					Thread.sleep(playQueue.get(playListStarter).getLength());
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
				playListStarter++;
			}

		}
		return playQueue;
	}
}
