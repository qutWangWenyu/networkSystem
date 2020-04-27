package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DeleteTypeDao;

@Service
public class DeleteTypeServiceImpl implements DeleteTypeService {

	@Autowired
	private DeleteTypeDao deleteType;
	@Override
	public int deleteTypeById(int id) {
		deleteType.deleteTypeById(id);
		return 0;
	}

}
