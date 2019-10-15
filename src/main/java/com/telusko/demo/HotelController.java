package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Hotel;
import com.telusko.service.HotelService;

@RestController

@RequestMapping(value="/Hotel")
public class HotelController {


	@Autowired
	HotelService HotelService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Hotel/Hotel_page");
	  
	  List list = HotelService.listAllHotels();
	  model.addObject("listHotel", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Hotel/Hotel_form");
	  
	  Hotel Hotel = new Hotel();
	  model.addObject("HotelForm", Hotel);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{hid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("hid") int hid){
	  ModelAndView model = new ModelAndView("Hotel/Hotel_form");
	  
	  Hotel Hotel = HotelService.findHotelById(hid);
	  model.addObject("HotelForm", Hotel);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("HotelForm") Hotel Hotel){
	  if(Hotel != null && Hotel.getHid() != null){
		  HotelService.updateHotel(Hotel);
	  } else {
		  HotelService.addHotel(Hotel);
	  }
	  
	  return new ModelAndView("redirect:/Hotel/list");
	 }
	 
	 @RequestMapping(value="/delete/{hid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("hid") int hid){
		 HotelService.deleteHotel(hid);
	  
	  return new ModelAndView("redirect:/Hotel/list");
	 }
}
