package com.service.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.FocusTable;

@Repository
public interface FocusTableService {
	public List<FocusTable> selectFocusTableByGoodsTableId(int goodstable_id);

}
