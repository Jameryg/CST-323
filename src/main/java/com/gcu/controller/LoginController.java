package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.LoginBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.RegisterBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductsModel;
import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	/*
	 * Autowiring for all of the various beans that are being made throughout the program. 
	 * ProductsBusinessServiceInterface, LoginBusinessService, RegisterBusinessServiceInterface.
	 */
	@Autowired
	public ProductsBusinessServiceInterface productService;
	@Autowired
	public LoginBusinessService loginService;
	
	/*
	 * Basically the home of the whole application, just a simple "/".
	 * More accurately the login of the application.
	 */
	@GetMapping("/")
	public String display(Model model)
	{
		// Display login form view 
		model.addAttribute("title", "Now it is time to Login!");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	/*
	 * Mapping for the products page
	 */
	@GetMapping("/products")
	public String productsPage(Model model)
	{
		model.addAttribute("title", "Now enter in the product that you want to add!");
		model.addAttribute("productsModel", new ProductsModel());
		return "products";
	}	
	
	/*
	 * Mapping for the reviews page
	 */
	@GetMapping("/reviews")
	public String reviewsPage(Model model)
	{
		model.addAttribute("title", "This is where the reviews will be!");
		return "reviews";
	}
	
	/*
	 * Mapping for the personalProductPage
	 */
	@GetMapping("/personalProductPage")
	public String personalProductPage(Model model)
	{	
		model.addAttribute("title", "You have successfully seen your products!");
		model.addAttribute("empty", productService.getProducts().isEmpty());
		model.addAttribute("products", productService.getProducts());
		
		return "personalProductPage";
	}
	
	/*
	 * All the POST mapping is below, all of the GET mapping is above.
	 */
	/*@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{	
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		if (loginService.checkLogin(registerService.getUsers(), loginModel)) 
		{
			model.addAttribute("title", "Login Success! Welcome in!");
			return "loginSuccess";
		}
		else 
		{
			model.addAttribute("title", "Login Failed! Now leave!");
			return "loginFailed";	
		}
	}*/
	
	/*
	 * POST from the update button to confirm updating a product 
	 */
	@PostMapping("/updateProduct")
	public String updateProduct(ProductsModel productsModel, Model model)
	{
		model.addAttribute("title", "You are attempting to edit a product");
		model.addAttribute("product", productsModel);
		model.addAttribute("productsModel", new ProductsModel());
		return "updateProduct";
	}
	
	/*
	 * POST from the delete button to confirm deletion of a product.
	 */
	@PostMapping("/deleteProduct")
	public String deleteProduct(ProductsModel productsModel, Model model)
	{
		model.addAttribute("title", "You are attempting to delete a product");
		model.addAttribute("productsModel", productsModel);
		return "deleteProduct"; 
	}
	
	/*
	 * POST to be able to process the products that will allow for someone to see their very own products page
	 */
	@PostMapping("/processProduct")
	public String processProduct(@Valid ProductsModel productsModel, BindingResult bindingResult, Model model)
	{	
		if (bindingResult.hasErrors())
		{
			return "products";
		}
		
		productService.addProduct(productsModel);
		model.addAttribute("title", "You have successfully seen your products!");
		model.addAttribute("empty", productService.getProducts().isEmpty());
		model.addAttribute("products", productService.getProducts());
		
		return "personalProductPage";
	}
	
	/*
	 * POST that will be updating a product
	 */
	@PostMapping("/processUpdate")
    public String processUpdate(@Valid ProductsModel productsModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            return "products";
        }

        productService.updateProduct(productsModel);
        model.addAttribute("title", "You have successfully updated your product!");
        model.addAttribute("empty", productService.getProducts().isEmpty());
        model.addAttribute("products", productService.getProducts());

        return "personalProductPage";
    }
	
	/*
	 * POST that will be deleting a product
	 */
	@PostMapping("/processDelete")
    public String processDelete(ProductsModel productsModel, Model model)
    {
		System.out.println(productsModel.toString());
        productService.deleteProduct(productsModel);
        model.addAttribute("title", "You have successfully deleted your product!");
        model.addAttribute("empty", productService.getProducts().isEmpty());
        model.addAttribute("products", productService.getProducts());

        return "personalProductPage";
    }
}
