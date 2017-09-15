package com.notation.back.datawarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notation.back.model.datawarehouse.Category;

/**
 * The Interface CategoryRepository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


	/**
	 * Find by category name.
	 *
	 * @param categoryName the category name
	 * @return the category
	 */
	Category findByCategoryName(String categoryName);
}
