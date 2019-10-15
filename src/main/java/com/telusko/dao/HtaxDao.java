package com.telusko.dao;
import java.util.List;




import com.telusko.model.Htax;

public interface HtaxDao {

	public List<Htax> listAllHtaxs();
	
	public void addHtax(Htax Htax);
	
	public void updateHtax(Htax Htax); 
	
	public void deleteHtax(int returnid);
	
	public Htax findHtaxById(int returnid);
}


