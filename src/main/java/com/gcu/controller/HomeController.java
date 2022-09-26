package com.gcu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * A controller that will handle the initial home page of the website.
 * This will be the first page that the user will be subject to.
 */
@Controller 
public class HomeController 
{
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title", "My Home");
		return "home";
	}
}
