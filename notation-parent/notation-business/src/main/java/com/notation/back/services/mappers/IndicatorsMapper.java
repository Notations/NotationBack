package com.notation.back.services.mappers;

import java.util.List;

import com.notation.back.datawarehouse.dto.IndicatorsWrapper;

/**
 * The Class IndicatorsMapper.
 */
public final class IndicatorsMapper {

	/**
	 * Instantiates a new indicators mapper.
	 */
	private IndicatorsMapper() {

	}

	/**
	 * Map indicators persistent arrays.
	 *
	 * @param indicators the indicators
	 * @param indicatorsWrappers the indicators wrappers
	 */
	public static void mapIndicatorsPersistentArrays(final List<Object[]> indicators, final List<IndicatorsWrapper> indicatorsWrappers) {
		indicators.stream().forEach(p -> {
			final IndicatorsWrapper indicatorsWrapper = new IndicatorsWrapper();
			indicatorsWrapper.setIndicatorValue((Float) p[0]);
			indicatorsWrapper.setIndicatorName((String) p[1]);
			indicatorsWrapper.setCategoryName((String) p[2]);
			indicatorsWrapper.setYear((Integer) p[3]);
			indicatorsWrapper.setCountryName((String) p[4]);
			indicatorsWrappers.add(indicatorsWrapper);
		});
	}

}
