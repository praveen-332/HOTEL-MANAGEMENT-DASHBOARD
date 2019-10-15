package com.telusko.service;

import java.util.List;



import com.telusko.model.Supplier;

public interface SupplierService {
public List<Supplier> listAllSuppliers();
	
	public void addSupplier(Supplier Supplier);
	
	public void updateSupplier(Supplier Supplier); 
	
	public void deleteSupplier(int sid);
	
	public Supplier findSupplierById(int sid);


}
