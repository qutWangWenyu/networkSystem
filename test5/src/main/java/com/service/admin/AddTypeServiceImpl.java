package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AddTypeDao;
import com.dao.GoodsTypeDao;
import com.po.GoodsType;

@Service
public class AddTypeServiceImpl implements AddTypeService {

	@Autowired
	private AddTypeDao addType;

	@Override
	public int AddType(String typename) {
		return addType.AddType(typename);
	}

}
