package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Item;
import com.telusko.service.ItemService;

@RestController

@RequestMapping(value="/Item")
public class ItemController {


	@Autowired
	ItemService ItemService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Item/Item_page");
	  
	  List list = ItemService.listAllItems();
	  model.addObject("listItem", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Item/Item_form");
	  
	  Item Item = new Item();
	  model.addObject("ItemForm", Item);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{iid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("iid") int iid){
	  ModelAndView model = new ModelAndView("Item/Item_form");
	  
	  Item Item = ItemService.findItemById(iid);
	  model.addObject("ItemForm", Item);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("ItemForm") Item Item){
	  if(Item != null && Item.getIid() != null){
		  ItemService.updateItem(Item);
	  } else {
		  ItemService.addItem(Item);
	  }
	  
	  return new ModelAndView("redirect:/Item/list");
	 }
	 
	 @RequestMapping(value="/delete/{iid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("iid") int iid){
		 ItemService.deleteItem(iid);
	  
	  return new ModelAndView("redirect:/Item/list");
	 }
}
