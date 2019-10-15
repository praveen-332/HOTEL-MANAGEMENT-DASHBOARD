package com.telusko.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.telusko.model.Regis;
import com.telusko.service.RegisService;

@RestController

@RequestMapping(value="/regis")
public class RegisController {
	@Autowired
	RegisService regisservice;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
		public ModelAndView regis(){
			  ModelAndView model = new ModelAndView("regis/regis_page");

				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String name = auth.getName();
				if(name.equals("admin")) {
					model.setViewName("regis/regis_page");
					
				}
				else {model.setViewName("index2");}
			 
			  List regis = regisservice.listallregis();
			  model.addObject("listregis", regis);
			  
			  return model;
		 }
		 @RequestMapping(value="/add", method=RequestMethod.GET)
		 public ModelAndView regisadd(){
			 ModelAndView model = new ModelAndView("regis/regis_form");
			 
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String name = auth.getName();
				if(name.equals("admin")) {
					model.setViewName("regis/regis_form");
					
				}
				else {model.setViewName("index2");}
			 
			 Regis regis = new Regis();
			 model.addObject("regisform", regis);
			 return model;
		 }
		 @RequestMapping(value="/update/{username}", method=RequestMethod.GET)
		 public ModelAndView regisupdate(@PathVariable("username") String username){
		  ModelAndView model = new ModelAndView("regis/regis_upform");
		  
		  Regis regis = regisservice.findregisbyusername(username);
		
		  
		  model.addObject("regisupform", regis);
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("admin")) {
				
				
				return new ModelAndView("redirect:/regis/list");
				
			}
			else {return new ModelAndView("redirect:/");}
		  //return model;
		 }
		 
		 @RequestMapping(value="/up", method=RequestMethod.POST)
		 public ModelAndView regisup(@ModelAttribute("regisupForm") Regis regis){	 
				 
					 
			 regisservice.updateregis(regis);
			 	
			 
				 return new ModelAndView("redirect:/regis/list");
		 }
		 @RequestMapping(value="/save", method=RequestMethod.POST)
		 public ModelAndView regissave(@ModelAttribute("regisForm") Regis regis){	 
				 
					 regisservice.addregis(regis);
				 
			 	
			 
				 return new ModelAndView("redirect:/regis/list");
		 }
		 
		 @RequestMapping(value="/delete/{username}", method=RequestMethod.GET)
		 public ModelAndView regisdelete(@PathVariable("username") String username){
		  regisservice.deleteregis(username);

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("admin")) {
				
				
				return new ModelAndView("redirect:/regis/list");
				
			}
			else {return new ModelAndView("redirect:/");}
		 
		  
		 }
		 
		 @RequestMapping(value="/ferror", method=RequestMethod.GET)
			public ModelAndView ferror(){
				  ModelAndView model = new ModelAndView("regs/ferror");
				  return model;
			 }
	 
}
