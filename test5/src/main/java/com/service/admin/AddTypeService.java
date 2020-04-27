package com.service.admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.GoodsType;

@Repository
public interface AddTypeService {
	public int AddType(String typename);
}
