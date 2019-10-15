package com.telusko.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.RinvoiceDao;
import com.telusko.model.Rinvoice;

@Service
@Component
public class RinvoiceServiceImpl implements RinvoiceService {

	RinvoiceDao RinvoiceDao;
	@Autowired
	public void setUserdao(RinvoiceDao userdao) {
		this.RinvoiceDao = userdao;
	}
	@Override
	public List<Rinvoice> listAllRinvoices() {
		return RinvoiceDao.listAllRinvoices();
	}

	@Override
	public void addRinvoice(Rinvoice Rinvoice) {
		// TODO Auto-generated method stub
		RinvoiceDao.addRinvoice(Rinvoice);
		
	}

	@Override
	public void updateRinvoice(Rinvoice Rinvoice) {
		// TODO Auto-generated method stub
		RinvoiceDao.updateRinvoice(Rinvoice);
	}

	@Override
	public void deleteRinvoice(int rrid) {
		// TODO Auto-generated method stub
		RinvoiceDao.deleteRinvoice(rrid);
		
	}

	@Override
	public Rinvoice findRinvoiceById(int rrid) {
		// TODO Auto-generated method stub
		return RinvoiceDao.findRinvoiceById(rrid);
	}
	
}
