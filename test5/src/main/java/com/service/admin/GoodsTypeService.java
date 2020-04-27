package com.service.admin;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.po.GoodsTable;
import com.po.GoodsType;
@Repository
public interface GoodsTypeService {
	public List<GoodsType> selectGoodsType();
	public GoodsType selectGoodsTypeById(int id);
}
