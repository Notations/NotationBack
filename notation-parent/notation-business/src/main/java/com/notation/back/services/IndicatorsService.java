package com.notation.back.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notation.back.model.datawarehouse.Indicators;

/**
 * The Interface IndicatorsService.
 */
@Service
public interface IndicatorsService {

	/**
	 * Gets the indicators.
	 *
	 * @return the indicators
	 */
	List<Indicators> getIndicators();

}
