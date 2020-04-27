package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.GoodsType;

@Repository
@Mapper
public interface GoodsTypeDao {
	public List<GoodsType> selectGoodsType();
	public GoodsType selectGoodsTypeById(int id);
}
