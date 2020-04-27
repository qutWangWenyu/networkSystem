package com.controller.admin;

import java.io.File;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.AuserDao;
import com.po.Auser;
import com.po.BuserAndOrderBaseTable;
import com.po.Goods;
import com.po.GoodsTable;
import com.po.GoodsType;
import com.service.admin.AddTypeService;
import com.service.admin.AuserService;
import com.service.admin.BuserAndOrderBaseService;
import com.service.admin.CartTableService;
import com.service.admin.DeleteTypeService;
import com.service.admin.FocusTableService;
import com.service.admin.GoodsTableService;
import com.service.admin.GoodsTypeService;
import com.service.admin.OrderDetailService;
import com.util.MyUtil;

@Controller
public class AdminController {
	@Autowired
	private AuserService auser;
	@Autowired
	private GoodsTypeService goodsType;

	@RequestMapping("/admin/login")
	public String Login(@ModelAttribute Auser u, Model model, HttpSession session) {
		List<GoodsType> list = goodsType.selectGoodsType();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + "/" + list.get(i).getTypename());
		}
		Auser oneAdmin = auser.selectAuserByAname(u.getAname());
		if (oneAdmin.getAname() != null && oneAdmin.getApwd() != null) {
			if (oneAdmin.getApwd().equals(u.getApwd())) {
				model.addAttribute("auser", oneAdmin);
				model.addAttribute("goodsTypes", list);
				return "/admin/main";
			}
		}
		return "/admin/login";
	}

	@RequestMapping("/admin")
	public String toAdmin(@ModelAttribute Auser auser) {
		return "/admin/login";
	}

	@RequestMapping("/exit")
	public String exit(@ModelAttribute("auser") Auser auser) {
		return "/admin/login";
	}

}
