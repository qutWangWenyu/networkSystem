package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.BuserAndOrderBaseTable;
@Repository
@Mapper
public interface BuserAndOrderDao {
	public List<BuserAndOrderBaseTable> selectBuserAndOrderBaseById();
	public int deleteOrderById(int id);
}
