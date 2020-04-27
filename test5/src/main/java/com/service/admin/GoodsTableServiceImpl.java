package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsTableDao;
import com.po.Goods;
import com.po.GoodsTable;

@Service
public class GoodsTableServiceImpl implements GoodsTableService {
	@Autowired
	private GoodsTableDao goodsTable;

	@Override
	public List<GoodsTable> selectGoodsTable() {
		return goodsTable.selectGoodsTable();
	}

	@Override
	public GoodsTable selectGoodsTableByID(int id) {
		return goodsTable.selectGoodsTableByID(id);
	}

	@Override
	public int insertIntoGoodsTable(Goods goods) {
		return goodsTable.insertIntoGoodsTable(goods);
	}

	@Override
	public int updateGoodsById(Goods goods) {
		return goodsTable.updateGoodsById(goods);
	}

	@Override
	public int deleteGoodsById(int id) {
		return goodsTable.deleteGoodsById(id);
	}

}
