package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BuserAndOrderDao;
import com.po.BuserAndOrderBaseTable;

@Service
public class BuserAndOrderBaseServiceImpl implements BuserAndOrderBaseService {

	@Autowired
	private BuserAndOrderDao buserAndOrder;
	@Override
	public List<BuserAndOrderBaseTable> selectBuserAndOrderBaseById() {
		
		return buserAndOrder.selectBuserAndOrderBaseById();
	}
	@Override
	public int deleteOrderById(int id) {
		
		return buserAndOrder.deleteOrderById(id);
	}
}
