package com.notation.back.model.datawarehouse;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Indicator.
 */
@Entity
public class IndicatorLabel implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7138088326679131375L;

	/** The indicator id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int indicatorLabelId;

	/** The indicator name. */
	@Column
	private String indicatorName;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "indicatorLabelId")
	private Collection<Indicators> indicators;

	@ManyToOne
	@JoinColumn(name = "categoryId", updatable = false, insertable = false)
	private Category category;

	/**
	 * Instantiates a new indicator.
	 */
	public IndicatorLabel() {
		super();
	}

	/**
	 * Instantiates a new indicator.
	 *
	 * @param indicatorId the indicator id
	 * @param indicatorName the indicator name
	 */
	public IndicatorLabel(final int indicatorLabelId, final String indicatorName) {
		super();
		this.indicatorLabelId = indicatorLabelId;
		this.indicatorName = indicatorName;
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

	public Collection<Indicators> getIndicators() {
		return this.indicators;
	}

	public void setIndicators(final Collection<Indicators> indicators) {
		this.indicators = indicators;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return IndicatorLabel.serialVersionUID;
	}

}
