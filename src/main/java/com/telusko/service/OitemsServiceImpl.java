package com.telusko.service;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.OitemsDao;
import com.telusko.model.Oitems;

@Service
@Component
public class OitemsServiceImpl implements OitemsService {

	OitemsDao OitemsDao;
	@Autowired
	public void setUserdao(OitemsDao userdao) {
		this.OitemsDao = userdao;
	}
	@Override
	public List<Oitems> listAllOitemss() {
		return OitemsDao.listAllOitemss();
	}

	@Override
	public void addOitems(Oitems Oitems) {
		// TODO Auto-generated method stub
		OitemsDao.addOitems(Oitems);
		
	}

	@Override
	public void updateOitems(Oitems Oitems) {
		// TODO Auto-generated method stub
		OitemsDao.updateOitems(Oitems);
	}

	@Override
	public void deleteOitems(int Oitemsid) {
		// TODO Auto-generated method stub
		OitemsDao.deleteOitems(Oitemsid);
		
	}

	@Override
	public Oitems findOitemsById(int Oitemsid) {
		// TODO Auto-generated method stub
		return OitemsDao.findOitemsById(Oitemsid);
	}
	
}
