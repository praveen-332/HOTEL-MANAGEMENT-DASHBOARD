package com.telusko.demo;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Bill;
import com.telusko.service.BillService;

@RestController

@RequestMapping(value="/Bill")
public class BillController {


	@Autowired
	BillService BillService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Bill/Bill_page");
	  
	  List list = BillService.listAllBills();
	  model.addObject("listBill", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Bill/Bill_form");
	  
	  Bill Bill = new Bill();
	  model.addObject("BillForm", Bill);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{billid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("billid") int billid){
	  ModelAndView model = new ModelAndView("Bill/Bill_form");
	  
	  Bill Bill = BillService.findBillById(billid);
	  model.addObject("BillForm", Bill);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("BillForm") Bill Bill){
	  if(Bill != null && Bill.getBillid() != null){
		  BillService.updateBill(Bill);
	  } else {
		  BillService.addBill(Bill);
	  }
	  
	  return new ModelAndView("redirect:/Bill/list");
	 }
	 
	 @RequestMapping(value="/delete/{billid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("billid") int billid){
		 BillService.deleteBill(billid);
	  
	  return new ModelAndView("redirect:/Bill/list");
	 }
}
