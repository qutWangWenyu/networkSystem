package com.controller.admin;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.BuserTableDao;
import com.po.Buser;
import com.service.admin.BuserService;

@Controller
public class AdminUserController {
	
	@Autowired
	private BuserService buserService;
 
	@Autowired
	private BuserTableDao btd;
	@RequestMapping("/adminUser/userInfo")
	public String delBuser(Model model) {
		List<Buser> userList = btd.selectBuser();
		model.addAttribute("userList", userList);
		return "/admin/userManager";
	}

	@RequestMapping("/adminUser/deleteuserManager")
	public String deleteBuser(Model model, HttpServletRequest request) {
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		buserService.deleteBuserById(id);
		List<Buser> userList = buserService.selectBuser();
		model.addAttribute("userList", userList);
		return "/admin/userManager";
	}
}
