package com.telusko.service;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.BillDao;
import com.telusko.model.Bill;

@Service
@Component
public class BillServiceImpl implements BillService {

	BillDao BillDao;
	@Autowired
	public void setUserdao(BillDao userdao) {
		this.BillDao = userdao;
	}
	@Override
	public List<Bill> listAllBills() {
		return BillDao.listAllBills();
	}

	@Override
	public void addBill(Bill Bill) {
		// TODO Auto-generated method stub
		BillDao.addBill(Bill);
		
	}

	@Override
	public void updateBill(Bill Bill) {
		// TODO Auto-generated method stub
		BillDao.updateBill(Bill);
	}

	@Override
	public void deleteBill(int billid) {
		// TODO Auto-generated method stub
		BillDao.deleteBill(billid);
		
	}

	@Override
	public Bill findBillById(int billid) {
		// TODO Auto-generated method stub
		return BillDao.findBillById(billid);
	}
	@Override
	public List<Bill> lastBill(){
		return BillDao.lastBill();
	}
	}
	
