package com.netbuilder.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This Class holds all the methods related to the Money table in the Database
 * and its role in the Data Access Layer
 * 
 * @author Bruce Pannaman
 * @version
 * 
 */
public class MoneyController {

	// here we have created a new entity manager that will persist our data
	public EntityManager em;

	public MoneyController(EntityManager em) {
		this.em = em;
	}

	/**
	 * This Method is used by method populateMoney in JukeBox class to persist
	 * the data created in the setMoney List
	 * 
	 * @param list
	 */
	public void persistNewMoney(List<Money> list) {
		try {

			System.out.println("Beginning persistance");
			em.getTransaction().begin();

			for (Money money : list) {
				em.persist(money);
				em.getTransaction().commit();
				System.out.println("Finished Persistence");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * This method persists a purchase to the database and isn't used as persist
//	 * new money does the same thing
//	 * 
//	 * @param list
//	 */
	// public void persistPurchase(List<Money> list) {
	// try {
	//
	// System.out.println("Beginning persistance");
	// em.getTransaction().begin();
	//
	// for (Money purchase : list) {
	// em.persist(purchase);
	// em.getTransaction().commit();
	// System.out.println("Finished Persistence");
	// em.close();
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * This Variable is very important as it returns the total amount of money
	 * held in the Jukebox and will be shown in the GUI
	 */
	static double totalMoney = 0;

	/**
	 * This method queries the database and sees how much money is in it and
	 * puts this total to totalMoney variable
	 * 
	 * @return
	 */
	public static double countMoney() {

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		// totalMoney needs to be reset at the beginning of each time this
		// method is called so that count money doesn't double itself the whole
		// time
		totalMoney = 0;
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		List<Money> list = em.createQuery("select c from Money c", Money.class)
				.getResultList();
		for (Money money : list) {

			totalMoney = totalMoney + money.getAmountAdded();
		}

		System.out.println(totalMoney);

		em.close();
		return totalMoney;
	}

}
