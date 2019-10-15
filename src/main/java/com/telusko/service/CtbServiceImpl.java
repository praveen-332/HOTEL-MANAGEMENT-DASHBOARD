package com.telusko.service;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.CtbDao;
import com.telusko.model.Ctb;

@Service
@Component
public class CtbServiceImpl implements CtbService {

	CtbDao CtbDao;
	@Autowired
	public void setUserdao(CtbDao userdao) {
		this.CtbDao = userdao;
	}
	@Override
	public List<Ctb> listAllCtbs() {
		return CtbDao.listAllCtbs();
	}

	@Override
	public void addCtb(Ctb Ctb) {
		// TODO Auto-generated method stub
		CtbDao.addCtb(Ctb);
		
	}

	@Override
	public void updateCtb(Ctb Ctb) {
		// TODO Auto-generated method stub
		CtbDao.updateCtb(Ctb);
	}

	@Override
	public void deleteCtb(int tbid) {
		// TODO Auto-generated method stub
		CtbDao.deleteCtb(tbid);
		
	}

	@Override
	public Ctb findCtbById(int tbid) {
		// TODO Auto-generated method stub
		return CtbDao.findCtbById(tbid);
	}
	
}
