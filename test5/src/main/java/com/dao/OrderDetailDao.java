package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Goods2;
import com.po.OrderBaseTable;
import com.po.OrderDetail;

@Repository
@Mapper
public interface OrderDetailDao {
	public List<OrderDetail> selectOrderDetailByGoodsTableId(int goodstable_id);

	public int addOrder(OrderBaseTable order);

	public int addOrderDetail(HashMap map);

	public int updateStore(HashMap umap);

	public int pay(int id);

	public List<OrderBaseTable> myOrder(int id);

	public List<Goods2> myFocus(int id);

	public List<Goods2> orderDetail(int ordersn);
}
