package com.service.before;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.FocusTable;
import com.po.Goods;
import com.po.Goods2;
import com.po.Goods3;
import com.po.Goods4;
import com.po.NoticeTable;

@Repository
@Mapper
public interface indexService {
	public List<Goods2> getSaleOrder();

	public List<Goods3> getFocusOrder();

	public List<NoticeTable> selectNotice();

	public List<Goods4> getLastedGoods();

	public List<Goods4> search(String mykey);

	public Goods4 selectGoods4ById(int id);

	public int focus(HashMap map);

	public List<FocusTable> isFocus(HashMap map);
}
