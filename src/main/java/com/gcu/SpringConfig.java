package com.gcu;

import org.springframework.context.annotation.Bean;
//Preconceived imports
import org.springframework.context.annotation.Configuration;

import com.gcu.business.LoginBusinessService;
//Custom imports 
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.RegisterBusinessService;

@Configuration 
public class SpringConfig
{
	// Bean annotation is applied at the method level 
	@Bean(name="productsBusinessService")
	public ProductsBusinessServiceInterface getProductsBusiness()
	{
		// Returns defines which java class is invoked 
		// that implements the OrdersBusinessServiceInterface
		return new ProductsBusinessService();
	}
	
	@Bean(name="loginBusinessService")
	public LoginBusinessService getLoginBusiness()
	{
		return new LoginBusinessService();
	}
	
	@Bean(name="registerBusinessService")
	public RegisterBusinessService getRegisterBusiness()
	{
		return new RegisterBusinessService();
	}
}