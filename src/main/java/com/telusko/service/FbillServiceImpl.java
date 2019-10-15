package com.telusko.service;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.FbillDao;
import com.telusko.model.Fbill;

@Service
@Component
public class FbillServiceImpl implements FbillService {

	FbillDao FbillDao;
	@Autowired
	public void setUserdao(FbillDao userdao) {
		this.FbillDao = userdao;
	}
	@Override
	public List<Fbill> listAllFbills() {
		return FbillDao.listAllFbills();
	}

	@Override
	public void addFbill(Fbill Fbill) {
		// TODO Auto-generated method stub
		FbillDao.addFbill(Fbill);
		
	}

	@Override
	public void updateFbill(Fbill Fbill) {
		// TODO Auto-generated method stub
		FbillDao.updateFbill(Fbill);
	}

	@Override
	public void deleteFbill(int Fbillid) {
		// TODO Auto-generated method stub
		FbillDao.deleteFbill(Fbillid);
		
	}

	@Override
	public Fbill findFbillById(int Fbillid) {
		// TODO Auto-generated method stub
		return FbillDao.findFbillById(Fbillid);
	}
	
}
