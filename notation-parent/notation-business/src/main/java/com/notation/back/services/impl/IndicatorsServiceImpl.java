package com.notation.back.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notation.back.model.datawarehouse.Indicators;
import com.notation.back.repository.datawarehouse.IndicatorsRepository;
import com.notation.back.services.IndicatorsService;

/**
 * The Class IndicatorsServiceImpl.
 */
@Service
public class IndicatorsServiceImpl implements IndicatorsService {

	/** The indicators repository. */
	@Autowired
	private IndicatorsRepository indicatorsRepository;

	/* (non-Javadoc)
	 * @see com.notation.back.services.IndicatorsService#getIndicators()
	 */
	@Override
	public List<Indicators> getIndicators() {
		return this.indicatorsRepository.findAll();
	}

}
