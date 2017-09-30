package com.CustomerControllers;

import java.util.List;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer cust);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
