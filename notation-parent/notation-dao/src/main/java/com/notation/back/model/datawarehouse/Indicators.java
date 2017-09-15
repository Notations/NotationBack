package com.notation.back.model.datawarehouse;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Indicators.
 */
@Entity
@IdClass(IndicatorsId.class)
public class Indicators implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2312924705781800770L;

	/** The indicator id. */
	@Id
	private int indicatorLabelId;

	/** The time id. */
	@Id
	private int timeId;

	/** The country id. */
	@Id
	private int countryId;

	/** The indicator value. */
	@Column
	private float indicatorValue;

	/** The indicator. */
	@ManyToOne
	@JoinColumn(name = "indicatorLabelId", updatable = false, insertable = false)
	private IndicatorLabel indicatorLabel;

	/** The time. */
	@ManyToOne
	@JoinColumn(name = "timeId", updatable = false, insertable = false)
	private Time time;

	/** The country. */
	@ManyToOne
	@JoinColumn(name = "countryId", updatable = false, insertable = false)
	private Country country;

	/**
	 * Instantiates a new indicators.
	 */
	public Indicators() {
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
	 * @param timeId
	 *            the new time id
	 */
	public void setTimeId(final int timeId) {
		this.timeId = timeId;
	}

	/**
	 * Gets the country id.
	 *
	 * @return the country id
	 */
	public int getCountryId() {
		return this.countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId
	 *            the new country id
	 */
	public void setCountryId(final int countryId) {
		this.countryId = countryId;
	}

	/**
	 * Gets the indicator value.
	 *
	 * @return the indicator value
	 */
	public float getIndicatorValue() {
		return this.indicatorValue;
	}

	/**
	 * Sets the indicator value.
	 *
	 * @param indicatorValue
	 *            the new indicator value
	 */
	public void setIndicatorValue(final float indicatorValue) {
		this.indicatorValue = indicatorValue;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Time getTime() {
		return this.time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time
	 *            the new time
	 */
	public void setTime(final Time time) {
		this.time = time;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public Country getCountry() {
		return this.country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country
	 *            the new country
	 */
	public void setCountry(final Country country) {
		this.country = country;
	}



	/**
	 * Gets the indicator id.
	 *
	 * @return the indicator id
	 */
	public int getIndicatorLabelId() {
		return this.indicatorLabelId;
	}

	/**
	 * Sets the indicator id.
	 *
	 * @param indicatorId the new indicator id
	 */
	public void setIndicatorLabelId(final int indicatorLabelId) {
		this.indicatorLabelId = indicatorLabelId;
	}

	/**
	 * Gets the indicator.
	 *
	 * @return the indicator
	 */
	public IndicatorLabel getIndicator() {
		return this.indicatorLabel;
	}

	/**
	 * Sets the indicator.
	 *
	 * @param indicator the new indicator
	 */
	public void setIndicator(final IndicatorLabel indicatorLabel) {
		this.indicatorLabel = indicatorLabel;
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
