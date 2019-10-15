package com.telusko.service;

import java.util.List;




import com.telusko.model.Htax;

public interface HtaxService {
public List<Htax> listAllHtaxs();
	
	public void addHtax(Htax Htax);
	
	public void updateHtax(Htax Htax); 
	
	public void deleteHtax(int returnid);
	
	public Htax findHtaxById(int returnid);


}
