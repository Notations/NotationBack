package com.notation.back.model.datawarehouse;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Time.
 */
@Entity
public class Time {

	/** The indicator id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timeId;

	/** The indicator name. */
	@Column
	private int year;

	/** The indicators. */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "timeId")
	private Collection<Indicators> indicators;

	/**
	 * Instantiates a new time.
	 *
	 * @param timeId the time id
	 * @param year the year
	 * @param indicators the indicators
	 */
	public Time(final int timeId, final int year, final Collection<Indicators> indicators) {
		super();
		this.timeId = timeId;
		this.year = year;
		this.indicators = indicators;
	}

	/**
	 * Instantiates a new time.
	 */
	public Time() {
		super();
	}

	/**
	 * Gets the time id.
	 *
	 * @return the time id
	 */
	public int getTimeId() {
		return this.timeId;
	}

	/**
	 * Sets the time id.
	 *
	 * @param timeId the new time id
	 */
	public void setTimeId(final int timeId) {
		this.timeId = timeId;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(final int year) {
		this.year = year;
	}

	/**
	 * Gets the indicators.
	 *
	 * @return the indicators
	 */
	public Collection<Indicators> getIndicators() {
		return this.indicators;
	}

	/**
	 * Sets the indicators.
	 *
	 * @param indicators the new indicators
	 */
	public void setIndicators(final Collection<Indicators> indicators) {
		this.indicators = indicators;
	}


}
