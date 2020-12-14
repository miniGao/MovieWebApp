package com.spring.webapp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerRepository customerRepo;
	
	@GetMapping("/listOfCustomers")
	public String customerHome(Model model) {
		model.addAttribute("customerList", customerRepo.findAll());
		return "listOfCustomers";
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Customer customer) {
		return "addCustomer";
	}
	
	@PostMapping("/createCustomer")
	public String createCustomer(@Valid Customer customer, BindingResult result, Model model) {
		if(result.hasErrors()) return "addCustomer";
		customerRepo.save(customer);
		model.addAttribute("customerList", customerRepo.findAll());
		return "listOfCustomers";
	}
	
	@GetMapping("/editCustomer/{id}")
	public String editCustomer(@PathVariable("id") int customerId, Model model) {
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + customerId));
		model.addAttribute("customer", customer);
		return "updateCustomer";
	}
	
	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int customerId, @Valid Customer customer, BindingResult result, Model model) {
		customer.setCustId(customerId);
		if(result.hasErrors()) return "updateCustomer";
		customerRepo.save(customer);
		model.addAttribute("customerList", customerRepo.findAll());
		return "listOfCustomers";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int customerId, Model model) {
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + customerId));
		customerRepo.delete(customer);
		model.addAttribute("customerList", customerRepo.findAll());
		return "listOfCustomers";
	}
}
