package com.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NoticeTableDao;
import com.po.NoticeTable;

@Service
public class NoticeTableServiceImpl implements NoticeTableService {

	@Autowired
	private NoticeTableDao noticeTable;

	@Override
	public List<NoticeTable> selectNotice() {
		return noticeTable.selectNotice();
	}

	@Override
	public int insertNoticeTable(NoticeTable notice) {
		return noticeTable.insertNoticeTable(notice);
	}

	@Override
	public int deleteNoticeById(int id) {
		return noticeTable.deleteNoticeById(id);
	}

	@Override
	public NoticeTable selectANoticeTable(int id) {
		return noticeTable.selectANoticeTable(id);
	}

}
