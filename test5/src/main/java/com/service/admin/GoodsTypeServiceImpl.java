package com.service.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsTypeDao;
import com.po.Auser;
import com.po.GoodsTable;
import com.po.GoodsType;
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	
	@Autowired
	private GoodsTypeDao goodsType;
	@Override
	public List<GoodsType> selectGoodsType() {
		return goodsType.selectGoodsType();
	}
	@Override
	public GoodsType selectGoodsTypeById(int id) {
		return goodsType.selectGoodsTypeById(id);
	}
}
