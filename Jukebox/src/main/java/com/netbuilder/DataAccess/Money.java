package com.netbuilder.DataAccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This Method is a POJO for my Money table in the database that will keep track
 * of how much money has been deposited in the machine
 * 
 * @Entity
 * @Table
 * @author Bruce Pannaman
 * 
 */
@Entity
@Table(name = "Money")
public class Money {

	@Id
	@Column(name = "idMoney")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMoney;

	@Column(name = "AmountAdded")
	@NotNull
	private int AmountAdded;

	/**
	 * This is a blank Constructor
	 */
	public Money() {

	}

	public Money(int AmountAdded) {
		this.AmountAdded = AmountAdded;
	}

	
	//GETTERS AND SETTERS
	public int getIdMoney() {
		return idMoney;
	}

	public void setIdMoney(int idMoney) {
		this.idMoney = idMoney;
	}

	public int getAmountAdded() {
		return AmountAdded;
	}

	public void setAmountAdded(int amountAdded) {
		AmountAdded = amountAdded;
	}
}
