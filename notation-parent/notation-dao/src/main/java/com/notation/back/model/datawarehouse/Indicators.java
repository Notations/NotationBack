package com.notation.back.model.datawarehouse;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Indicators.
 */
@Entity
public class Indicators implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2312924705781800770L;

	/** The indicator id. */
	@Id
	private int indicatorId;


	/**
	 *
	 * @param indicatorId
	 */
	public Indicators(final int indicatorId) {
		super();
		this.indicatorId = indicatorId;
	}


	/**
	 * Default constructor
	 */
	public Indicators() {

	}



	/**
	 * Gets the indicator id.
	 *
	 * @return the indicator id
	 */
	public int getIndicatorId() {
		return this.indicatorId;
	}

	/**
	 * Sets the indicator id.
	 *
	 * @param indicatorId the new indicator id
	 */
	public void setIndicatorId(final int indicatorId) {
		this.indicatorId = indicatorId;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return Indicators.serialVersionUID;
	}
}
