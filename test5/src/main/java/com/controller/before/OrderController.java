package com.controller.before;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CartTableDao;
import com.dao.OrderDetailDao;
import com.po.CartResult;
import com.po.CartTable;
import com.po.OrderBaseTable;
import com.service.before.BuserService2;
import com.util.MyUtil;

@Controller
public class OrderController {
	@Autowired
	private OrderDetailDao orderD;
	@Autowired
	private CartTableDao cartT;
	@Autowired
	private BuserService2 buserService;

	/**
	 * 去结算
	 */
	@RequestMapping("cart/orderConfirm")
	public String OrderConfirm(Model model, HttpSession session) {
		int id = MyUtil.getUserId(session);
		List<CartResult> cartlist = buserService.selectCart(id);
		double sum = 0;
		for (CartResult l : cartlist) {
			sum = sum + l.getSmallsum();
		}
		model.addAttribute("cartlist", cartlist);
		model.addAttribute("total", sum);
		return "before/orderconfirm";
	}

	/**
	 * 提交订单
	 */
	@RequestMapping("order/orderSubmit")
	public String orderSubmit(Model model, HttpSession session, HttpServletRequest request) {
		int amount = Integer.valueOf(request.getParameter("amount"));
		session.setAttribute("amountxxx", amount);
		OrderBaseTable order = new OrderBaseTable();
		order.setAmount(amount);
		order.setBusertable_id(MyUtil.getUserId(session));
		order.setStatus(0);
		//生成订单，并将主键返回order
		orderD.addOrder(order);// 插入orderbasetable
		System.out.println("插入orderbasetable成功");
		int id = order.getId();
		List<CartTable> list = cartT.selectCartTable(MyUtil.getUserId(session));// 获取到goodstable_id//获取到shoppingnum
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("orderbasetable_id", id);
//		for (int i = 0; i < list.size(); i++) {
//			map.put("goodstable_id", list.get(i).getGoodstable_id());
//			map.put("shoppingnum", list.get(i).getShoppingnum());
//			orderD.addOrderDetail(map);
//			System.out.println("插入orderdetail成功");
//			map.put("gid", list.get(i).getGoodstable_id());
//			orderD.updateStore(map); // 更新goodstable表的商品库存
//			System.out.println("更新goodstable成功");
//		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ordersn", id);
		map.put("uid", MyUtil.getUserId(session));
		orderD.addOrderDetail(map);
		System.out.println("插入OrderDetail成功");
		for(int i = 0; i < list.size(); i++)
		{
			map.put("gid", list.get(i).getGoodstable_id());
			map.put("shoppingnum", list.get(i).getShoppingnum());
			orderD.updateStore(map); 
		}
		System.out.println("更新库存成功");
		session.setAttribute("ordersn", id);
//		
//		System.out.println("开始清除"); cartT.clear(MyUtil.getUserId(session));
//		System.out.println("清除成功"); model.addAttribute("ordersn", id);
//		System.out.println("成功"); return "before/orderdone";
//		
		return "alipay/index";
	}

	/**
	 * 支付宝支付订单
	 */
	@RequestMapping("/alipaydone")
	public String alipay(HttpSession session) {
		cartT.clear(MyUtil.getUserId(session));
		return "alipay/alipay.trade.page.pay";
	}
	
	/**
	 * 支付订单
	 */
	@RequestMapping("/returnxxx")
	public String payDone(HttpSession session) {
		int id =  (int) session.getAttribute("ordersn");
		orderD.pay(id);
		return "before/paydone";
	}

}
