package com.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Buser;

@Repository
@Mapper
public interface BuserTableDao {
	public int deleteBuserById(int id);

	public int register(Buser buser);

	public List<Buser> selectBuserById(Buser buser);
	
	public List<Buser> selectBuser();
}
