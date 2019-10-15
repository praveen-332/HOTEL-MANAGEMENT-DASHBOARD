package com.telusko.model;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Discount {
	@Id
	private Integer did;
	private int per;
	private String validtill;
	
	
	public Discount(Integer did) {
		
		this.did = did;
	}
	public Discount() {
		
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	public String getValidtill() {
		return validtill;
	}
	public void setValidtill(String validtill) {
		this.validtill = validtill;
	}
	
	
 
}
