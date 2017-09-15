package com.notation.back.datawarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notation.back.model.datawarehouse.Time;

/**
 * The Interface TimeRepository.
 */
@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

	/**
	 * Find by year.
	 *
	 * @param year the year
	 * @return the time
	 */
	Time findByYear(int year);

}
