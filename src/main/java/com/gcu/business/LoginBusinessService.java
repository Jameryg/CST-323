package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.RegisterDataService;
import com.gcu.data.entity.RegisterEntity;
import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

public class LoginBusinessService 
{	
	
	public LoginBusinessService() 
	{
	}
	
	public boolean checkLogin(List<RegisterModel> users, LoginModel user) {
		for (int i = 0; i < users.size(); i++) {
			if (user.getUsername().toLowerCase().trim().equals(users.get(i).getUsername().toLowerCase().trim()) 
					&& user.getPassword().toLowerCase().trim().equals(users.get(i).getPassword().toLowerCase().trim())) 
				return true;
		}
		return false;
	}
}
