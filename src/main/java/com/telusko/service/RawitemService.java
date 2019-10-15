package com.telusko.service;

import java.util.List;




import com.telusko.model.Rawitem;

public interface RawitemService {
public List<Rawitem> listAllRawitems();
	
	public void addRawitem(Rawitem Rawitem);
	
	public void updateRawitem(Rawitem Rawitem); 
	
	public void deleteRawitem(int rid);
	
	public Rawitem findRawitemById(int rid);


}
