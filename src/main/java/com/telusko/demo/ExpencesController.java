package com.telusko.demo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Expences;
import com.telusko.service.ExpencesService;

@RestController

@RequestMapping(value="/Expences")
public class ExpencesController {


	@Autowired
	ExpencesService ExpencesService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Expences/Expences_page");
	  
	  List list = ExpencesService.listAllExpencess();
	  model.addObject("listExpences", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Expences/Expences_form");
	  
	  Expences Expences = new Expences();
	  model.addObject("ExpencesForm", Expences);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{expid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("expid") int expid){
	  ModelAndView model = new ModelAndView("Expences/Expences_form");
	  
	  Expences Expences = ExpencesService.findExpencesById(expid);
	  model.addObject("ExpencesForm", Expences);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("ExpencesForm") Expences Expences){
		// && Expences.getExpid() != null
	  if(Expences != null && Expences.getExpid()!=null ){
		  ExpencesService.updateExpences(Expences);
	  } else {
		  ExpencesService.addExpences(Expences);
	  }
	  
	  return new ModelAndView("redirect:/Expences/list");
	 }
	 
	 @RequestMapping(value="/delete/{expid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("expid") int expid){
		 ExpencesService.deleteExpences(expid);
	  
	  return new ModelAndView("redirect:/Expences/list");
	 }
}
