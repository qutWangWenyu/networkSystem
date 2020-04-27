package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDetailDao;
import com.po.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao goodsDetail;
	@Override
	public List<OrderDetail> selectOrderDetailByGoodsTableId(int goodstable_id) {
		return goodsDetail.selectOrderDetailByGoodsTableId(goodstable_id);
	}

}
