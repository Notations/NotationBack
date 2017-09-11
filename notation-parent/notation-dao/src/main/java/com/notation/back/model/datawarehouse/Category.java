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
 * The Class Category.
 */
@Entity
public class Category {
	/** The indicator id. */
	@Id
	private int categoryId;

	/** The indicator name. */
	@Column
	private String categoryName;

	/** The indicators. */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "indicatorId")
	private Collection<Indicator> indicators;



	public Category(final int categoryId, final String categoryName, final Collection<Indicator> indicators) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.indicators = indicators;
	}

	public Category() {
		super();
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
