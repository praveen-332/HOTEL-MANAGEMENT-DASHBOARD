package com.telusko.service;
import java.util.List;

//import org.springframework.security.crypto.password.PasswordEncoder;

import com.telusko.model.Regis;

public interface RegisService {

	
		public List<Regis> listallregis();
		
		public void addregis(Regis regis);
		
		public void updateregis(Regis regis);
		
		public void deleteregis(String username);
			
		public Regis findregisbyusername(String username);


}
