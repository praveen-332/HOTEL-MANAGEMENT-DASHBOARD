package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Customer;
import com.telusko.service.CustomerService;

@RestController

@RequestMapping(value="/Customer")
public class CustomerController {


	@Autowired
	CustomerService CustomerService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Customer/Customer_page");
	  
	  List list = CustomerService.listAllCustomers();
	  model.addObject("listCustomer", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Customer/Customer_form");
	  
	  Customer Customer = new Customer();
	  model.addObject("CustomerForm", Customer);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{cid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("cid") int cid){
	  ModelAndView model = new ModelAndView("Customer/Customer_form");
	  
	  Customer Customer = CustomerService.findCustomerById(cid);
	  model.addObject("CustomerForm", Customer);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("CustomerForm") Customer Customer){
	  if(Customer != null && Customer.getCid() != null){
		  CustomerService.updateCustomer(Customer);
	  } else {
		  CustomerService.addCustomer(Customer);
	  }
	  
	  return new ModelAndView("redirect:/Customer/list");
	 }
	 
	 @RequestMapping(value="/delete/{cid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("cid") int cid){
		 CustomerService.deleteCustomer(cid);
	  
	  return new ModelAndView("redirect:/Customer/list");
	 }
}
