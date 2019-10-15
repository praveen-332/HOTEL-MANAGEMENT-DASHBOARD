package com.telusko.service;

import java.util.List;







import com.telusko.model.Fbill;

public interface FbillService {
public List<Fbill> listAllFbills();
	
	public void addFbill(Fbill Fbill);
	
	public void updateFbill(Fbill Fbill); 
	
	public void deleteFbill(int id);
	
	public Fbill findFbillById(int id);


}
