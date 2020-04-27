package com.service.admin;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteTypeService {
	public int deleteTypeById(int id);
}
