package com.service.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.BuserAndOrderBaseTable;
@Repository
public interface BuserAndOrderBaseService {

	public List<BuserAndOrderBaseTable> selectBuserAndOrderBaseById();
	public int deleteOrderById(int id);
}
