package com.telusko.service;

import java.util.List;




import com.telusko.model.Expences;

public interface ExpencesService {
public List<Expences> listAllExpencess();
	
	public void addExpences(Expences Expences);
	
	public void updateExpences(Expences Expences); 
	
	public void deleteExpences(int expid);
	
	public Expences findExpencesById(int expid);


}
