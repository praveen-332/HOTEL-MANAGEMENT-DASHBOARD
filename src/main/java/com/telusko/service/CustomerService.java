package com.telusko.service;

import java.util.List;



import com.telusko.model.Customer;

public interface CustomerService {
public List<Customer> listAllCustomers();
	
	public void addCustomer(Customer Customer);
	
	public void updateCustomer(Customer Customer); 
	
	public void deleteCustomer(int cid);
	
	public Customer findCustomerById(int cid);


}
