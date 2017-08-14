package com.notation.back.repository.datawarehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notation.back.model.datawarehouse.Indicators;

@Repository
public interface IndicatorsRepository extends JpaRepository<Indicators, Integer> {

}
