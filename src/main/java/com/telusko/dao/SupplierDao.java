package com.telusko.dao;

import java.util.List;




import com.telusko.model.Supplier;

public interface SupplierDao {

	public List<Supplier> listAllSuppliers();
	
	public void addSupplier(Supplier Supplier);
	
	public void updateSupplier(Supplier Supplier); 
	
	public void deleteSupplier(int sid);
	
	public Supplier findSupplierById(int sid);
}
