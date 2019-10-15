package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Discount;
import com.telusko.service.DiscountService;



@RestController

@RequestMapping(value="/discount")
public class DiscountController {
	
	
	

	@Autowired
	DiscountService discountService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("discount/discount_page");
	  
	  List list = discountService.listAllDiscounts();
	  model.addObject("listDiscount", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("discount/discount_form");
	  
	  Discount discount = new Discount();
	  model.addObject("discountForm", discount);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{did}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("did") int did){
	  ModelAndView model = new ModelAndView("discount/discount_form");
	  
	  Discount discount = discountService.findDiscountById(did);
	  model.addObject("discountForm", discount);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("discountForm") Discount discount){
	  if(discount != null && discount.getDid() != null){
		  discountService.updateDiscount(discount);
	  } else {
		  discountService.addDiscount(discount);
	  }
	  
	  return new ModelAndView("redirect:/discount/list");
	 }
	 
	 @RequestMapping(value="/delete/{did}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("did") int did){
		 discountService.deleteDiscount(did);
	  
	  return new ModelAndView("redirect:/discount/list");
	 }

}
