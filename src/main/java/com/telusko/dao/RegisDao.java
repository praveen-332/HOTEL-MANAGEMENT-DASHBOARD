package com.telusko.dao;

import java.util.List;

import com.telusko.model.Regis;


public interface RegisDao {



		public List<Regis> listallregis();
		public void addregis(Regis regis);
		public void updateregis(Regis regis);
		public void deleteregis(String username);
		public Regis findregisbyusername(String username);
		


}
