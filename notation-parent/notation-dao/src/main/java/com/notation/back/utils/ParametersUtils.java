package com.notation.back.utils;

import org.apache.commons.lang3.StringUtils;

import com.notation.back.datawarehouse.repository.dto.IndicatorsParametersWrapper;


public class ParametersUtils {

	private ParametersUtils() {

	}

	public static boolean isNotEmpty(final IndicatorsParametersWrapper indicatorsParametersWrapper) {
		boolean isNotEmpty = false;
		if(StringUtils.isNotEmpty(indicatorsParametersWrapper.getCategoryname())
				|| StringUtils.isNotEmpty(indicatorsParametersWrapper.getCountryname())
				|| StringUtils.isNotEmpty(indicatorsParametersWrapper.getIndicatorName())
				|| indicatorsParametersWrapper.getYear() != 0) {
			isNotEmpty = true;
		}
		return isNotEmpty;
	}
}
