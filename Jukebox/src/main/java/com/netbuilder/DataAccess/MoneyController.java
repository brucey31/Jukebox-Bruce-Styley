package com.netbuilder.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MoneyController {

	// here we have created a new entity manager that will persist our data
	public EntityManager em;

	public MoneyController(EntityManager em) {
		this.em = em;
	}

	/**
	 * This Method is used by method populateMoney in app class to persist the
	 * data created in the setMoney List
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
	
	public void persistPurchase(List<Money> list){
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
	
	/**
	 * This Variable is very important as it returns the total amount of money held in the jukebox and will be shown in the GUI
	 */
	static double totalMoney = 0 ;
	/**
	 * This method querys the database and sees how much money is in it and puts this total to totalMoney above
	 */
	public static void countMoney(){

		// You need a entity manager factory to make an entity manager which
		// persists stuff to the database

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MusicPU");
		System.out.println("Entity Manager Factory Created");
		EntityManager em = emf.createEntityManager();
		// the start of the conversation between java and database
		em.getTransaction().begin();

		List<Money> list = em.createQuery("select c from Money c", Money.class).getResultList();
		for (Money money: list){
		
		totalMoney = totalMoney+ money.getAmountAdded();
		}
		
		System.out.println(totalMoney);
		em.close();
	}

}
