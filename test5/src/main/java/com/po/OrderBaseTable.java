package com.po;

import java.util.Date;

public class OrderBaseTable {
	private int id;
	private int busertable_id;
	private double amount;
	private int status;
    private Date orderdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBusertable_id() {
		return busertable_id;
	}
	public void setBusertable_id(int busertable_id) {
		this.busertable_id = busertable_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
}
