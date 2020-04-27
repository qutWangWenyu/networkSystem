package com.po;

public class GoodsTable {
	private int id;
	private String gname;
	private double goprice;
	private double grprice;
	private int gstore;
	private String gpicture;
	private int goodstype_id;

	public GoodsTable() {
		super();
	}

	public GoodsTable(int id, String gname, double goprice, double grprice, int gstore, String gpicture, int goodstype_id) {
		super();
		this.id = id;
		this.gname = gname;
		this.goprice = goprice;
		this.grprice = grprice;
		this.gstore = gstore;
		this.gpicture = gpicture;
		this.goodstype_id = goodstype_id;
	}

	@Override
	public String toString() {
		return "GoodsTable [id=" + id + ", gname=" + gname + ", goprice=" + goprice + ", grprice=" + grprice
				+ ", gstore=" + gstore + ", gpicture=" + gpicture + ", goodstype_id=" + goodstype_id + "]";
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

	public int getGstore() {
		return gstore;
	}

	public void setGstore(int gstore) {
		this.gstore = gstore;
	}

	public String getGpicture() {
		return gpicture;
	}

	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}

	public int getGoodstype_id() {
		return goodstype_id;
	}

	public void setGoodstype_id(int goodstype_id) {
		this.goodstype_id = goodstype_id;
	}
}
