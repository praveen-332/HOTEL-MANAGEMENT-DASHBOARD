package com.telusko.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.SupplierDao;
import com.telusko.model.Supplier;

@Service
@Component
public class SupplierServiceImpl implements SupplierService {

	SupplierDao SupplierDao;
	@Autowired
	public void setUserdao(SupplierDao userdao) {
		this.SupplierDao = userdao;
	}
	@Override
	public List<Supplier> listAllSuppliers() {
		return SupplierDao.listAllSuppliers();
	}

	@Override
	public void addSupplier(Supplier Supplier) {
		// TODO Auto-generated method stub
		SupplierDao.addSupplier(Supplier);
		
	}

	@Override
	public void updateSupplier(Supplier Supplier) {
		// TODO Auto-generated method stub
		SupplierDao.updateSupplier(Supplier);
	}

	@Override
	public void deleteSupplier(int sid) {
		// TODO Auto-generated method stub
		SupplierDao.deleteSupplier(sid);
		
	}

	@Override
	public Supplier findSupplierById(int sid) {
		// TODO Auto-generated method stub
		return SupplierDao.findSupplierById(sid);
	}
	
}
