package com.controller.before;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Goods2;
import com.po.Goods3;
import com.po.Goods4;
import com.po.GoodsType;
import com.po.NoticeTable;
import com.service.admin.GoodsTypeService;
import com.service.before.indexService;

@Controller
public class IndexController {
	@Autowired
	private indexService indexS;
	@Autowired
	private GoodsTypeService goodsTable;

	/**
	 * 首页
	 */
	@RequestMapping("/before")
	public String toLoginEle(Model model) {
		List<Goods2> salelist = indexS.getSaleOrder();
		model.addAttribute("salelist", salelist.subList(0, 5));
		List<Goods3> focuslist = indexS.getFocusOrder();
		model.addAttribute("focuslist", focuslist.subList(0, 5));
		List<NoticeTable> noticelist = indexS.selectNotice();
		model.addAttribute("noticelist", noticelist.subList(0, noticelist.size()));
		List<Goods4> lastedlist = indexS.getLastedGoods();
		model.addAttribute("lastedlist", lastedlist.subList(0, 5));
		List<GoodsType> table = goodsTable.selectGoodsType();
		model.addAttribute("goodsType", table);
		return "before/index";
	}

	/**
	 * 首页搜索
	 */
	@RequestMapping("/search")
	public String search(Model model, HttpServletRequest request) {
		String mykey = request.getParameter("mykey");
		model.addAttribute("searchlist", indexS.search(mykey));
		return "/before/searchResult";
	}

	/**
	 * 转到注册页面
	 */
	@RequestMapping("/toRegister")
	public String toRegister(Model model) {
		List<GoodsType> table = goodsTable.selectGoodsType();
		model.addAttribute("goodsType", table);
		return "/before/register";
	}

	/**
	 * 转到商品详情页
	 */
	@RequestMapping("/goodsDetail")
	public String goodsDetailWeb(HttpServletRequest request, Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		Goods4 goods = indexS.selectGoods4ById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}

}
