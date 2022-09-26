package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductsEntity;
import com.gcu.data.entity.RegisterEntity;
import com.gcu.data.repository.ProductsRepository;
import com.gcu.data.repository.RegisterRepository;

@Service
public class RegisterDataService implements DataAccessInterface<RegisterEntity>
{
	@Autowired
	private RegisterRepository registerRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for constructor injection.
	 */
	public RegisterDataService(RegisterRepository registerRepository, DataSource dataSource)
	{
		this.registerRepository = registerRepository;
	    this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	* CRUD: finder to return a single entity
	*/
	public RegisterEntity findById(int id)
	{
		return null;
	}
	
	/**
	 * CRUD: finder to return all entities
	 */
	public List<RegisterEntity> findAll()
	{
	    List<RegisterEntity> users = new ArrayList<RegisterEntity>();
	    try
	    {
	    	// Get all all the Entity Register
	        Iterable<RegisterEntity> registerIterable = registerRepository.findAll();
	        // Convert to a List and return the List
	        users = new ArrayList<RegisterEntity>();
	        registerIterable.forEach(users::add);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    // Return the List
	    return users;
	}
	
	/**
	 * CRUD: create an entity
	 */
	public boolean create(RegisterEntity users)
	{
		String sql = "INSERT INTO user (firstname, lastname, email_address, phone_number, username, password) VALUES (?, ?, ?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql, users.getFirstname(), users.getLastname(), users.getEmailAddress(), users.getPhoneNumber(), users.getUsername(), users.getPassword());
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

	public boolean update(RegisterEntity t) 
	{
		return true;
	}

	public boolean delete(RegisterEntity t) 
	{
		return true;
	}
}
