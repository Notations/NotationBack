package com.notation.back.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.notation.back.datawarehouse.dto.IndicatorsWrapper;
import com.notation.back.datawarehouse.repository.IndicatorsRepository;
import com.notation.back.datawarehouse.repository.dto.IndicatorsParametersWrapper;
import com.notation.back.exceptions.ParameterNotFoundException;
import com.notation.back.services.IndicatorsService;
import com.notation.back.services.mappers.IndicatorsMapper;

/**
 * The Class IndicatorsServiceImpl.
 */
@Service(value="indicatorsServiceImpl")
public class IndicatorsServiceImpl implements IndicatorsService {

	private final static Logger LOGGER = Logger.getLogger(IndicatorsServiceImpl.class);

	/** The indicators repository. */
	@Resource(name="indicatorsRepositoryImpl")
	private IndicatorsRepository indicatorsRepository;

	/* (non-Javadoc)
	 * @see com.notation.back.services.IndicatorsService#getIndicators()
	 */
	@Override
	public List<IndicatorsWrapper> getIndicatorsByParameters(final IndicatorsParametersWrapper indicatorsParametersWrapper) throws ParameterNotFoundException {
		final List<IndicatorsWrapper> indicatorsWrapper = new ArrayList<>();
		try {
			final List<Object[]> indicatorsPersistent = this.indicatorsRepository.findIndicatorsByParameters(indicatorsParametersWrapper);
			IndicatorsMapper.mapIndicatorsPersistentArrays(indicatorsPersistent, indicatorsWrapper);
		} catch (final ParameterNotFoundException e) {
			IndicatorsServiceImpl.LOGGER.error(e.getMessage(), e);
			throw e;
		}
		return indicatorsWrapper;
	}

}
