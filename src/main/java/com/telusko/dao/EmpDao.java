package com.telusko.dao;

import java.util.List;



import com.telusko.model.Emp;

public interface EmpDao {
	public List<Emp> listAllEmps();
	
	public void addEmp(Emp emp);
	
	public void updateEmp(Emp emp); 
	
	public void deleteEmp(int eid);
	
	public Emp findEmpByeid(int eid);
	
	


}