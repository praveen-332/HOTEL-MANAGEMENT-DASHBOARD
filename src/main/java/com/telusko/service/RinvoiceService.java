package com.telusko.service;

import java.util.List;





import com.telusko.model.Rinvoice;

public interface RinvoiceService {
public List<Rinvoice> listAllRinvoices();
	
	public void addRinvoice(Rinvoice Rinvoice);
	
	public void updateRinvoice(Rinvoice Rinvoice); 
	
	public void deleteRinvoice(int rrid);
	
	public Rinvoice findRinvoiceById(int rrid);


}
