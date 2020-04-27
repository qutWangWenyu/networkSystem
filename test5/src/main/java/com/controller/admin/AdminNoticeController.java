package com.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.NoticeTable;
import com.service.admin.NoticeTableService;

@Controller
public class AdminNoticeController {
	@Autowired
	private NoticeTableService noticeTable;

	@RequestMapping("/adminNotice/deleteNoticeSelect")
	public String manageNotice(Model model) {
		List<NoticeTable> allNotices = noticeTable.selectNotice();
		model.addAttribute("allNotices", allNotices);
		return "/admin/deleteNoticeSelect";
	}

	@RequestMapping("/adminNotice/toAddNotice")
	public String toAddNotice(@ModelAttribute("notice") NoticeTable notice, Model model) {
		return "/admin/addNotice";
	}

	@RequestMapping("/adminNotice/addNotice")
	public String addNotice(@ModelAttribute("notice") NoticeTable notice) {
		System.out.println(notice.getNtitle() + " " + notice.getNcontent());
		noticeTable.insertNoticeTable(notice);
		return "/admin/addNotice";
	}

	@RequestMapping("/adminNotice/deleteNotice")
	public String deleteANotice(HttpServletRequest request, Model model) {
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		noticeTable.deleteNoticeById(id);
		List<NoticeTable> allNotices = noticeTable.selectNotice();
		model.addAttribute("allNotices", allNotices);
		return "/admin/deleteNoticeSelect";
	}

	@RequestMapping("/adminNotice/selectANotice")
	public String selectANotice(HttpServletRequest request, Model model) {
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		NoticeTable notice = noticeTable.selectANoticeTable(id);
		model.addAttribute("notice", notice);
		return "/admin/noticeDetail";
	}
}
