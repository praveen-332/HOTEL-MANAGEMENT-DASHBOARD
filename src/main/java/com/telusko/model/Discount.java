import javax.persistence.Entity;
import javax.persistence.Id;
package com.telusko.model;
import javax.persistence.Table;

@Entity
@Table
public class Discount {
	@Id
	private Integer did;
	private int per;
	private String validtill;
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	
	public String getValidtill() {
		return validtill;
	}
	public void setValidtill(String validtill) {
		this.validtill = validtill;
	}
	public Discount(Integer did) {
		
		this.did = did;
	}
	public Discount() {
		
	}
	
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	
	
	
 
}
