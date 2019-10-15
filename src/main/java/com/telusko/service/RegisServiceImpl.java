package com.telusko.service;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

/*
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
*/

import com.telusko.dao.RegisDao;
import com.telusko.model.Regis;

@Service
@Component
public class RegisServiceImpl implements RegisService{
	@Autowired
	RegisDao regisdao;
	public void setregisdao(Regis regis, RegisDao regisdao) {
		this.regisdao = regisdao;
	}
	@Override
	public List<Regis> listallregis() {
		return regisdao.listallregis();
	}

	@Override
	public void addregis(Regis regis){
		// TODO Auto-generated method stub
		regisdao.addregis(regis);
		
	}

	@Override
	public void updateregis(Regis regis) {
		// TODO Auto-generated method stub
		regisdao.updateregis(regis);
	}

	@Override
	public void deleteregis(String username) {
		// TODO Auto-generated method stub
		regisdao.deleteregis(username);
		
	}

	@Override
	public Regis findregisbyusername(String username) {
		// TODO Auto-generated method stub
		return regisdao.findregisbyusername(username);
	}

}
