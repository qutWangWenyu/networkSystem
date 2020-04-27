package com.controller.before;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Buser;
import com.po.GoodsType;
import com.service.admin.GoodsTypeService;
import com.service.before.BuserService2;

@Controller
public class UserController {
	@Autowired
	private BuserService2 buserService;
	@Autowired
	private GoodsTypeService goodsTable;
	
	/**
	 * 用户注册
	 */
	@RequestMapping("user/register")
	public String register(@ModelAttribute("buser") Buser buser, Model model, HttpSession session,
			HttpServletRequest request, String code) {
		if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("codeError", "验证码错误!");
			System.out.println("失败");
			return "/before/register";
		}
		int n = buserService.register(buser);
		if (n > 0) {
			return "/before/login";
		} else {
			model.addAttribute("codeError", "注册失败");
			return "/before/register";
		}
	}
	
	/**
	 * 跳转到用户登录页面
	 */
	@RequestMapping("user/toLogin")
	public String toLogin(Model model) {
		List<GoodsType> table = goodsTable.selectGoodsType();
		model.addAttribute("goodsType", table);
		return "/before/login";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping("user/login")
	public String login(Buser buser, String code, HttpServletRequest request, Model model, HttpSession session) {
		if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("codeError", "验证码错误");
			return "/before/login";
		}
		Buser ruser = null;
		List<Buser> list = buserService.selectBuserById(buser);
		if (list.size() > 0) {
			ruser = list.get(0);
		}
		if (ruser != null) {
			session.setAttribute("bruser", ruser);
			return "forward:/before";
		} else {
			List<GoodsType> table = goodsTable.selectGoodsType();
			model.addAttribute("goodsType", table);
			model.addAttribute("msg", "用户名或者密码错误");
			return "before/login";
		}
	}

	/**
	 * 用户退出
	 */

}
