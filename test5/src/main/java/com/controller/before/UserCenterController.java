package com.controller.before;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.OrderDetailDao;
import com.po.Goods2;
import com.po.OrderBaseTable;
import com.util.MyUtil;

@Controller
public class UserCenterController {
	@Autowired
	private OrderDetailDao orderD;

	@RequestMapping("/userCenter")
	public String userCenter(HttpSession session, Model model) {
		int id = MyUtil.getUserId(session);
		List<OrderBaseTable> myOrder = orderD.myOrder(id);
		model.addAttribute("myOrder", myOrder);
		List<Goods2> myFocus = orderD.myFocus(id);
		model.addAttribute("myFocus", myFocus);
		return "before/userCenter";
	}

	@RequestMapping("/myOrderDetail")
	public String myOrderDetail(HttpServletRequest request, Model model) {
		String sid = request.getParameter("ordersn");
		int ordersn = Integer.valueOf(sid);
		List<Goods2> myOrderDetail = orderD.orderDetail(ordersn);
		model.addAttribute("myOrderDetail", myOrderDetail);
		return "before/userOrderDetail";
	}

}
