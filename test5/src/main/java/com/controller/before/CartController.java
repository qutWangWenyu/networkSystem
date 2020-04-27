package com.controller.before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.CartResult;
import com.po.CartTable;
import com.po.FocusTable;
import com.po.Goods4;
import com.po.GoodsType;
import com.service.admin.GoodsTypeService;
import com.service.before.BuserService2;
import com.service.before.indexService;
import com.util.MyUtil;

@Controller
public class CartController {
	@Autowired
	private indexService indexS;
	@Autowired
	private GoodsTypeService goodsTable;
	@Autowired
	private BuserService2 buserService;

	/**
	 * 关注商品
	 */
	@RequestMapping("cart/focus")
	public String fucous(Model model, HttpSession session, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uid", MyUtil.getUserId(session));
		map.put("gid", id);
		List<FocusTable> list = indexS.isFocus(map);
		if (list.size() > 0) {
			model.addAttribute("msg", "已关注此商品");
			System.out.println("已关注这个商品");
		} else {
			int n = indexS.focus(map);
			if (n > 0) {
				model.addAttribute("msg", "已经成功关注");
			} else {
				model.addAttribute("msg", "关注失败");
			}
		}
		Goods4 goods = indexS.selectGoods4ById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}

	/**
	 * 查询购物车
	 */
	@RequestMapping("select/putCart")
	public String selectCart(Model model, HttpSession session) {
		int id = MyUtil.getUserId(session);
		List<CartResult> cartlist = buserService.selectCart(id);
		model.addAttribute("cartlist", cartlist);
		List<GoodsType> table = goodsTable.selectGoodsType();
		int totalValue = 0;
		for (int i = 0; i < cartlist.size(); i++) {
			totalValue += cartlist.get(i).getGrprice() * cartlist.get(i).getShoppingnum();
		}
		model.addAttribute("total", totalValue);
		model.addAttribute("goodsType", table);
		return "before/cart";
	}

	/**
	 * 添加购物车
	 */
	@RequestMapping("/putCart")
	public String putCart(Model model, HttpSession session, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		int shoppingnum = Integer.valueOf(request.getParameter("shoppingnum"));
		Map<String, Object> map = new HashMap<String, Object>();
		int uid = MyUtil.getUserId(session);
		map.put("uid", MyUtil.getUserId(session));
		map.put("gid", id);
		map.put("shoppingnum", shoppingnum);
		if (buserService.isPutCart(map).size() > 0) {
			buserService.updateCart(map);
		} else {
			CartTable ct = new CartTable();
			ct.setBusertable_id(uid);
			ct.setGoodstable_id(id);
			ct.setShoppingnum(shoppingnum);
			buserService.putCart(ct);
		}
		return "forward:select/putCart";
	}

	/**
	 * 删除购物车
	 */
	@RequestMapping("cart/deleteAgoods")
	public String deleteAgoods(HttpServletRequest request, HttpSession session) {
		int id = Integer.valueOf(request.getParameter("id"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gid", id);
		map.put("uid", MyUtil.getUserId(session));
		buserService.deleteAgoods(map);
		return "forward:/select/putCart";
	}

	/**
	 * 清空购物车
	 */
	@RequestMapping("cart/clear")
	public String clear(HttpSession session) {
		buserService.clear(MyUtil.getUserId(session));
		return "forward:/select/putCart";
	}

}
