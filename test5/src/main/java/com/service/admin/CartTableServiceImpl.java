package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartTableDao;
import com.po.CartTable;

@Service
public class CartTableServiceImpl implements CartTableService {

	@Autowired
	private CartTableDao cartTable;
	@Override
	public List<CartTable> selectCartGoodsById(int goodstable_id) {
		return cartTable.selectCartGoodsById(goodstable_id);
	}

}
