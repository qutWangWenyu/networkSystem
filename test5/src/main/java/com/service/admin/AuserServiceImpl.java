package com.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AuserDao;
import com.po.Auser;

@Service
public class AuserServiceImpl implements AuserService {

	@Autowired
	private AuserDao auser;
	@Override
	public Auser selectAuserByAname(String aname) {
		return auser.selectAuserByAname(aname);
	}

}
