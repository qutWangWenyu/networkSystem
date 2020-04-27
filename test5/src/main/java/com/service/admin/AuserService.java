package com.service.admin;

import org.springframework.stereotype.Repository;
import com.dao.AuserDao;
import com.po.Auser;
@Repository
public interface AuserService {
	public Auser selectAuserByAname(String aname);
}
