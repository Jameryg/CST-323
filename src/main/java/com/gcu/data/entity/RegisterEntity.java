package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
public class RegisterEntity 
{
	@Id
	Long user_id;
	
	@Column("firstname")
	String firstname;
	
	@Column("lastname")	
	String lastname;
	
	@Column("email_address")
	String emailAddress;
	
	@Column("phone_number")
	String phoneNumber;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;

	/**
	 * Default Constructor
	 */
	public RegisterEntity()
	{
		
	}

	/**
	 * @param user_id
	 * @param firstname
	 * @param lastname
	 * @param emailAddress
	 * @param phoneNumber
	 * @param username
	 * @param password
	 */
	public RegisterEntity(Long user_id, String firstname, String lastname, String emailAddress, String phoneNumber,
			String username, String password)
	{
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the user_id
	 */
	public Long getUser_id() 
	{
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) 
	{
		this.user_id = user_id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() 
	{
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) 
	{
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) 
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
}
