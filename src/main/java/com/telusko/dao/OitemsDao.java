package com.telusko.dao;

import java.util.List;






import com.telusko.model.Oitems;

public interface OitemsDao {

	public List<Oitems> listAllOitemss();
	
	public void addOitems(Oitems Oitems);
	
	public void updateOitems(Oitems Oitems); 
	
	public void deleteOitems(int Oitemsid);
	
	public Oitems findOitemsById(int Oitemsid);
}
