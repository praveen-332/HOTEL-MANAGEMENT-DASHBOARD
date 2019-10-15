package com.telusko.model;

import javax.persistence.Table;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table

public class Rawitem {
	@Id
	private Integer rid;
	private int suppliedby;
	private String rquantity;
	private int riprice;
	private boolean rstock;
	
	public Rawitem(Integer rid) {
	
		this.rid = rid;
	}
	
	public Rawitem() {
	
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public int getSuppliedby() {
		return suppliedby;
	}

	public void setSuppliedby(int suppliedby) {
		this.suppliedby = suppliedby;
	}

	public String getRquantity() {
		return rquantity;
	}

	public void setRquantity(String rquantity) {
		this.rquantity = rquantity;
	}

	public int getRiprice() {
		return riprice;
	}

	public void setRiprice(int riprice) {
		this.riprice = riprice;
	}

	public boolean isRstock() {
		return rstock;
	}

	public void setRstock(boolean rstock) {
		this.rstock = rstock;
	}
	
	
}
