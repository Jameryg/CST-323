package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.RegisterBusinessServiceInterface;
import com.gcu.model.RegisterModel;

@Controller 
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	public RegisterBusinessServiceInterface registerService;
	
	/*
	 * Mapping for the register page
	 */
	@GetMapping("/")
	public String registrationPage(Model model)
	{
		// Display the register page
		model.addAttribute("title", "Are you truly ready to register?");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
	
	/*
	 * POST from the register button to confirm submission of registering a user
	 */
	@PostMapping("/registerSuccess")
	public String successfulRegister(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model)
	{	
		registerService.addUser(registerModel);
		model.addAttribute("title", "You have successfully registered!");
		
		return "registerSuccess";
	}
}
