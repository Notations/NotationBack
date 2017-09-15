package com.notation.back.model.datawarehouse;

import java.io.Serializable;

/**
 * The Class IndicatorId.
 */
public class IndicatorsId implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7103931504764688792L;

	private int indicatorLabelId;

	/** The time id. */
	private int timeId;

	/** The country id. */
	private int countryId;

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
	 * @param countryId the new country id
	 */
	public void setCountryId(final int countryId) {
		this.countryId = countryId;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return IndicatorsId.serialVersionUID;
	}
}
