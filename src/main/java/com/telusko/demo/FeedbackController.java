package com.telusko.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Feedback;
import com.telusko.service.FeedbackService;

@RestController

@RequestMapping(value="/Feedback")
public class FeedbackController {


	@Autowired
	FeedbackService FeedbackService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Feedback/Feedback_page");
	  
	  List list = FeedbackService.listAllFeedbacks();
	  model.addObject("listFeedback", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Feedback/Feedback_form");
	  
	  Feedback Feedback = new Feedback();
	  model.addObject("FeedbackForm", Feedback);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/update/{fid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("fid") int fid){
	  ModelAndView model = new ModelAndView("Feedback/Feedback_form");
	  
	  Feedback Feedback = FeedbackService.findFeedbackById(fid);
	  model.addObject("FeedbackForm", Feedback);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("FeedbackForm") Feedback Feedback){
	  if(Feedback != null && Feedback.getFid() != null){
		  FeedbackService.updateFeedback(Feedback);
	  } else {
		  FeedbackService.addFeedback(Feedback);
	  }
	  
	  return new ModelAndView("redirect:/Feedback/list");
	 }
	 
	 @RequestMapping(value="/delete/{fid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("fid") int fid){
		 FeedbackService.deleteFeedback(fid);
	  
	  return new ModelAndView("redirect:/Feedback/list");
	 }
}
