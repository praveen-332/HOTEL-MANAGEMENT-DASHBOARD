package com.telusko.dao;

import java.util.List;






import com.telusko.model.Ctb;

public interface CtbDao {

	public List<Ctb> listAllCtbs();
	
	public void addCtb(Ctb Ctb);
	
	public void updateCtb(Ctb Ctb); 
	
	public void deleteCtb(int tbid);
	
	public Ctb findCtbById(int tbid);
}
