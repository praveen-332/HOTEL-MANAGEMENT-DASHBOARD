package com.telusko.model;
import javax.persistence.Table;




import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Oitems {
	@Id
	private int oid;
	
	private int billid;
	private int iid;
	private int quantity;
	private int iprice;
	private int igross;
	

	public int getIgross() {
		return igross;
	}


	public void setIgross(int igross) {
		this.igross = igross;
	}


	public Oitems(int oid) {
		
		this.oid = oid;
	}
	

	public Oitems() {
		
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getBillid() {
		return billid;
	}


	public void setBillid(int billid) {
		this.billid = billid;
	}


	public int getIid() {
		return iid;
	}


	public void setIid(int iid) {
		this.iid = iid;
	}


	public int getIprice() {
		return iprice;
	}


	public void setIprice(int iprice) {
		this.iprice = iprice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
	
	

}
