package com.notation.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.notation.back.model.datawarehouse.Indicators;

/**
 * The Class IndicatorsRestServices.
 */
@RestController
@RequestMapping(value="/indicators")
public class IndicatorsRestServices {

	@Autowired
	private IndicatorsService indicatorsService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Indicators> getAllIndicators(){
		return this.indicatorsService.getIndicators();
	}


}
