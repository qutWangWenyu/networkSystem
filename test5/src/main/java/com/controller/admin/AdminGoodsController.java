package com.controller.admin;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.po.Goods;
import com.po.GoodsTable;
import com.po.GoodsType;
import com.service.admin.CartTableService;
import com.service.admin.FocusTableService;
import com.service.admin.GoodsTableService;
import com.service.admin.GoodsTypeService;
import com.service.admin.OrderDetailService;
import com.util.MyUtil;

@Controller
public class AdminGoodsController {

	@Autowired
	private GoodsTypeService goodsType;
	@Autowired
	private GoodsTableService goodsTable;
	@Autowired
	private CartTableService cartTable;
	@Autowired
	private OrderDetailService ordersDetail;
	@Autowired
	private FocusTableService focusTable;

	/**
	 * add页面初始化
	 */
	@RequestMapping("/adminGoods/toAddGoods")
	public String toAddGood(Model model) {
		List<GoodsType> goodstype = goodsType.selectGoodsType();
		model.addAttribute("goodsType", goodstype);
		model.addAttribute("goods", new Goods());
		return "admin/AddGoods";
	}

	/**
	 * 添加商品
	 */
	@RequestMapping("/adminGoods/AddGoods")
	public String addAGood(@ModelAttribute("goods") Goods goods, HttpServletRequest request, Model model) {
		String newFileName = "";
		String fileName = goods.getLogoImage().getOriginalFilename();
		if (fileName.length() > 0) {
			String realPath = request.getServletContext().getRealPath("/logos");
			String fileType = fileName.substring(fileName.lastIndexOf('.'));
			newFileName = MyUtil.getStringID() + fileType;
			goods.setGpicture(newFileName);
			System.out.println(newFileName);//
			File targetFile = new File(realPath, newFileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				goods.getLogoImage().transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(realPath);//
			goodsTable.insertIntoGoodsTable(goods);
		}
		List<GoodsType> goodstype = goodsType.selectGoodsType();
		model.addAttribute("goodsType", goodstype);
		return "/admin/AddGoods";
	}

	/**
	 * 删除商品
	 */
	@RequestMapping("/adminGoods/deleteGoods")
	public String deleteGoods(Model model) {
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		int page = 1;
		int totalCount = list.size();
		model.addAttribute("totalCount", totalCount);
		if (totalCount % 3 == 0) {
			int pageCount = totalCount / 3;
			model.addAttribute("totalPage", pageCount);
		} else {
			int pageCount = totalCount / 3 + 1;
			model.addAttribute("totalPage", pageCount);
		}
		List<GoodsTable> res = null;
		res = list.subList(0, 3);
		model.addAttribute("allGoods", res);
		model.addAttribute("pageCur", page);
		return "/admin/deleteSelectGoods";
	}

	@RequestMapping("/adminGoods/deleteNextGoods")
	public String deleteNextGoods(Model model, HttpServletRequest request) {
		String pageCur = request.getParameter("pageCur");
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		if (pageCur == null) {
			int page = 1;
			int totalCount = list.size();
			model.addAttribute("totalCount", totalCount);
			if (totalCount % 3 == 0) {
				int pageCount = totalCount / 3;
				model.addAttribute("totalPage", pageCount);
			} else {
				int pageCount = totalCount / 3 + 1;
				model.addAttribute("totalPage", pageCount);
			}
			List<GoodsTable> res = null;
			res = list.subList(3 * (page - 1), 3 * (page - 1) + 3);
			model.addAttribute("allGoods", res);
			model.addAttribute("pageCur", page);
		} else {
			String s = pageCur.toString();
			int page = Integer.valueOf(s);
			System.out.println(page);
			int totalCount = list.size();
			model.addAttribute("totalCount", totalCount);
			int pageCount;
			if (totalCount % 3 == 0) {
				pageCount = totalCount / 3;
				model.addAttribute("totalPage", pageCount);
			} else {
				pageCount = totalCount / 3 + 1;
				model.addAttribute("totalPage", pageCount);
			}
			List<GoodsTable> res = null;
			if (page == pageCount) {
				res = list.subList(3 * (page - 1), totalCount);
			} else {
				res = list.subList(3 * (page - 1), 3 * (page - 1) + 3);
			}
			model.addAttribute("allGoods", res);
			model.addAttribute("pageCur", page);
		}
		return "/admin/deleteSelectGoods";
	}

	@RequestMapping("/adminGoods/deleteAGoods")
	public String deleleAGoods(HttpServletRequest request, Model model) {
		String s = request.getParameter("id");
		int id = Integer.valueOf(s);
		goodsTable.deleteGoodsById(id);
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		int page = 1;
		int totalCount = list.size();
		model.addAttribute("totalCount", totalCount);
		if (totalCount % 3 == 0) {
			int pageCount = totalCount / 3;
			model.addAttribute("totalPage", pageCount);
		} else {
			int pageCount = totalCount / 3 + 1;
			model.addAttribute("totalPage", pageCount);
		}
		List<GoodsTable> res = null;
		res = list.subList(0, 3);
		model.addAttribute("allGoods", res);
		model.addAttribute("pageCur", page);
		return "/admin/deleteSelectGoods";
	}

	@RequestMapping("/adminGoods/changeDeleteAGoods")
	public String changeDeleleAGoods(HttpServletRequest request, Model model) {
		String pageCur = request.getParameter("pageCur");
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		if (pageCur == null) {
			int page = 1;
			int totalCount = list.size();
			model.addAttribute("totalCount", totalCount);
			if (totalCount % 3 == 0) {
				int pageCount = totalCount / 3;
				model.addAttribute("totalPage", pageCount);
			} else {
				int pageCount = totalCount / 3 + 1;
				model.addAttribute("totalPage", pageCount);
			}
			List<GoodsTable> res = null;
			res = list.subList(3 * (page - 1), 3 * (page - 1) + 3);
			model.addAttribute("allGoods", res);
			model.addAttribute("pageCur", page);
		} else {
			String s = pageCur.toString();
			int page = Integer.valueOf(s);
			System.out.println(page);
			int totalCount = list.size();
			model.addAttribute("totalCount", totalCount);
			int pageCount;
			if (totalCount % 3 == 0) {
				pageCount = totalCount / 3;
				model.addAttribute("totalPage", pageCount);
			} else {
				pageCount = totalCount / 3 + 1;
				model.addAttribute("totalPage", pageCount);
			}
			List<GoodsTable> res = null;
			if (page == pageCount) {
				res = list.subList(3 * (page - 1), totalCount);
			} else {
				res = list.subList(3 * (page - 1), 3 * (page - 1) + 3);
			}
			model.addAttribute("allGoods", res);
			model.addAttribute("pageCur", page);
		}
		return "/admin/deleteSelectGoods";
	}

	@RequestMapping("/adminGoods/deleteManyGoods")
	public String deleteManyGoods(HttpServletRequest request, Model model) {
		String ids = request.getParameter("ids");
		String q[] = ids.split("NaN");
		for (int i = 0; i < q.length; i++) {
			int goodstable_id = Integer.valueOf(q[i]);
			int x = cartTable.selectCartGoodsById(goodstable_id).size();
			int y = focusTable.selectFocusTableByGoodsTableId(goodstable_id).size();
			int z = ordersDetail.selectOrderDetailByGoodsTableId(goodstable_id).size();

			if (x > 0 || y > 0 || z > 0) {
				model.addAttribute("error", goodstable_id + "不能删除");
			} else {
				goodsTable.deleteGoodsById(goodstable_id);
				model.addAttribute("succ", "删除成功");
			}
		}
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		int page = 1;
		int totalCount = list.size();
		model.addAttribute("totalCount", totalCount);
		if (totalCount % 3 == 0) {
			int pageCount = totalCount / 3;
			model.addAttribute("totalPage", pageCount);
		} else {
			int pageCount = totalCount / 3 + 1;
			model.addAttribute("totalPage", pageCount);
		}
		List<GoodsTable> res = null;
		res = list.subList(0, 3);
		model.addAttribute("allGoods", res);
		model.addAttribute("pageCur", page);
		return "/admin/deleteSelectGoods";
	}

	/**
	 * 修改商品
	 */
	@RequestMapping("/adminGoods/updateAGoods")
	public String updateGoods(Model model, HttpServletRequest request) {
		String i = request.getParameter("id");
		int id = Integer.valueOf(i);
		GoodsTable goods = goodsTable.selectGoodsTableByID(id);
		System.out.println();
		goods.setId(id);
		model.addAttribute("goods", goods);
		List<GoodsType> goodstype = goodsType.selectGoodsType();
		model.addAttribute("goodsType", goodstype);
		return "/admin/updateAGoods";
	}

	@RequestMapping("/adminGoods/upGoods")
	public String updatew(Model model) {
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		int page = 1;
		int totalCount = list.size();
		model.addAttribute("totalCount", totalCount);
		if (totalCount % 3 == 0) {
			int pageCount = totalCount / 3;
			model.addAttribute("totalPage", pageCount);
		} else {
			int pageCount = totalCount / 3 + 1;
			model.addAttribute("totalPage", pageCount);
		}
		List<GoodsTable> res = null;
		res = list.subList(0, 3);
		model.addAttribute("allGoods", res);
		model.addAttribute("pageCur", page);
		return "/admin/updateGoods";
	}

	@RequestMapping("/adminGoods/updateAgood")
	public String update(@ModelAttribute("goods") Goods goods, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		goods.setId(id);
		System.out.println(goods.toString());
		MultipartFile file = goods.getLogoImage();

		if (!file.isEmpty()) {
			String newFileName = "";
			String fileName = goods.getLogoImage().getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf('.'));
			newFileName = MyUtil.getStringID() + fileType;
			goods.setGpicture(newFileName);
		}
		System.out.println("这里");
		goodsTable.updateGoodsById(goods);
		return "/admin/main";
	}

