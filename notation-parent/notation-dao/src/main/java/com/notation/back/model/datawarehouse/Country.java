package com.notation.back.model.datawarehouse;

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
 * The Class Country.
 */
@Entity
public class Country {

	/** The indicator id. */
	@Id
	private int countryId;

	/** The indicator name. */
	@Column
	private String countryName;

	/** The country code. */
	@Column
	private String countryCode;

	/** The indicators. */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "countryId")
	private Collection<Indicator> indicators;



	/**
	 * Instantiates a new country.
	 *
	 * @param countryId the country id
	 * @param countryName the country name
	 * @param indicators the indicators
	 */
	public Country(final int countryId, final String countryName, final Collection<Indicator> indicators) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.indicators = indicators;
	}



	/**
	 * Instantiates a new country.
	 */
	public Country() {
		super();
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
	 * Gets the indicators.
	 *
	 * @return the indicators
	 */
	public Collection<Indicator> getIndicators() {
		return this.indicators;
	}

	/**
	 * Sets the indicators.
	 *
	 * @param indicators the new indicators
	 */
	public void setIndicators(final Collection<Indicator> indicators) {
		this.indicators = indicators;
	}
}
