package com.netbuilder.DataAccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class is a POJO for the playQueue table within the database to keep
 * track of the playQueue
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * @Entity
 * @Table
 */

@Entity
@Table(name = "playQueue")
public class playQueue {

	@Id
	@Column(name = "idplayQueue")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idplayQueue;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Music_idMusic", referencedColumnName = "idMusic") })
	private Music ForeignKeys;

	/**
	 * This method is a blank constructor
	 */
	public playQueue() {

	}

	/**
	 * This method makes a copy of the class to be overwritten when its called
	 * 
	 * @param ForeignKeys
	 */
	public playQueue(Music ForeignKeys) {
		this.ForeignKeys = ForeignKeys;

	}

}