	/**
	 * 查询商品
	 */
	@RequestMapping("/adminGoods/selectGoods")
	public String searchGoods(Model model, HttpServletRequest request) {
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		int page = 1;
		int totalCount = list.size();
		model.addAttribute("totalCount", totalCount);
		if (totalCount % 3 == 0) {
			int pageCount = totalCount / 3;
			model.addAttribute("totalPage", pageCount);
		} else {
			int pageCount = totalCount / 3 + 1;
			model.addAttribute("totalPage", pageCount);
		}
		List<GoodsTable> res = null;
		res = list.subList(0, 3);
		model.addAttribute("allGoods", res);
		model.addAttribute("pageCur", page);
		return "/admin/selectGoods";
	}

	@RequestMapping("/admin/changeSelectGoods")
	public String changeSearchGoods(Model model, HttpServletRequest request) {
		String pageCur = request.getParameter("pageCur");
		List<GoodsTable> list = goodsTable.selectGoodsTable();
		if (pageCur == null) {
			int page = 1;
			int totalCount = list.size();
			model.addAttribute("totalCount", totalCount);
			if (totalCount % 3 == 0) {
				int pageCount = totalCount / 3;
				model.addAttribute("totalPage", pageCount);
			} else {
				int pageCount = totalCount / 3 + 1;
				model.addAttribute("totalPage", pageCount);
			}
			List<GoodsTable> res = null;
			res = list.subList(3 * (page - 1), 3 * (page - 1) + 3);
			model.addAttribute("allGoods", res);
			model.addAttribute("pageCur", page);
		} else {
			String s = pageCur.toString();
			int page = Integer.valueOf(s);
			System.out.println(page);
			int totalCount = list.size();
			model.addAttribute("totalCount", totalCount);
			int pageCount;
			if (totalCount % 3 == 0) {
				pageCount = totalCount / 3;
				model.addAttribute("totalPage", pageCount);
			} else {
				pageCount = totalCount / 3 + 1;
				model.addAttribute("totalPage", pageCount);
			}
			List<GoodsTable> res = null;
			if (page == pageCount) {
				res = list.subList(3 * (page - 1), totalCount);
			} else {
				res = list.subList(3 * (page - 1), 3 * (page - 1) + 3);
			}
			model.addAttribute("allGoods", res);
			model.addAttribute("pageCur", page);
		}
		return "/admin/selectGoods";
	}

	@RequestMapping("/adminGoods/selectAGoods")
	public String selectOneGood(Model model, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		GoodsTable good = goodsTable.selectGoodsTableByID(id);
		model.addAttribute("goods", good);
		GoodsType type = goodsType.selectGoodsTypeById(good.getGoodstype_id());
		model.addAttribute("type", type);
		return "/admin/GoodsDetail";
	}

}
