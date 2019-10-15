package com.telusko.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.ExpencesDao;
import com.telusko.model.Expences;

@Service
@Component
public class ExpencesServiceImpl implements ExpencesService {

	ExpencesDao ExpencesDao;
	@Autowired
	public void setUserdao(ExpencesDao userdao) {
		this.ExpencesDao = userdao;
	}
	@Override
	public List<Expences> listAllExpencess() {
		return ExpencesDao.listAllExpencess();
	}

	@Override
	public void addExpences(Expences Expences) {
		// TODO Auto-generated method stub
		ExpencesDao.addExpences(Expences);
		
	}

	@Override
	public void updateExpences(Expences Expences) {
		// TODO Auto-generated method stub
		ExpencesDao.updateExpences(Expences);
	}

	@Override
	public void deleteExpences(int expid) {
		// TODO Auto-generated method stub
		ExpencesDao.deleteExpences(expid);
		
	}

	@Override
	public Expences findExpencesById(int expid) {
		// TODO Auto-generated method stub
		return ExpencesDao.findExpencesById(expid);
	}
	
}
