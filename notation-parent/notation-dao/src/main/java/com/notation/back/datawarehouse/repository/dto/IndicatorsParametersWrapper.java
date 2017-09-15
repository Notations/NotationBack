package com.notation.back.datawarehouse.repository.dto;

/**
 * The Class IndicatorsParametersWrapper.
 */
public class IndicatorsParametersWrapper {

	/** The countryname. */
	private String countryname;

	/** The categoryname. */
	private String categoryname;

	/** The year. */
	private int year;

	/** The indicator name. */
	private String indicatorName;

	/**
	 * Instantiates a new indicators parameters wrapper.
	 */
	public IndicatorsParametersWrapper() {
		super();
	}

	/**
	 * Instantiates a new indicators parameters wrapper.
	 *
	 * @param countryname the countryname
	 * @param categoryname the categoryname
	 * @param year the year
	 * @param indicatorName the indicator name
	 */
	public IndicatorsParametersWrapper(final String countryname, final String categoryname, final int year, final String indicatorName) {
		super();
		this.countryname = countryname;
		this.categoryname = categoryname;
		this.year = year;
		this.indicatorName = indicatorName;
	}

	/**
	 * Gets the countryname.
	 *
	 * @return the countryname
	 */
	public String getCountryname() {
		return this.countryname;
	}

	/**
	 * Sets the countryname.
	 *
	 * @param countryname the new countryname
	 */
	public void setCountryname(final String countryname) {
		this.countryname = countryname;
	}

	/**
	 * Gets the categoryname.
	 *
	 * @return the categoryname
	 */
	public String getCategoryname() {
		return this.categoryname;
	}

	/**
	 * Sets the categoryname.
	 *
	 * @param categoryname the new categoryname
	 */
	public void setCategoryname(final String categoryname) {
		this.categoryname = categoryname;
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
