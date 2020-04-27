package com.po;

public class GoodsType {
	private int id;
	private String typename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GoodsType() {
		super();
	}
	public GoodsType(int id, String typename) {
		super();
		this.id = id;
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", typename=" + typename + "]";
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

}
