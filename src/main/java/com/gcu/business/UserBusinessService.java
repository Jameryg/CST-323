package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

@Service
public class UserBusinessService implements UserDetailsService
{
	/**
	 * Declare the class scope method variable.
	 * Names 'service' that is autowired.
	 */
	@Autowired
	private UsersDataService service;
	
	/**
	 * This method is overridden from the base class and is used to support 
	 * Spring Security user Authentication.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// Try to find the username in the database. If the username is not found then
		// we are going to throw a 'UsernameNotFoundExpection' else return a
		// Spring Security User.
		UserEntity user = service.findByUsername(username);
		
		if (user != null)
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("Username not found!!");
		}
	}
}
