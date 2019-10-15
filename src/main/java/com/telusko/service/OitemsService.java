package com.telusko.service;

import java.util.List;







import com.telusko.model.Oitems;

public interface OitemsService {
public List<Oitems> listAllOitemss();
	
	public void addOitems(Oitems Oitems);
	
	public void updateOitems(Oitems Oitems); 
	
	public void deleteOitems(int Oitemsid);
	
	public Oitems findOitemsById(int Oitemsid);


}
