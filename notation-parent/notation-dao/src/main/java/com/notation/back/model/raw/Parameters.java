package com.notation.back.model.raw;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Parameters.
 */
@Entity
public class Parameters implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6560500017746532663L;

	/** The id. */
	@Id
	private int id;



	/**
	 * Instantiates a new parameters.
	 *
	 * @param id the id
	 */
	public Parameters(final int id) {
		super();
		this.id = id;
	}



	/**
	 * Instantiates a new parameters.
	 */
	public Parameters() {

	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return Parameters.serialVersionUID;
	}



}
