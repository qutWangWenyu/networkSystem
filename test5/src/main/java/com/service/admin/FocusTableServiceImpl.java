package com.service.admin;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FocusTableDao;
import com.po.FocusTable;

@Service
public class FocusTableServiceImpl implements FocusTableService {

	@Autowired
	private FocusTableDao focusTable;

	@Override
	public List<FocusTable> selectFocusTableByGoodsTableId(int goodstable_id)
	{
		
		return focusTable.selectFocusTableByGoodsTableId(goodstable_id);
	}
	

}
