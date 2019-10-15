package com.telusko.service;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.DiscountDao;

import com.telusko.model.Discount;




@Service
@Component
public class DiscountServiceImpl implements DiscountService {
	
	DiscountDao discountDao;
	@Autowired
	public void setUserdao(DiscountDao userdao) {
		this.discountDao = userdao;
	}

	@Override
	public List<Discount> listAllDiscounts() {
		return discountDao.listAllDiscounts();
	}

	@Override
	public void addDiscount(Discount discount) {
		// TODO Auto-generated method stub
		discountDao.addDiscount(discount);
		
	}

	@Override
	public void updateDiscount(Discount discount) {
		// TODO Auto-generated method stub
		discountDao.updateDiscount(discount);
	}

	@Override
	public void deleteDiscount(int did) {
		// TODO Auto-generated method stub
		discountDao.deleteDiscount(did);
		
	}

	@Override
	public Discount findDiscountById(int did) {
		// TODO Auto-generated method stub
		return discountDao.findDiscountById(did);
	}
	

}
