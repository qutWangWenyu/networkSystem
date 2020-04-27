package com.service.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.po.Buser;

@Repository
public interface BuserService {
	public List<Buser> selectBuser();

	public int deleteBuserById(int id);
}
