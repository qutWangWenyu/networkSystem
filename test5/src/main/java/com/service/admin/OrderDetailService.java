package com.service.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.OrderDetail;

@Repository
public interface OrderDetailService {
	public List<OrderDetail> selectOrderDetailByGoodsTableId(int goodstable_id);
}
