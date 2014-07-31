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
 * This class includes my main method as well as others used to initialize the
 * whole system
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * 
 */
public class JukeBox {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Good Morning Music Listeners!");

		// These are the methods needed for initializing the system
//		 startDatabase();
//		 populateMoney(100);

		// This is the method for calling up the GUI which everything else runs
		// off
		ClientView cw = new ClientView();
		cw.setupClient();

	}

	/**
	 * This method creates an Entity Manager (With persistence unit "MusicPU")
	 * through an Entity Manager Factory and then persists the Music List using
	 * MoneyController.persistMusicCatalog and created in populateMusicCatalogue
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
	 * This list is the initial music catalog to be persisted to the Database
	 * 
	 * @return
	 */
	public static List<Music> populateMusicCatalogue() {
		List<Music> music = new ArrayList<Music>();
		music.add(new Music("ThunderStruck", (long) 292000, "ACDC", null,
				"Back in Black", "Rock", 1980,
				"/Users/Brucee/Music/iTunes/iTunes Music/ACDC/Unknown Album/Thunderstruck.wav"));
		music.add(new Music(
				"Rat In Mi Kitchen",
				(long) 419000,
				"UB40",
				null,
				"Houses",
				"Reggae",
				1976,
				"/Users/Brucee/Music/Brucee's ITunes/iTunes Media/Music/UB40/Unknown Album/Rat In Mi Kitchen.wav"));
		music.add(new Music(
				"Blood, Toil, Tears & Sweat",
				(long) 310000,
				"Winston Churchill",
				null,
				"Churchill Motivational Speeches",
				"Speeches",
				1943,
				"/Users/Brucee/Music/iTunes/iTunes Music/Winston Churchill/Churchill Motivational Speeches/Blood, Toil, Tears & Sweat.wav"));
		music.add(new Music(
				"Beat It",
				(long) 258000,
				"Michael Jackson",
				null,
				"Number Ones (UK)",
				"Pop",
				1986,
				"/Users/Brucee/Music/iTunes/iTunes Music/Michael Jackson/Number Ones (UK)/Beat It.wav"));
		music.add(new Music(
				"Confessions (unreleased)",
				(long) 261000,
				"City and Colour",
				"Dallas Green",
				"Acoustic",
				"Live",
				2010,
				"/Users/Brucee/Music/iTunes/iTunes Music/City and Colour/Live/06 Confessions (unreleased).wav"));
		music.add(new Music(
				"Good Vibrations",
				(long) 217000,
				"Beach Boys",
				null,
				"Best Beach Boys Album",
				"Pop",
				1956,
				"/Users/Brucee/Music/iTunes/iTunes Music/Beach Boys/Best Beach Boys Album/Good Vibrations.wav"));

		return music;

	}

	/**
	 * This Method uses list setMoney to add money to the JukeBox. Enter the
	 * amount of money the user has paid into the parameters. 
	 * 
	 * Persistence is achieved using Money Controller.persistNewMoney
	 * 
	 * @param moneyEntered
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
	 * 
	 * Persistence is achieved using Money Controller.persistNewMoney
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
	 * that it can be persisted by populatePurchase to persist a purchase
	 * 
	 * @return
	 */
	public static List<Money> setPurchase() {
		List<Money> purchase = new ArrayList<Money>();
		purchase.add(new Money(-25));
		return purchase;
	}


}
