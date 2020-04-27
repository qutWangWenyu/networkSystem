package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Goods;
import com.po.Goods2;
import com.po.Goods3;
import com.po.Goods4;
import com.po.GoodsTable;
import com.po.NoticeTable;

@Repository
@Mapper
public interface GoodsTableDao {
	public List<GoodsTable> selectGoodsTable();

	public GoodsTable selectGoodsTableByID(int id);

	public int insertIntoGoodsTable(Goods goods);

	public int updateGoodsById(Goods goods);

	public int deleteGoodsById(int id);

	public List<Goods2> getSaleOrder();

	public List<Goods3> getFocusOrder();

	public List<Goods4> getLastedGoods();

	public List<Goods4> search(String mykey);

	public Goods4 selectGoods4ById(int id);

	public List<NoticeTable> selectNotice();
}
