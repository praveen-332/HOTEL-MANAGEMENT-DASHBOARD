package com.telusko.demo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Rawitem;
import com.telusko.service.RawitemService;

@RestController

@RequestMapping(value="/Rawitem")
public class RawitemController {


	@Autowired
	RawitemService RawitemService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Rawitem/Rawitem_page");
	  
	  List list = RawitemService.listAllRawitems();
	  model.addObject("listRawitem", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Rawitem/Rawitem_form");
	  
	  Rawitem Rawitem = new Rawitem();
	  model.addObject("RawitemForm", Rawitem);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{rid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("rid") int rid){
	  ModelAndView model = new ModelAndView("Rawitem/Rawitem_form");
	  
	  Rawitem Rawitem = RawitemService.findRawitemById(rid);
	  model.addObject("RawitemForm", Rawitem);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("RawitemForm") Rawitem Rawitem){
	  if(Rawitem != null && Rawitem.getRid() != null){
		  RawitemService.updateRawitem(Rawitem);
	  } else {
		  RawitemService.addRawitem(Rawitem);
	  }
	  
	  return new ModelAndView("redirect:/Rawitem/list");
	 }
	 
	 @RequestMapping(value="/delete/{rid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("rid") int rid){
		 RawitemService.deleteRawitem(rid);
	  
	  return new ModelAndView("redirect:/Rawitem/list");
	 }
}
