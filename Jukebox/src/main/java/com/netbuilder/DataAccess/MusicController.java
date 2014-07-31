package com.netbuilder.DataAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * This class holds all the methods needed to deal with the music table in the
 * database that is to do with the data access layer
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class MusicController {

	// here we have created a new entity manager that will persist our data
	private EntityManager em;

	public MusicController(EntityManager em) {
		this.em = em;
	}

	/**
	 * this method will get the array list from our main method and persist it
	 * to the database then commit it
	 * 
	 * @param list
	 */
	public void persistMusicCatalogue(List<Music> list) {
		System.out.println("Beginning persistance");
		em.getTransaction().begin();
		for (Music music : list) {
			em.persist(music);

		}
		em.getTransaction().commit();
		System.out.println("Finished Persistence");
	}


	/**
	 * This method will find a song by Artist in the database and outputs the results to a list
	 * @param searchCriteria
	 */
	public static List<Music> searchByArtist(String searchCriteria) {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		List<Music> list = em
				.createQuery("select c from Music c where Artist LIKE:p",
						Music.class).setParameter("p", searchCriteria)
				.setMaxResults(6).getResultList();

		for (Music music : list) {
			System.out.println("\nWe Found Match(s)\n");
			System.out.println(music.toString());
		}
		return (List<Music>) list;
	}

	
	/**
	 * This method will find a song by Album in the database and outputs the results to a list
	 * @param searchCriteria
	 */
	public static List<Music> searchByAlbum(String searchCriteria) {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		List<Music> list = em
				.createQuery("select c from Music c where Album LIKE:p",
						Music.class).setParameter("p", searchCriteria)
				.setMaxResults(6).getResultList();

		for (Music music : list) {
			System.out.println("\nWe Found Match(s)\n");
			System.out.println(music.toString());

		}

		return (List<Music>) list;
	}


	/**
	 * This method will find a song by Song Title in the database and outputs the results to a list
	 * @param searchCriteria
	 */
	public static List<Music> searchByTitle(String searchCriteria) {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		List<Music> list = em
				.createQuery("select c from Music c where Title LIKE:p",
						Music.class).setParameter("p", searchCriteria)
				.setMaxResults(6).getResultList();

		for (Music music : list) {
			System.out.println("\nWe Found Match(s)\n");
			System.out.println(music.toString());

		}

		if (Music.class.toString().equals(null)) {
			System.out.println("I'm Sorry I found no such songs");
		}

		return list;

	}


	/**
	 * This method will play a song by giving it a title name
	 * @param Title
	 * @SuppressWarnings("restriction")
	 * @exception (IO Exception) based on local computer file path
	 */

	public static void playByTitle(String Title) {

		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		List<String> URL = em
				.createQuery(
						"select c.file_Path from Music c where Title LIKE:p")
				.setParameter("p", Title).setMaxResults(6).getResultList();

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
