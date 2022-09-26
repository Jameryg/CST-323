package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gcu.data.entity.ProductsEntity;

public class ProductsRowMapper
{
	// Implementations must implement this method to map each row of data in the ResultSet.
	// This method should not call next() on the ResultSet, it is only supposed to map values 
	// of the current row only.
   public ProductsEntity mapRow (ResultSet rs, int rowNumber) throws SQLException
   {
	   // Return a new instance of OrderEntity using getters to populate the parameterized constructor.
       return new ProductsEntity(rs.getLong("product_id"), rs.getString("image"), rs.getFloat("length"), rs.getString("measurement_unit"), rs.getFloat("weight"), rs.getString("description"), rs.getLong("user_id"));
   }
}
