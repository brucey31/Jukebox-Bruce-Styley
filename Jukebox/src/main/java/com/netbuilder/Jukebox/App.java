package com.netbuilder.Jukebox;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class App {
	public static void main(String[] args) {
		System.out.println("Good Morning Music Listeners!");
		startDatabase();
	}

	public static void startDatabase() {

		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();

		// This instantiates the service classes that persist and list your
		// lists

		MusicController mc = new MusicController(em);

		// Checks the entity manager creates successfully

		if (em != null) {
			System.out.println("Entity Manager created successfully");
		}

		List<Music> music = populateMusicCatalogue();
		System.out.println("Music Catalogue Populated");
		mc.persistMusicCatalogue(music);
		em.close();

	}

	public static List<Music> populateMusicCatalogue() {
		List<Music> music = new ArrayList<Music>();
		music.add(new Music("ThunderStruck","04:52","ACDC",null,"Back in Black", 1980,"/Users/Brucee/Music/iTunes/iTunes Music/ACDC/Unknown Album/Thunderstruck.mp3"));
		music.add(new Music("Rat In Mi Kitchen","06:59","UB40",null,"Houses", 1976,"/Users/Brucee/Music/Brucee's ITunes/iTunes Media/Music/UB40/Unknown Album/Rat In Mi Kitchen.mp3"));
		music.add(new Music("Blood, Toil, Tears & Sweat","05:10","Winston Churchill",null,"Churchill Motivational Speeches", 1943,"/Users/Brucee/Music/iTunes/iTunes Music/Winston Churchill/Churchill Motivational Speeches/Blood, Toil, Tears & Sweat.mp3"));
		music.add(new Music("Beat It","04:18","Michael Jackson",null,"Number Ones [UK]", 1986,"/Users/Brucee/Music/iTunes/iTunes Music/Michael Jackson/Number Ones [UK]/04 Beat It.m4a"));
		music.add(new Music("Confessions (unreleased)","04:21","City and Colour",null,"Live", 2010,"/Users/Brucee/Music/iTunes/iTunes Music/City and Colour/Live/06 Confessions (unreleased).mp3"));
		music.add(new Music("Good Vibrations","03:37","Beach Boys",null,"Best Beach Boys Album", 1956,"/Users/Brucee/Music/iTunes/iTunes Music/Beach Boys/Best Beach Boys Album/Good Vibrations.mp3"));
		
		
		return music;

	}
}
