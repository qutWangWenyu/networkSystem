package com.po;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	@Override
	public String toString() {
		return "Goods [id=" + id + ", gname=" + gname + ", goprice=" + goprice + ", grprice=" + grprice + ", gstore="
				+ gstore + ", gpicture=" + gpicture + ", goodstype_id=" + goodstype_id + ", logoImage=" + logoImage
				+ "]";
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String gname;
	private double goprice;
	private double grprice;
	private int gstore;
	private String gpicture;
	private int goodstype_id;
	private MultipartFile logoImage;
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
	public MultipartFile getLogoImage() {
		return logoImage;
	}
	public void setLogoImage(MultipartFile logoImage) {
		this.logoImage = logoImage;
	}

}
