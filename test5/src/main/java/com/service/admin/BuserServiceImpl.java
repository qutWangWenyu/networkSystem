package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BuserTableDao;
import com.po.Buser;

@Service
public class BuserServiceImpl implements BuserService {

	@Autowired
	private BuserTableDao buserT;
	@Override
	public List<Buser> selectBuser(){

		return buserT.selectBuser();
	}
	@Override
	public int deleteBuserById(int id) {
		return buserT.deleteBuserById(id);
	}

}
