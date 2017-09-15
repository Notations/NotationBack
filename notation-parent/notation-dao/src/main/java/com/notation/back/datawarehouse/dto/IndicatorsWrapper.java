package com.notation.back.datawarehouse.dto;

/**
 * The Class IndicatorsWrapper.
 */
public class IndicatorsWrapper {

	/** The country name. */
	private String countryName;

	/** The year. */
	private int year;

	/** The category name. */
	private String categoryName;

	/** The indicator name. */
	private String indicatorName;

	/** The indicator value. */
	private float indicatorValue;

	/**
	 * Instantiates a new indicators wrapper.
	 */
	public IndicatorsWrapper() {
		super();
	}

	/**
	 * Instantiates a new indicators wrapper.
	 *
	 * @param countryName the country name
	 * @param year the year
	 * @param categoryName the category name
	 * @param indicatorName the indicator name
	 * @param indicatorValue the indicator value
	 */
	public IndicatorsWrapper(final String countryName, final int year, final String categoryName, final String indicatorName,
			final float indicatorValue) {
		super();
		this.countryName = countryName;
		this.year = year;
		this.categoryName = categoryName;
		this.indicatorName = indicatorName;
		this.indicatorValue = indicatorValue;
	}

	/**
	 * Gets the country name.
	 *
	 * @return the country name
	 */
	public String getCountryName() {
		return this.countryName;
	}

	/**
	 * Sets the country name.
	 *
	 * @param countryName the new country name
	 */
	public void setCountryName(final String countryName) {
		this.countryName = countryName;
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
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return this.categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
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
	 * @param indicatorValue the new indicator value
	 */
	public void setIndicatorValue(final float indicatorValue) {
		this.indicatorValue = indicatorValue;
	}
}
