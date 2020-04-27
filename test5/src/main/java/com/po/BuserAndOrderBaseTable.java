package com.po;

import java.util.Date;

public class BuserAndOrderBaseTable {
	private int id;
	private String bemail;
	private double amount;
	private int status;
	private Date orderdate;
	@Override
	public String toString() {
		return "BuserAndOrderBaseTable [id=" + id + ", bemail=" + bemail + ", amount=" + amount + ", status=" + status
				+ ", orderdate=" + orderdate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
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
