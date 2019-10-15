package com.telusko.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.CustomerDao;
import com.telusko.model.Customer;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {

	CustomerDao CustomerDao;
	@Autowired
	public void setUserdao(CustomerDao userdao) {
		this.CustomerDao = userdao;
	}
	@Override
	public List<Customer> listAllCustomers() {
		return CustomerDao.listAllCustomers();
	}

	@Override
	public void addCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		CustomerDao.addCustomer(Customer);
		
	}

	@Override
	public void updateCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		CustomerDao.updateCustomer(Customer);
	}

	@Override
	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		CustomerDao.deleteCustomer(cid);
		
	}

	@Override
	public Customer findCustomerById(int cid) {
		// TODO Auto-generated method stub
		return CustomerDao.findCustomerById(cid);
	}
	
}
