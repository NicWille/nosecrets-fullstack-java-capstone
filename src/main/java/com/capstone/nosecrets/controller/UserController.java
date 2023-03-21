package com.capstone.nosecrets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.nosecrets.dto.UserSecret;
import com.capstone.nosecrets.entity.User;
import com.capstone.nosecrets.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// need to inject our customer service
	@Autowired
	private UserService userService;

	

	@GetMapping("/secret")
	public String viewSecret() {
		return "secret";
	}

	@GetMapping("/login")
	public String viewLogin() {
		return "login";
	}

	@GetMapping("/register")
	public String viewRegister() {
		return "register";
	}
	
	@GetMapping("/index")
	public String viewindex() {
		return "index";
	}

	@GetMapping("/list")
	public String listUsers(Model theModel) {

		// get customers from the service
		List<User> theUsers = userService.getUsers();
			
		// add the customers to the model
		theModel.addAttribute("users", theUsers);
		
		return "index";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveCustomer(@ModelAttribute("user") User theUser) {
		
		// save the customer using our service
		userService.saveUser(theUser);	
		
		return "redirect:/user/list";
	}

	@PostMapping("/saveUserSecret/{id}")
	public String saveCustomer(@ModelAttribute("secret") UserSecret secret, @PathVariable("id") int theId) {
		
		// save the customer using our service
		userService.updateUser(theId, secret);
		return "redirect:/user/list";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") int theId, Model theModel) {
		
		// get the customer from our service
		User theUser = userService.getUser(theId);	
		System.out.println(theUser.toString());
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		
		// send over to our form		
		return "secret";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteCustomer(@PathVariable("id") int theId) {
		//path variable
		// delete the customer using our service
		userService.deleteUser(theId);	
		
		return "redirect:/user/list";
	}
}