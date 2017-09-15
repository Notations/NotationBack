package com.notation.back.datawarehouse.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.notation.back.datawarehouse.repository.CategoryRepository;
import com.notation.back.datawarehouse.repository.CountryRepository;
import com.notation.back.datawarehouse.repository.IndicatorLabelRepository;
import com.notation.back.datawarehouse.repository.IndicatorsRepository;
import com.notation.back.datawarehouse.repository.TimeRepository;
import com.notation.back.datawarehouse.repository.dto.IndicatorsParametersWrapper;
import com.notation.back.exceptions.ErrorCode;
import com.notation.back.exceptions.ParameterNotFoundException;
import com.notation.back.utils.ParametersUtils;

/**
 * The Class IndicatorsRepositoryImpl.
 */
@Repository(value="indicatorsRepositoryImpl")
public class IndicatorsRepositoryImpl implements IndicatorsRepository{

	/** The indicators by parameters query. */
	@Value("${indicators.by.parameters}")
	private String indicatorsByParametersQuery;

	/** The time condition. */
	@Value("${time.parameter.condition}")
	private String timeCondition;

	/** The indicator condition. */
	@Value("${indicator.parameter.condition}")
	private String indicatorCondition;

	/** The category condition. */
	@Value("${category.parameter.condition}")
	private String categoryCondition;

	/** The country condition. */
	@Value("${country.parameter.condition}")
	private String countryCondition;

	/** The order by params. */
	@Value("${orderby.clause}")
	private String orderByParams;

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/** The Country repository. */
	@Autowired
	private CountryRepository countryRepository;

	/** The time repository. */
	@Autowired
	private TimeRepository timeRepository;

	/** The indicator label repository. */
	@Autowired
	private IndicatorLabelRepository indicatorLabelRepository;

	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;

	/* (non-Javadoc)
	 * @see com.notation.back.datawarehouse.repository.IndicatorsRepository#findIndicatorsByParameters(com.notation.back.datawarehouse.repository.dto.IndicatorsParametersWrapper)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findIndicatorsByParameters(final IndicatorsParametersWrapper indicatorsParametersWrapper) throws ParameterNotFoundException {

		final String query = this.indicatorsByParametersQuery;

		final StringBuilder sb = new StringBuilder();
		sb.append(query);

		if(!ParametersUtils.isNotEmpty(indicatorsParametersWrapper)) {
			return new ArrayList<>();
		}

		final String categoryName = indicatorsParametersWrapper.getCategoryname();
		if(StringUtils.isNotEmpty(categoryName)) {
			if(this.categoryRepository.findByCategoryName(categoryName) == null) {
				throw new ParameterNotFoundException(ErrorCode.PARAMETER_NOT_FOUND, String.format("No category found with name %s", categoryName));
			}
			sb.append(String.format(this.categoryCondition, indicatorsParametersWrapper.getCategoryname()));
		}

		final String indicatorLabel = indicatorsParametersWrapper.getIndicatorName();
		if(StringUtils.isNotEmpty(indicatorLabel)) {
			if(this.indicatorLabelRepository.findByIndicatorName(indicatorLabel) == null) {
				throw new ParameterNotFoundException(ErrorCode.PARAMETER_NOT_FOUND, String.format("No indicator found with name %s", indicatorLabel));
			}
			sb.append(String.format(this.indicatorCondition, indicatorsParametersWrapper.getIndicatorName()));
		}

		final String countryName = indicatorsParametersWrapper.getCountryname();
		if(StringUtils.isNotEmpty(countryName)) {
			if(this.countryRepository.findByCountryName(countryName) == null) {
				throw new ParameterNotFoundException(ErrorCode.PARAMETER_NOT_FOUND, String.format("No country found with name %s", countryName));
			}
			sb.append(String.format(this.countryCondition, indicatorsParametersWrapper.getCountryname()));
		}

		final int year = indicatorsParametersWrapper.getYear();
		if(year != 0) {
			if(this.timeRepository.findByYear(year) == null) {
				throw new ParameterNotFoundException(ErrorCode.PARAMETER_NOT_FOUND, String.format("No year found with value %i", year));
			}
			sb.append(this.timeCondition+indicatorsParametersWrapper.getYear());
		}

		sb.append(this.orderByParams);

		final Query queryIndicatorsByParameters = this.entityManager.createQuery(sb.toString());
		final List<Object[]> results = queryIndicatorsByParameters.getResultList();
		return results;
	}
}
