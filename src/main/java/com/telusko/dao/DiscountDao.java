package com.telusko.dao;
import java.util.List;






import com.telusko.model.Discount;

public interface DiscountDao {
	


		public List<Discount> listAllDiscounts();
		
		public void addDiscount(Discount discount);
		
		public void updateDiscount(Discount discount); 
		
		public void deleteDiscount(int did);
		
		public Discount findDiscountById(int did);
		
		
		

	


}
