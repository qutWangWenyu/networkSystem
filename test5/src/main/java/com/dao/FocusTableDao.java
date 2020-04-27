package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.FocusTable;

@Repository
@Mapper
public interface FocusTableDao {
	public List<FocusTable> selectFocusTableByGoodsTableId(int goodstable_id);

	public int focus(HashMap map);

	public List<FocusTable> isFocus(HashMap map);

}
