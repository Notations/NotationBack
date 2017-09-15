package com.notation.back.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.notation.back.datawarehouse.dto.IndicatorsWrapper;
import com.notation.back.datawarehouse.repository.dto.IndicatorsParametersWrapper;
import com.notation.back.exceptions.ParameterNotFoundException;

/**
 * The Class IndicatorsRestServices.
 */
@RestController
@RequestMapping(value="/indicators")
public class IndicatorsRestServices {

	private final static Logger LOGGER = Logger.getLogger(IndicatorsRestServices.class);

	@Autowired
	private IndicatorsService indicatorsService;

	@RequestMapping(value = "/IndicatorsByParameters", method = RequestMethod.POST)
	@ResponseBody
	public List<IndicatorsWrapper> getIndicatorsByParameters(@RequestBody final IndicatorsParametersWrapper indicatorsParametersWrapper) throws ParameterNotFoundException{
		List<IndicatorsWrapper> indicatorsByParameters = new ArrayList<>();
		try {
			indicatorsByParameters = this.indicatorsService.getIndicatorsByParameters(indicatorsParametersWrapper);
		} catch (final ParameterNotFoundException e) {
			IndicatorsRestServices.LOGGER.error(e.getMessage(), e);
			throw e;
		}
		return indicatorsByParameters;
	}


}
