package com.CustomerControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	    @Autowired
	    private CustomerService customerservice;
	    
	    //@RequestMapping("/list")
        @GetMapping("/list")
	    public String customerlist(Model themodel){
		
		List<Customer> theCustomers=customerservice.getCustomersfromService();
		
		themodel.addAttribute("CustomersAttributeName",theCustomers);
	
		return "list-customers";	
	 }
        @GetMapping("/showFormForAdd")
        public String showFormForAdd(Model theModel){
        	Customer cust=new Customer();
        	theModel.addAttribute("customerAttributeName",cust);
        	return "customer-form";
        }
        @PostMapping("/saveCustomer")
        public String saveCustomer(@ModelAttribute("customerAttributeName") Customer cust){
			 
        	customerservice.saveCustomer(cust);
        	return "redirect:/customer/list";
        }
        @GetMapping("/showFormForUpdate")
        public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel){
        	// get the customer details from database
        	Customer cust=customerservice.getCustomer(id);
        	theModel.addAttribute("customerAttributeName",cust);
        	return "customer-form";
        }
        @GetMapping("/delete")
        public String deleteCustomer(@RequestParam("customerId") int id){
        	
        	customerservice.deleteCustomer(id);
        	return "redirect:/customer/list";
        }
}
