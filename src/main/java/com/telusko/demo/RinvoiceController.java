package com.telusko.demo;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Rinvoice;
import com.telusko.service.RinvoiceService;

@RestController

@RequestMapping(value="/Rinvoice")
public class RinvoiceController {


	@Autowired
	RinvoiceService RinvoiceService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Rinvoice/Rinvoice_page");
	  
	  List list = RinvoiceService.listAllRinvoices();
	  model.addObject("listRinvoice", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Rinvoice/Rinvoice_form");
	  
	  Rinvoice Rinvoice = new Rinvoice();
	  model.addObject("RinvoiceForm", Rinvoice);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{rrid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("rrid") int rrid){
	  ModelAndView model = new ModelAndView("Rinvoice/Rinvoice_form");
	  
	  Rinvoice Rinvoice = RinvoiceService.findRinvoiceById(rrid);
	  model.addObject("RinvoiceForm", Rinvoice);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("RinvoiceForm") Rinvoice Rinvoice){
	  if(Rinvoice != null && Rinvoice.getRrid() != null){
		  RinvoiceService.updateRinvoice(Rinvoice);
	  } else {
		  RinvoiceService.addRinvoice(Rinvoice);
	  }
	  
	  return new ModelAndView("redirect:/Rinvoice/list");
	 }
	 
	 @RequestMapping(value="/delete/{rrid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("rrid") int rrid){
		 RinvoiceService.deleteRinvoice(rrid);
	  
	  return new ModelAndView("redirect:/Rinvoice/list");
	 }
}
