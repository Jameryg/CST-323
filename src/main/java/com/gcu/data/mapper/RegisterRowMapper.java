package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gcu.data.entity.RegisterEntity;

public class RegisterRowMapper 
{
	   public RegisterEntity mapRow (ResultSet rs, int rowNumber) throws SQLException
	   {
		   // Return a new instance of RegisterEntity using getters to populate the parameterized constructor.
	       return new RegisterEntity(rs.getLong("user_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email_address"), rs.getString("phone_number"), rs.getString("username"), rs.getString("password"));
	   }
}
