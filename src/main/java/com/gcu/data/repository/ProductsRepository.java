package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductsEntity;

/*
 * Associate the Spring repository with the ProductsEntity class.
 */
public interface ProductsRepository extends CrudRepository<ProductsEntity, Long>
{
	/*
	 * Will call to the findAll method that has been created, selecting from 
	 * the tapemeasurehaven.products database table.
	 */
	@Override
	@Query(value = "SELECT * FROM tapemeasureheaven.product" )
	public List<ProductsEntity> findAll();
}