package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Auser;

@Repository
@Mapper
public interface AuserDao {
	public Auser selectAuserByAname(String aname);
}
