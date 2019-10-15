package com.telusko.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telusko.dao.EmpDao;
import com.telusko.model.Emp;



@Service
@Component
public class EmpServiceImpl implements EmpService {

	EmpDao empdao;
	
	
	@Autowired
	public void setEmpdao(EmpDao empdao) {
		this.empdao = empdao;
	}

	@Override
	public List<Emp> listAllEmps() {
		return empdao.listAllEmps();
	}

	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		empdao.addEmp(emp);
		
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		empdao.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int eid) {
		// TODO Auto-generated method stub
		empdao.deleteEmp(eid);
		
	}

	@Override
	public Emp findEmpById(int eid) {
		// TODO Auto-generated method stub
		return empdao.findEmpByeid(eid);
	}
	

}
