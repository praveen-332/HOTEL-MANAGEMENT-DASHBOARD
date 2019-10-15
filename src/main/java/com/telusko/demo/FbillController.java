package com.telusko.demo;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Fbill;
import com.telusko.service.BillService;
import com.telusko.service.FbillService;

@RestController

@RequestMapping(value="/Fbill")
public class FbillController {


	@Autowired
	FbillService FbillService;
	@Autowired
	BillService billSerivce;
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Fbill/Fbill_page");
	  
	  List list = FbillService.listAllFbills();
	  model.addObject("listFbill", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Fbill/Fbill_form");
	  
	  Fbill Fbill = new Fbill();
	  model.addObject("FbillForm", Fbill);
	  List list = billSerivce.lastBill();
	  model.addObject("lastBill",list);
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("Fbill/Fbill_form");
	  
	  Fbill Fbill = FbillService.findFbillById(id);
	  model.addObject("FbillForm", Fbill);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("FbillForm") Fbill Fbill){
	  if(Fbill != null && Fbill.getId() !=0){
		  FbillService.updateFbill(Fbill);
	  } else {
		  FbillService.addFbill(Fbill);
	  }
	  
	  return new ModelAndView("redirect:/Fbill/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		 FbillService.deleteFbill(id);
	  
	  return new ModelAndView("redirect:/Fbill/list");
	 }
}
