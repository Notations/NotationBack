package com.notation.back.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notation.back.datawarehouse.dto.IndicatorsWrapper;
import com.notation.back.datawarehouse.repository.dto.IndicatorsParametersWrapper;
import com.notation.back.exceptions.ParameterNotFoundException;

/**
 * The Interface IndicatorsService.
 */
@Service(value="indicatorsService")
public interface IndicatorsService {



	/**
	 * Gets the indicators by parameters.
	 *
	 * @param indicatorsParametersWrapper the indicators parameters wrapper
	 * @return the indicators by parameters
	 * @throws ParameterNotFoundException
	 */
	List<IndicatorsWrapper> getIndicatorsByParameters(IndicatorsParametersWrapper indicatorsParametersWrapper) throws ParameterNotFoundException;

}
