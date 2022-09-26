package com.gcu.data.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.RegisterEntity;

/*
 * Associate the Spring repository with the RegisterEntity class.
 */
public interface RegisterRepository extends CrudRepository<RegisterEntity, Long>
{
	/*
	 * Will call to the findAll method that has been created, selecting from 
	 * the tapemeasurehaven.user database table.
	 */
	@Override
	@Query(value = "SELECT * FROM tapemeasureheaven.user" )
	Iterable<RegisterEntity> findAll();
}
