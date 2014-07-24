package com.netbuilder.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

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

}
