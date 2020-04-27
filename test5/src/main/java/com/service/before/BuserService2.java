package com.service.before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Buser;
import com.po.CartResult;
import com.po.CartTable;

@Repository
@Mapper
public interface BuserService2 {
	public int register(Buser buser);

	public List<Buser> selectBuserById(Buser buser);

	public List<CartResult> selectCart(int id);

	public List<CartTable> isPutCart(Map<String, Object> map);

	public int putCart(CartTable cartTable);

	public int updateCart(Map<String, Object> map);

	public int deleteAgoods(Map<String, Object> map);

	public int clear(int id);
}
