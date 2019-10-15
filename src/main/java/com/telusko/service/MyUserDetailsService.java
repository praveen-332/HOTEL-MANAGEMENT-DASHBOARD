package com.telusko.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.dao.RegisDao;
import com.telusko.model.Regis;
import com.telusko.model.userprinciple;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private RegisDao regisdao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Regis regis = regisdao.findregisbyusername(username);
		if(regis==null) {
			throw new UsernameNotFoundException("User 404");
		}
		return new userprinciple(regis);
	}

}