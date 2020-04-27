package com.po;

import java.util.Date;

public class FocusTable {
	private int id;
	private int goodstable_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodstable_id() {
		return goodstable_id;
	}
	public void setGoodstable_id(int goodstable_id) {
		this.goodstable_id = goodstable_id;
	}
	public int getBusertable_id() {
		return busertable_id;
	}
	public void setBusertable_id(int busertable_id) {
		this.busertable_id = busertable_id;
	}
	public Date getFucoustime() {
		return fucoustime;
	}
	public void setFucoustime(Date fucoustime) {
		this.fucoustime = fucoustime;
	}
	private int busertable_id;
	private Date fucoustime;

}
