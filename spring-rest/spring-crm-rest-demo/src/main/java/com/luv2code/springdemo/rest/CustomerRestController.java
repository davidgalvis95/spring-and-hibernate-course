package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("The customer id not found: " + customerId);
		}
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//The id should not be passed in the body
		//Here we are sending an id of 0 due that we need it to be a new customer. So maybe if the id is passed there, this allow us to 
		//set this customer as a new customer
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		//Here it will be needed that tha id will be passed in the body
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/:customerId")
	public String deleteCustomer(@PathVariable int customerId){
		//Jackson will automatically convert that pojo to JSON we dont need to convert it
		//If the customer is not found in DB then it will be null, and jackson will return a blank space
		//if there is a null, so we need to add some exception to handle it
		//as well as adding the bad request exception handling
		
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("The customer id not found: " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer" + customerId;
	}

}
