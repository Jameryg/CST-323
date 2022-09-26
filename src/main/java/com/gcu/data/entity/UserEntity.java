package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/*
 * Define the Mamp database we are using. Set the database 
 * attributes to users.
 */
@Table("user")
public class UserEntity 
{
	// Define the Properties
	@Id
	Long user_id;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return user_id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
