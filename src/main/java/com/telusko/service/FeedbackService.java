package com.telusko.service;

import java.util.List;



import com.telusko.model.Feedback;

public interface FeedbackService {
public List<Feedback> listAllFeedbacks();
	
	public void addFeedback(Feedback Feedback);
	
	public void updateFeedback(Feedback Feedback); 
	
	public void deleteFeedback(int fid);
	
	public Feedback findFeedbackById(int fid);


}
