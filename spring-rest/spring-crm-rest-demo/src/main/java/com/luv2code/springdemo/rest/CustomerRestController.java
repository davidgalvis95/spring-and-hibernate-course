package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	//Add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//Add mapping for GET /customers
	@GetMapping("/customers/:customerId")
	public Customer getCustomer(@PathVariable int customerId){
		//Jackson will automatically convert that pojo to JSON we dont need to convert it
		//If the customer is not found in DB then it will be null, and jackson will return a blank space
		//if there is a null, so we need to add some exception to handle it
		//as well as adding the bad request exception handling
		return customerService.getCustomer(customerId);
	}

}
