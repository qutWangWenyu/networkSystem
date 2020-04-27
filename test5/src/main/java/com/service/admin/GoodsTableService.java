package com.service.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.Goods;
import com.po.GoodsTable;

@Repository
public interface GoodsTableService {

	public List<GoodsTable> selectGoodsTable();
	public GoodsTable selectGoodsTableByID(int id);
	public int insertIntoGoodsTable(Goods goods);
	public int updateGoodsById(Goods goods);
	public int deleteGoodsById(int id);
	
}
