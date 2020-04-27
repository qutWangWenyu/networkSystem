package com.service.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.NoticeTable;

@Repository
public interface NoticeTableService {

	public List<NoticeTable> selectNotice();

	public int insertNoticeTable(NoticeTable notice);

	public int deleteNoticeById(int id);

	public NoticeTable selectANoticeTable(int id);
}
