package com.netbuilder.Jukebox;

import java.util.List;

import javax.persistence.EntityManager;

public class MusicController {

	// here we have created a new entity manager that will persist our data
	private EntityManager em;

	public MusicController(EntityManager em) {
		this.em = em;
	}

	// this method will get the array list from our main method and persist it
	// to the database then commit it
	public void persistMusicCatalogue(List<Music> list) {
		System.out.println("Beginning persistance");
		em.getTransaction().begin();
		for (Music music : list) {
			em.persist(music);

		}
		em.getTransaction().commit();
		System.out.println("Finished Persistence");
	}

	//this method will pick the first song in the database
	public void playRandomSong(){
		
	}
}
