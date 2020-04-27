package com.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.po.GoodsType;
import com.service.admin.AddTypeService;
import com.service.admin.DeleteTypeService;
import com.service.admin.GoodsTypeService;

@Controller
public class AdminTypeController {
	@Autowired
	private AddTypeService addType;
	@Autowired
	private GoodsTypeService goodsType;
	@Autowired
	private DeleteTypeService deleteType;

	/**
	 * 到添加类型页面
	 */
	@RequestMapping("/adminType/toAddType")
	public String addminType(Model model) {
		List<GoodsType> list = goodsType.selectGoodsType();
		model.addAttribute("allTypes", list);
		return "admin/addTypes";
	}

	/**
	 * 添加类型
	 */
	@RequestMapping("/adminType/addType")
	public String addType(@RequestParam String typename, HttpServletRequest request, Model model) {
		addType.AddType(typename);
		System.out.println(typename);
		List<GoodsType> list = goodsType.selectGoodsType();
		model.addAttribute("allTypes", list);
		return "/admin/addTypes";
	}

	/**
	 * 到删除类型页面
	 */
	@RequestMapping("/adminType/toDeleteType")
	public String deleteTypes(Model model) {
		List<GoodsType> list = goodsType.selectGoodsType();
		model.addAttribute("allTypes", list);
		return "/admin/deleteType";
	}

	/**
	 * 删除类型
	 */
	@RequestMapping("/deleteType")
	public String deleteType(@RequestParam String id, HttpServletRequest request, Model model) {
		int ids = Integer.valueOf(id);
		deleteType.deleteTypeById(ids);
		List<GoodsType> list = goodsType.selectGoodsType();
		model.addAttribute("allTypes", list);
		return "/admin/deleteType";
	}
}
