package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Supplier;
import com.telusko.service.SupplierService;

@RestController

@RequestMapping(value="/Supplier")
public class SupplierController {


	@Autowired
	SupplierService SupplierService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Supplier/Supplier_page");
	  
	  List list = SupplierService.listAllSuppliers();
	  model.addObject("listSupplier", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Supplier/Supplier_form");
	  
	  Supplier Supplier = new Supplier();
	  model.addObject("SupplierForm", Supplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{sid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("sid") int sid){
	  ModelAndView model = new ModelAndView("Supplier/Supplier_form");
	  
	  Supplier Supplier = SupplierService.findSupplierById(sid);
	  model.addObject("SupplierForm", Supplier);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("SupplierForm") Supplier Supplier){
	  if(Supplier != null && Supplier.getSid() != null){
		  SupplierService.updateSupplier(Supplier);
	  } else {
		  SupplierService.addSupplier(Supplier);
	  }
	  
	  return new ModelAndView("redirect:/Supplier/list");
	 }
	 
	 @RequestMapping(value="/delete/{sid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("sid") int sid){
		 SupplierService.deleteSupplier(sid);
	  
	  return new ModelAndView("redirect:/Supplier/list");
	 }
}
