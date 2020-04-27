package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.GoodsType;

@Repository
@Mapper
public interface AddTypeDao {
   public int AddType(String typename);
}
