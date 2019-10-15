package com.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Htax {
	@Id
	private Integer returnid;
	private int hid;
	private int returnamount;
	
	private String returntype;

	private String returndate;

	public Htax(Integer returnid) {
		
		this.returnid = returnid;
	}
	
	public Htax() {
		
	}

	public Integer getReturnid() {
		return returnid;
	}

	public void setReturnid(Integer returnid) {
		this.returnid = returnid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	

	public int getReturnamount() {
		return returnamount;
	}

	public void setReturnamount(int returnamount) {
		this.returnamount = returnamount;
	}

	public String getReturntype() {
		return returntype;
	}

	public void setReturntype(String returntype) {
		this.returntype = returntype;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
}
