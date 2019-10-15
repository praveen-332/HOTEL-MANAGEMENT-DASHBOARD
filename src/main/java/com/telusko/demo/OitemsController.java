package com.telusko.demo;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Oitems;
import com.telusko.service.BillService;
import com.telusko.service.ItemService;
import com.telusko.service.OitemsService;

@RestController

@RequestMapping(value="/Oitems")
public class OitemsController {
	@Autowired
	ItemService itemService;
	 
	@Autowired
	OitemsService OitemsService;
	@Autowired
	BillService billSerivce;
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Oitems/Oitems_page");
	  
	  List list = OitemsService.listAllOitemss();
	  model.addObject("listOitems", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Oitems/Oitems_form");
	  List list = billSerivce.lastBill();
	  List list2 = itemService.listAllItems();
	  Oitems Oitems = new Oitems();
	  model.addObject("OitemsForm", Oitems);
	  model.addObject("lastBill",list);
	  model.addObject("lisItems",list2);
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{oid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("oid") int oid){
	  ModelAndView model = new ModelAndView("Oitems/Oitems_form");
	  
	  Oitems Oitems = OitemsService.findOitemsById(oid);
	  model.addObject("OitemsForm", Oitems);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("OitemsForm") Oitems Oitems){
	  if(Oitems != null && Oitems.getOid() !=0){
		  OitemsService.updateOitems(Oitems);
	  } else {
		  OitemsService.addOitems(Oitems);
	  }
	  
	  return new ModelAndView("redirect:/Oitems/list");
	 }
	 
	 @RequestMapping(value="/delete/{oid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("oid") int oid){
		 OitemsService.deleteOitems(oid);
	  
	  return new ModelAndView("redirect:/Oitems/list");
	 }
}
