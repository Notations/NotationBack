package com.notation.back.repository.raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notation.back.model.raw.Parameters;

@Repository
public interface ParametersRepository extends JpaRepository<Parameters, Integer> {

}
