package com.telusko.service;

import java.util.List;





import com.telusko.model.Emp;


public interface EmpService {
	public List<Emp> listAllEmps();
	
	public void addEmp(Emp emp);
	
	public void updateEmp(Emp emp); 
	
	public void deleteEmp(int eid);
	
	public Emp findEmpById(int eid);

}