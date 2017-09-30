package com.CustomerControllers;

import java.util.List;

public interface CustomerService {
	
	public List<Customer> getCustomersfromService();

	public void saveCustomer(Customer cust);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
