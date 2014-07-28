package com.netbuilder.DataAccess;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.netbuilder.Service.*;
import com.netbuilder.Presentation.*;

/**
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class JukeBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Good Morning Music Listeners!");
//startDatabase();
//populateMoney(30);
//		 populatePurchase();

		// MoneyController.countMoney();
		
//		 populateTestPlayQueue();
		
//
//		PlayQueueArray pq = new PlayQueueArray();
//
//		 MusicController.searchByArtist("ACDC");
//		pq.addMultipleToQueue(MusicController.searchByTitle("ThunderStruck"));
//		
//		MusicController.searchByTitle("Confessions (unreleased)");
//		pq.addMultipleToQueue(MusicController
//				.searchByTitle("Confessions (unreleased)"));
//		
//		pq.playEntirePlaylist();
		
		
//		RandomPlayQueueArray rpq = new RandomPlayQueueArray();
//		rpq.SetOffShufflePlaylist();

		ClientView cw = new ClientView();
		cw.SetupClient();
	
//		pq.playSongsFromQueue(0);
		// MusicController.searchByAlbum("Number Ones [UK]");
//		 MusicController.playByTitle("Beat It");
	}

	/**
	 * This method creates an Entity Manager (With persistence unit "MusicPU")
	 * through an Entity Manager Factory and then persists the Music List
	 * created in populateMusicCatalogue
	 */
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

	/**
	 * This Method populates an initial music List with data
	 * 
	 * @return
	 */
	public static List<Music> populateMusicCatalogue() {
		List<Music> music = new ArrayList<Music>();
		music.add(new Music("ThunderStruck",(long)292000, "ACDC", null,
				"Back in Black", 1980,
				"/Users/Brucee/Music/iTunes/iTunes Music/ACDC/Unknown Album/Thunderstruck.wav"));
		music.add(new Music(
				"Rat In Mi Kitchen",
				(long)419000,
				"UB40",
				null,
				"Houses",
				1976,
				"/Users/Brucee/Music/Brucee's ITunes/iTunes Media/Music/UB40/Unknown Album/Rat In Mi Kitchen.wav"));
		music.add(new Music(
				"Blood, Toil, Tears & Sweat",
				(long)310000,
				"Winston Churchill",
				null,
				"Churchill Motivational Speeches",
				1943,
				"/Users/Brucee/Music/iTunes/iTunes Music/Winston Churchill/Churchill Motivational Speeches/Blood, Toil, Tears & Sweat.wav"));
		music.add(new Music(
				"Beat It",
				(long)258000,
				"Michael Jackson",
				null,
				"Number Ones (UK)",
				1986,
				"/Users/Brucee/Music/iTunes/iTunes Music/Michael Jackson/Number Ones (UK)/Beat It.wav"));
		music.add(new Music(
				"Confessions (unreleased)",
				(long)261000,
				"City and Colour",
				"Dallas Green",
				"Live",
				2010,
				"/Users/Brucee/Music/iTunes/iTunes Music/City and Colour/Live/06 Confessions (unreleased).wav"));
		music.add(new Music(
				"Good Vibrations",
				(long)217000,
				"Beach Boys",
				null,
				"Best Beach Boys Album",
				1956,
				"/Users/Brucee/Music/iTunes/iTunes Music/Beach Boys/Best Beach Boys Album/Good Vibrations.wav"));

		return music;

	}

	/**
	 * This Method creates a Entity Manager from an Entity Manager factory then
	 * instantiates MoneyController Class to use method setMoney on it
	 * 
	 * This method is called when the user puts money into the jukebox and the
	 * database is updated accordingly
	 */
	public static void populateMoney(int moneyEntered) {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();

		// instantiates MoneyController
		MoneyController monc = new MoneyController(em);

		if (em != null) {
			System.out.println("Entity Manager created successfully");
		}

		List<Money> money = setMoney(moneyEntered);
		System.out.println("Money Populated");

		monc.persistNewMoney(money);
		em.close();

	}

	/**
	 * This method populates an arraylist of the money that the user has put
	 * into the jukebox so that it can be persisted by populateMoney
	 * 
	 * @return money
	 */
	public static List<Money> setMoney(int amountEntered) {
		List<Money> money = new ArrayList<Money>();
		money.add(new Money(amountEntered));
		return money;

	}

	/**
	 * This Method is called whenever the user makes a purchase and persists
	 * -25p to the Money table thus adjusting the total of the AmountAdded
	 * column to be the remaining balance.
	 */
	public static void populatePurchase() {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();

		// instantiates MoneyController
		MoneyController monc = new MoneyController(em);

		if (em != null) {
			System.out.println("Entity Manager created successfully");
		}

		List<Money> purchase = setPurchase();
		System.out.println("Money Populated");

		monc.persistNewMoney(purchase);
		em.close();
	}

	/**
	 * This Method creates a new Arraylist with the cost of a purchase (-25p) so
	 * that it can be persisted by populatePurchase
	 * 
	 * @return
	 */
	public static List<Money> setPurchase() {
		List<Money> purchase = new ArrayList<Money>();
		purchase.add(new Money(-25));
		return purchase;
	}

	/**
	 * This Method will create an entity manager through an entity manager
	 * factory. Then use persistPlayQueue to persist this playlist to the
	 * database
	 */
	public static void populateTestPlayQueue() {
		System.out.println("Creating Entity Manager");

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();

		// instantiates MoneyController
		playQueueController playQ = new playQueueController(em);

		if (em != null) {
			System.out.println("Entity Manager created successfully");
		}

		// I instantiated the music list below so that setTestPlaylist has
		// something
		// to reference to, however it exceptions telling me that Column
		// 'Music_idMusic' cannot be null. I am trying to persist a foreign key,
		// I think i might need another row in the table
		// OR I COULD JUST PRODUCE
		// A RANDOMER THAT PICKS A RANDOM NUMBER BETWEEN FIRST MUSICID AND THE
		// LAST THEN PLAYS IT

		List<Music> music = populateMusicCatalogue();
		System.out.println("Music Catalogue Populated");
		List<playQueue> playlist = setTestPlaylist(music);
		System.out.println("Playlist Populated");

		playQ.persistPlayQueue(playlist);
		em.close();
	}

	/**
	 * This method creates a test playlist to see if i can persist something to
	 * the playQueue table and should be commented out once I move onto the
	 * service layer
	 * 
	 * @return
	 */
	public static List<playQueue> setTestPlaylist(List<Music> music) {
		List<playQueue> testPlayList = new ArrayList<playQueue>();
		testPlayList.add(new playQueue(music.get(0)));
		return testPlayList;
	}
}
