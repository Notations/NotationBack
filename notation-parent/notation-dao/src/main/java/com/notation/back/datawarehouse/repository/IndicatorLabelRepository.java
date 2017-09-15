package com.notation.back.datawarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notation.back.model.datawarehouse.IndicatorLabel;

/**
 * The Interface IndicatorLabelRepository.
 */
@Repository
public interface IndicatorLabelRepository extends JpaRepository<IndicatorLabel, Integer> {

	/**
	 * Find by indicator name.
	 *
	 * @param indicatorLabelName the indicator label name
	 * @return the indicator label
	 */
	IndicatorLabel findByIndicatorName(String indicatorLabelName);

}
