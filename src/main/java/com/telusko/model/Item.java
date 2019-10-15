package com.telusko.model;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table

public class Item {
	@Id
	private Integer iid;
	private String iname;
	private String itype;
	private int iprice;
	private boolean istock=false;
	
	public Item(Integer iid) {
		
		this.iid = iid;
	}
	
	public Item() {
		
	}
	
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public int getIprice() {
		return iprice;
	}
	public void setIprice(int i) {
		this.iprice = i;
	}
	
	
	public boolean isIstock() {
		return istock;
	}
	public void setIstock(boolean istock) {
		this.istock = istock;
	}
	
}
