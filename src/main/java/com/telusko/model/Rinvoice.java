package com.telusko.model;
import javax.persistence.Table;



import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table
public class Rinvoice {
	@Id
	private Integer rrid;
	private int rid;
	private int riprice;
	private String rindate;
	
	private int riquantity;
	private int tax_gst;
	private int total_price;



	public Rinvoice(Integer rrid) {
		this.rrid = rrid;
	}

	public Rinvoice() {
		
	}

	public Integer getRrid() {
		return rrid;
	}

	public void setRrid(Integer rrid) {
		this.rrid = rrid;
	}

	public int getRiprice() {
		return riprice;
	}

	public void setRiprice(int riprice) {
		this.riprice = riprice;
	}

	public String getRindate() {
		return rindate;
	}

	public void setRindate(String rindate) {
		this.rindate = rindate;
	}

	public int getRiquantity() {
		return riquantity;
	}

	public void setRiquantity(int riquantity) {
		this.riquantity = riquantity;
	}

	public int getTax_gst() {
		return tax_gst;
	}

	public void setTax_gst(int tax_gst) {
		this.tax_gst = tax_gst;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	
	
}
