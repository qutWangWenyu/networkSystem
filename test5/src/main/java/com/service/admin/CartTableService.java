package com.service.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.CartTable;

@Repository
public interface CartTableService {
	public List<CartTable> selectCartGoodsById(int goodstable_id);

}
