package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.CartResult;
import com.po.CartTable;

@Repository
@Mapper
public interface CartTableDao {
	public List<CartTable> selectCartGoodsById(int goodstable_id);

	public List<CartResult> selectCart(int id);

	public List<CartTable> isPutCart(Map map);

	public int putCart(CartTable cartTable);

	public int updateCart(Map map);

	public int deleteAgoods(Map map);

	public int clear(int id);

	public List<CartTable> selectCartTable(int id);

}
