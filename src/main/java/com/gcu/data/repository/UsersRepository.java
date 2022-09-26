package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserEntity;

/*
 * Associate the Spring repository with the UserEntity class, the user variable will be a String.
 */
public interface UsersRepository extends CrudRepository<UserEntity, String>
{
	// Find a user in the database during authentication.
	UserEntity findByUsername(String username);
}
