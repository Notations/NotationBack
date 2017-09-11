package com.notation.back.model.datawarehouse;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Indicator.
 */
@Entity
public class Indicator implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7138088326679131375L;

	/** The indicator id. */
	@Id
	private int indicatorId;

	/** The indicator name. */
	@Column
	private String indicatorName;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "indicatorId")
	private Collection<Indicator> indicators;

	/**
	 * Instantiates a new indicator.
	 */
	public Indicator() {
		super();
	}

	/**
	 * Instantiates a new indicator.
	 *
	 * @param indicatorId the indicator id
	 * @param indicatorName the indicator name
	 */
	public Indicator(final int indicatorId, final String indicatorName) {
		super();
		this.indicatorId = indicatorId;
		this.indicatorName = indicatorName;
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
	 * Gets the indicator name.
	 *
	 * @return the indicator name
	 */
	public String getIndicatorName() {
		return this.indicatorName;
	}

	/**
	 * Sets the indicator name.
	 *
	 * @param indicatorName the new indicator name
	 */
	public void setIndicatorName(final String indicatorName) {
		this.indicatorName = indicatorName;
	}

}
