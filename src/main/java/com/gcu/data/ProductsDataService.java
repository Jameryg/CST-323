package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductsEntity;
import com.gcu.data.repository.ProductsRepository;

@Service
public class ProductsDataService implements DataAccessInterface<ProductsEntity>
{
	@Autowired
	private ProductsRepository productsRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for constructor injection.
	 */
	public ProductsDataService(ProductsRepository productsRepository, DataSource dataSource)
	{
		this.productsRepository = productsRepository;
	    this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	* CRUD: finder to return a single entity
	*/
	public ProductsEntity findById(int id)
	{
		return null;
	}
	
	/**
	 * CRUD: finder to return all entities
	 */
	public List<ProductsEntity> findAll()
	{
	    List<ProductsEntity> products = new ArrayList<ProductsEntity>();
	    try
	    {
	    	// Get all all the Entity Products
	        Iterable<ProductsEntity> productsIterable = productsRepository.findAll();
	        // Convert to a List and return the List
	        products = new ArrayList<ProductsEntity>();
	        productsIterable.forEach(products::add);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    // Return the List
	    return products;
	}
	
	/**
	 * CRUD: create an entity
	 */
	public boolean create(ProductsEntity products)
	{
		String sql = "INSERT INTO product (image, length, measurement_unit, weight, description, user_id) VALUES (?, ?, ?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql, products.getImage(), products.getLength(), products.getMeasuremeantUnit(), products.getWeight(), products.getDescription(), 1L);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

	public boolean update(ProductsEntity products) 
	{
		String sql = "UPDATE product SET image = ?, length = ?, measurement_unit = ?, weight = ?, description = ? WHERE product_id = ?";
		try
		{
			// Execute SQL Update
			jdbcTemplateObject.update(sql, products.getImage(), products.getLength(), products.getMeasuremeantUnit(), products.getWeight(), products.getDescription(), products.getProduct_id());
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

	/**
	 * CRUD: delete an entity
	 */
	public boolean delete(ProductsEntity products) 
	{
		String sql = "DELETE FROM product WHERE product_id = ?";
		try
		{
			// Execute SQL Delete
			jdbcTemplateObject.update(sql, products.getProduct_id());
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
}
