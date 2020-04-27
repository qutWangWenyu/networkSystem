package com.service.before;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FocusTableDao;
import com.dao.GoodsTableDao;
import com.po.FocusTable;
import com.po.Goods;
import com.po.Goods2;
import com.po.Goods3;
import com.po.Goods4;
import com.po.NoticeTable;

@Service
public class indexServiceImpl implements indexService {

	@Autowired
	GoodsTableDao goodsTable;
	@Autowired
	private FocusTableDao focusTable;

	@Override
	public List<Goods2> getSaleOrder() {
		return goodsTable.getSaleOrder();
	}

	@Override
	public List<Goods3> getFocusOrder() {
		return goodsTable.getFocusOrder();
	}

	@Override
	public List<NoticeTable> selectNotice() {
		return goodsTable.selectNotice();
	}

	@Override
	public List<Goods4> getLastedGoods() {
		return goodsTable.getLastedGoods();
	}

	@Override
	public List<Goods4> search(String mykey) {
		return goodsTable.search(mykey);
	}

	@Override
	public Goods4 selectGoods4ById(int id) {
		return goodsTable.selectGoods4ById(id);
	}

	@Override
	public int focus(HashMap map) {
		return focusTable.focus(map);
	}

	@Override
	public List<FocusTable> isFocus(HashMap map) {
		return focusTable.isFocus(map);
	}

}
