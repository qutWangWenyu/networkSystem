package com.service.before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BuserTableDao;
import com.dao.CartTableDao;
import com.po.Buser;
import com.po.CartResult;
import com.po.CartTable;
import com.service.before.BuserService2;

@Service
public class BuserServiceImpl2 implements BuserService2 {

	@Autowired
	private CartTableDao cartTables;
	@Autowired
	private BuserTableDao buserTable;

	@Override
	public int register(Buser buser) {
		return buserTable.register(buser);
	}

	@Override
	public List<Buser> selectBuserById(Buser buser) {
		return buserTable.selectBuserById(buser);
	}

	@Override
	public List<CartResult> selectCart(int id) {
		return cartTables.selectCart(id);
	}

	@Override
	public List<CartTable> isPutCart(Map map) {
		return cartTables.isPutCart(map);
	}

	@Override
	public int putCart(CartTable cartTable) {
		return cartTables.putCart(cartTable);
	}

	@Override
	public int updateCart(Map map) {
		return cartTables.updateCart(map);
	}

	@Override
	public int deleteAgoods(Map map) {
		return cartTables.deleteAgoods(map);
	}

	@Override
	public int clear(int id) {
		return cartTables.clear(id);
	}
}
