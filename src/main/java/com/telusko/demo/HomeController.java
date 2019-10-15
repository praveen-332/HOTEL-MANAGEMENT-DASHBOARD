
package com.telusko.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.User;
import com.telusko.service.UserService;
@RestController

@RequestMapping(value="/user")
public class HomeController {

	@Autowired
	 UserService userService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("user/user_page");
	  
	  List list = userService.listAllUsers();
	  model.addObject("listUser", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = new User();
	  model.addObject("userForm", user);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = userService.findUserById(id);
	  model.addObject("userForm", user);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("userForm") User user){
	  if(user != null && user.getId() != null){
	   userService.updateUser(user);
	  } else {
	   userService.addUser(user);
	  }
	  
	  return new ModelAndView("redirect:/user/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  userService.deleteUser(id);
	  
	  return new ModelAndView("redirect:/user/list");
	 }
	 
	 /*@RequestMapping(value="/", method=RequestMethod.GET)
	 public ModelAndView h(){
	  
	  
	  return new ModelAndView("redirect:/");
	 }*/
	 

	 

		/*@RequestMapping("/")
		public String home()
		{
			return "index.jsp";
		}
		
		@RequestMapping("WEB-INF/jsp/login")
		public String loginPage()
		{
			return "login.jsp";
		}
		
		@RequestMapping("WEB-INF/logout-success")
		public String logoutPage()
		{
			return "logout.jsp";
		}*/
}
