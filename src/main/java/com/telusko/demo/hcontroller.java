package com.telusko.demo;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class hcontroller 
{
	@RequestMapping("/")
	public ModelAndView home()
	{ ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String name = auth.getName();
	if(name.equals("admin")) {
		modelAndView.setViewName("index");
		
	}
	else {modelAndView.setViewName("index2");}
		return modelAndView;
		
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "logout";
	}
}