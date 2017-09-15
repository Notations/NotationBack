package com.notation.back.datawarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notation.back.model.datawarehouse.Country;

/**
 * The Interface CountryRepository.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {


	/**
	 * Find by country name.
	 *
	 * @param countryName the country name
	 * @return the country
	 */
	Country findByCountryName(String countryName);

}
