package com.telusko.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.RawitemDao;
import com.telusko.model.Rawitem;

@Service
@Component
public class RawitemServiceImpl implements RawitemService {

	RawitemDao RawitemDao;
	@Autowired
	public void setUserdao(RawitemDao userdao) {
		this.RawitemDao = userdao;
	}
	@Override
	public List<Rawitem> listAllRawitems() {
		return RawitemDao.listAllRawitems();
	}

	@Override
	public void addRawitem(Rawitem Rawitem) {
		// TODO Auto-generated method stub
		RawitemDao.addRawitem(Rawitem);
		
	}

	@Override
	public void updateRawitem(Rawitem Rawitem) {
		// TODO Auto-generated method stub
		RawitemDao.updateRawitem(Rawitem);
	}

	@Override
	public void deleteRawitem(int rid) {
		// TODO Auto-generated method stub
		RawitemDao.deleteRawitem(rid);
		
	}

	@Override
	public Rawitem findRawitemById(int rid) {
		// TODO Auto-generated method stub
		return RawitemDao.findRawitemById(rid);
	}
	
}
