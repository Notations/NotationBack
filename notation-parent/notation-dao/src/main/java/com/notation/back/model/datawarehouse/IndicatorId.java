package com.notation.back.model.datawarehouse;

import java.io.Serializable;

/**
 * The Class IndicatorId.
 */
public class IndicatorId implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7103931504764688792L;

	/** The indicator id. */
	private int indicatorId;

	/** The category id. */
	private int categoryId;

	/** The time id. */
	private int timeId;

	/** The country id. */
	private int countryId;

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
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public int getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(final int categoryId) {
		this.categoryId = categoryId;
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
		return IndicatorId.serialVersionUID;
	}
}
