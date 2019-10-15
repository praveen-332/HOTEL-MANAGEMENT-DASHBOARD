package com.telusko.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.HtaxDao;
import com.telusko.model.Htax;

@Service
@Component
public class HtaxServiceImpl implements HtaxService {

	HtaxDao HtaxDao;
	@Autowired
	public void setUserdao(HtaxDao userdao) {
		this.HtaxDao = userdao;
	}
	@Override
	public List<Htax> listAllHtaxs() {
		return HtaxDao.listAllHtaxs();
	}

	@Override
	public void addHtax(Htax Htax) {
		// TODO Auto-generated method stub
		HtaxDao.addHtax(Htax);
		
	}

	@Override
	public void updateHtax(Htax Htax) {
		// TODO Auto-generated method stub
		HtaxDao.updateHtax(Htax);
	}

	@Override
	public void deleteHtax(int returnid) {
		// TODO Auto-generated method stub
		HtaxDao.deleteHtax(returnid);
		
	}

	@Override
	public Htax findHtaxById(int returnid) {
		// TODO Auto-generated method stub
		return HtaxDao.findHtaxById(returnid);
	}
	
}
