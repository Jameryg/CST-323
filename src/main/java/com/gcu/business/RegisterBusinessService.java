package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gcu.data.ProductsDataService;
import com.gcu.data.RegisterDataService;
import com.gcu.data.entity.ProductsEntity;
import com.gcu.data.entity.RegisterEntity;
import com.gcu.model.ProductsModel;
import com.gcu.model.RegisterModel;

public class RegisterBusinessService implements RegisterBusinessServiceInterface
{
	@Autowired
	RegisterDataService registerService;
	
	public RegisterBusinessService() 
	{
	}
	
	public List<RegisterModel> getUsers(){
		// create a list of users
		List<RegisterModel> users = new ArrayList<RegisterModel>();
		
		List<RegisterEntity> registerEntity = registerService.findAll();
		
		String encoded;
		
		// adds only the username and password to a list of LoginModels
		for (RegisterEntity entity : registerEntity) {
			encoded = new BCryptPasswordEncoder().encode(entity.getPassword());
			users.add(new RegisterModel(entity.getFirstname(), entity.getLastname(), entity.getEmailAddress(), entity.getPhoneNumber(), entity.getUsername(), encoded));
		}
		
		return users;
	}
	
	public void addUser(RegisterModel registerModel)
	{
		// Adds a product to the list
		registerService.create(new RegisterEntity(1L, registerModel.getFirstName(), registerModel.getLastName(), registerModel.getEmailAddress(), registerModel.getPhoneNumber(), registerModel.getUsername(), new BCryptPasswordEncoder().encode(registerModel.getPassword())));
	}
}
