package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

/* 
 * Going to be a class the implements both interfaces specifying a generic type of UserEntity.
 * Implements --> Inheriting the abstract methods (interfaces) 
 */
@Service
public class UsersDataService implements UsersDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity>
{
	// Class scope method variable named 'usersRepository'.
	// Autowired using constructor injection. Object's constructor is used
	// to inject dependencies. Safer because objects won't get created 
	// if the dependencies are not available. 
	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * CRUD: Finder to return an entity by username.
	 */
	public UserEntity findByUsername(String username)
	{
		// Uses spring repository to query the username
		return usersRepository.findByUsername(username);
	}

	public List<UserEntity> findAll() 
	{
		return null;
	}

	public UserEntity findById(String id)
	{
		return null;
	}

	public boolean create(UserEntity t) 
	{
		return false;
	}

	public boolean update(UserEntity t) 
	{
		return false;
	}

	public boolean delete(UserEntity t) 
	{
		return false;
	}

	@Override
	public UserEntity findById(int id) 
	{
		return null;
	}
}
