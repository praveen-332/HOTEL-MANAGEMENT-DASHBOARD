package com.telusko.demo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Htax;
import com.telusko.service.HtaxService;

@RestController

@RequestMapping(value="/Htax")
public class HtaxController {


	@Autowired
	HtaxService HtaxService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Htax/Htax_page");
	  
	  List list = HtaxService.listAllHtaxs();
	  model.addObject("listHtax", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Htax/Htax_form");
	  
	  Htax Htax = new Htax();
	  model.addObject("HtaxForm", Htax);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{returnid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("returnid") int returnid){
	  ModelAndView model = new ModelAndView("Htax/Htax_form");
	  
	  Htax Htax = HtaxService.findHtaxById(returnid);
	  model.addObject("HtaxForm", Htax);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("HtaxForm") Htax Htax){
		// && Htax.getreturnid() != null
	  if(Htax != null && Htax.getReturnid()!=null ){
		  HtaxService.updateHtax(Htax);
	  } else {
		  HtaxService.addHtax(Htax);
	  }
	  
	  return new ModelAndView("redirect:/Htax/list");
	 }
	 
	 @RequestMapping(value="/delete/{returnid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("returnid") int returnid){
		 HtaxService.deleteHtax(returnid);
	  
	  return new ModelAndView("redirect:/Htax/list");
	 }
}
