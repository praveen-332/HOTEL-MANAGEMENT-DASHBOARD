package com.telusko.service;

import java.util.List;







import com.telusko.model.Ctb;

public interface CtbService {
public List<Ctb> listAllCtbs();
	
	public void addCtb(Ctb Ctb);
	
	public void updateCtb(Ctb Ctb); 
	
	public void deleteCtb(int Ctbid);
	
	public Ctb findCtbById(int Ctbid);


}
