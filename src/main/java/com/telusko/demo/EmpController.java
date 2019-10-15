package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Emp;

import com.telusko.service.EmpService;


@RestController
@RequestMapping(value="/Emp")
public class EmpController {
	
	@Autowired
	EmpService EmpService;
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Emp/Emp_page");
	  
	  List list = EmpService.listAllEmps();
	  
	  
	  
	  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(name.equals("admin")) {
			model.setViewName("Emp/Emp_page");
			
		}
		else {model.setViewName("index2");}
	  model.addObject("listEmp", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Emp/Emp_form");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(name.equals("admin")) {
			model.setViewName("Emp/Emp_form");
			
		}
		else {model.setViewName("index2");}
	  Emp Emp = new Emp();
	  model.addObject("EmpForm", Emp);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{eid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("eid") int eid){
	  ModelAndView model = new ModelAndView("Emp/Emp_form");
	  
	  Emp Emp = EmpService.findEmpById(eid);
	  model.addObject("EmpForm", Emp);
	  
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(name.equals("admin")) {
			
			
			return new ModelAndView("redirect:/Emp/list");
			
		}
		else {return new ModelAndView("redirect:/");}
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("EmpForm") Emp Emp){
	  if(Emp != null && Emp.getEid() != null){
		  EmpService.updateEmp(Emp);
	  } else {
		  EmpService.addEmp(Emp);
	  }
	  
	  return new ModelAndView("redirect:/Emp/list");
	 }
	 
	 @RequestMapping(value="/delete/{eid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("eid") int eid){
		 EmpService.deleteEmp(eid);
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("admin")) {
				
				
				return new ModelAndView("redirect:/Emp/list");
				
			}
			else {return new ModelAndView("redirect:/");}
	  
	 }
}