package com.telusko.demo;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Ctb;
import com.telusko.service.CtbService;

@RestController

@RequestMapping(value="/Ctb")
public class CtbController {


	@Autowired
	CtbService CtbService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Ctb/Ctb_page");
	  
	  List list = CtbService.listAllCtbs();
	  model.addObject("listCtb", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Ctb/Ctb_form");
	  
	  Ctb Ctb = new Ctb();
	  model.addObject("CtbForm", Ctb);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{tbid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("tbid") int tbid){
	  ModelAndView model = new ModelAndView("Ctb/Ctb_form");
	  
	  Ctb Ctb = CtbService.findCtbById(tbid);
	  model.addObject("CtbForm", Ctb);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("CtbForm") Ctb Ctb){
	  if(Ctb != null && Ctb.getTbid() != null){
		  CtbService.updateCtb(Ctb);
	  } else {
		  CtbService.addCtb(Ctb);
	  }
	  
	  return new ModelAndView("redirect:/Ctb/list");
	 }
	 
	 @RequestMapping(value="/delete/{tbid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("tbid") int tbid){
		 CtbService.deleteCtb(tbid);
	  
	  return new ModelAndView("redirect:/Ctb/list");
	 }
}
