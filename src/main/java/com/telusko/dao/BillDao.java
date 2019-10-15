package com.telusko.dao;

import java.util.List;






import com.telusko.model.Bill;

public interface BillDao {

	public List<Bill> listAllBills();
	
	public void addBill(Bill Bill);
	
	public void updateBill(Bill Bill); 
	
	public void deleteBill(int billid);
	
	public Bill findBillById(int billid);
	public List<Bill> lastBill();
}
