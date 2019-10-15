package com.telusko.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.FeedbackDao;
import com.telusko.model.Feedback;

@Service
@Component
public class FeedbackServiceImpl implements FeedbackService {

	FeedbackDao FeedbackDao;
	@Autowired
	public void setUserdao(FeedbackDao userdao) {
		this.FeedbackDao = userdao;
	}
	@Override
	public List<Feedback> listAllFeedbacks() {
		return FeedbackDao.listAllFeedbacks();
	}

	@Override
	public void addFeedback(Feedback Feedback) {
		// TODO Auto-generated method stub
		FeedbackDao.addFeedback(Feedback);
		
	}

	@Override
	public void updateFeedback(Feedback Feedback) {
		// TODO Auto-generated method stub
		FeedbackDao.updateFeedback(Feedback);
	}

	@Override
	public void deleteFeedback(int fid) {
		// TODO Auto-generated method stub
		FeedbackDao.deleteFeedback(fid);
		
	}

	@Override
	public Feedback findFeedbackById(int fid) {
		// TODO Auto-generated method stub
		return FeedbackDao.findFeedbackById(fid);
	}
	
}
