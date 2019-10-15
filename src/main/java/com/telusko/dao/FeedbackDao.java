package com.telusko.dao;

import java.util.List;



import com.telusko.model.Feedback;

public interface FeedbackDao {

	public List<Feedback> listAllFeedbacks();
	
	public void addFeedback(Feedback Feedback);
	
	public void updateFeedback(Feedback Feedback); 
	
	public void deleteFeedback(int fid);
	
	public Feedback findFeedbackById(int fid);
}
