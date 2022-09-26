package com.gcu.business;

import java.util.List;

import com.gcu.model.RegisterModel;

public interface RegisterBusinessServiceInterface 
{
	public List<RegisterModel> getUsers();
	public void addUser(RegisterModel registerModel);
}
