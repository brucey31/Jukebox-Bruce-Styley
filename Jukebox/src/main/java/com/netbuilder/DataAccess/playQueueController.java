package com.netbuilder.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Bruce Pannaman
 * @version 1.0
 *
 */
public class playQueueController {
	// here we have created a new entity manager that will persist our data
	private EntityManager em;

	/**
	 * An ourside getter for our entity manager
	 * @param em
	 */
	public playQueueController(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Once we have created a play queue this will persist it to the database
	 * @param list
	 */
	public void persistPlayQueue(List<playQueue> list) {
		System.out.println("Beginning persistance");
		em.getTransaction().begin();
		for (playQueue playQueue : list) {
			em.persist(playQueue);

		}
		em.getTransaction().commit();
		System.out.println("Finished Persistence");
	}

	
}
