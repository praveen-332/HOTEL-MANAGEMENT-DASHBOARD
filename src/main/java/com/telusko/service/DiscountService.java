package com.telusko.service;

import java.util.List;


import com.telusko.model.Discount;

public interface DiscountService {
public List<Discount> listAllDiscounts();
	
	public void addDiscount(Discount discount);
	
	public void updateDiscount(Discount discount); 
	
	public void deleteDiscount(int did);
	
	public Discount findDiscountById(int did);

}
