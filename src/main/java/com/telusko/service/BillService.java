package com.telusko.service;

import java.util.List;







import com.telusko.model.Bill;

public interface BillService {
public List<Bill> listAllBills();
	
	public void addBill(Bill Bill);
	
	public void updateBill(Bill Bill); 
	
	public void deleteBill(int billid);
	
	public Bill findBillById(int billid);

	public List<Bill> lastBill();
}
