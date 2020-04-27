package com.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.BuserAndOrderBaseTable;
import com.service.admin.BuserAndOrderBaseService;

@Controller
public class AdminOrderController {
	@Autowired
	private BuserAndOrderBaseService buserAndOrder;

	@RequestMapping("/adminOrder/orderInfo")
	public String delOrder(Model model) {
		List<BuserAndOrderBaseTable> orderList = buserAndOrder.selectBuserAndOrderBaseById();
		model.addAttribute("orderList", orderList);
		return "/admin/orderManager";
	}

	@RequestMapping("/adminOrder/deleteorderManager")
	public String deleteOrder(HttpServletRequest request, Model model) {
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		buserAndOrder.deleteOrderById(id);
		List<BuserAndOrderBaseTable> orderList = buserAndOrder.selectBuserAndOrderBaseById();
		model.addAttribute("orderList", orderList);
		return "/admin/orderManager";
	}
}
