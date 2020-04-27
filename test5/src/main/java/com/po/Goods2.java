package com.po;

public class Goods2 {

	@Override
	public String toString() {
		return "Goods2 [shoppingnum=" + shoppingnum + ", id=" + id + ", gname=" + gname + ", goprice=" + goprice
				+ ", grprice=" + grprice + ", gpicture=" + gpicture + "]";
	}
	private int shoppingnum;
	private int id;
	private String gname;
	private double goprice;
	private double grprice;
	private String gpicture;
	public int getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(int shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGoprice() {
		return goprice;
	}
	public void setGoprice(double goprice) {
		this.goprice = goprice;
	}
	public double getGrprice() {
		return grprice;
	}
	public void setGrprice(double grprice) {
		this.grprice = grprice;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}

}
