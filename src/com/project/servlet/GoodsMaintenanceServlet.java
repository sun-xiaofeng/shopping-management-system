package com.project.servlet;

import cn.itcast.servlet.BaseServlet;
import com.project.entity.GSales;
import com.project.entity.Goods;
import com.project.exception.GoodsServiceException;
import com.project.service.GSalesService;
import com.project.service.GoodsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsMaintenanceServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsService();
    private GSalesService gSalesService = new GSalesService();

    public String add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> errors = verifyParams(request);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            return "f:/GoodsMaintenance/AddGoodsPage.jsp";
        }

        String gname = request.getParameter("gname").trim();
        BigDecimal gprice = new BigDecimal(request.getParameter("gprice").trim());
        int gnum = Integer.parseInt(request.getParameter("gnum").trim());
        try {
            goodsService.addGoods(gname, gprice, gnum);
            request.setAttribute("msg","添加商品成功!");
            return "f:/GoodsMaintenancePage.jsp";
        } catch (GoodsServiceException e) {
            String message = e.getMessage();
            request.setAttribute("msg",message);
            return "f:/GoodsMaintenance/AddGoodsPage.jsp";
        }
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int gid = Integer.parseInt(request.getParameter("gid"));
        try {
            goodsService.deleteGoods(gid);
            request.setAttribute("msg","删除商品成功!");
        } catch (GoodsServiceException e) {
            String message = e.getMessage();
            request.setAttribute("msg", message);
        }
        return "f:/GoodsMaintenancePage.jsp";
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response) {
        int gid = Integer.parseInt(request.getParameter("gid"));
        Goods g = goodsService.findById(gid);
        request.setAttribute("goods", g);
        return "f:/GoodsMaintenance/EditGoodsPage.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> errors = verifyParams(request);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            return "f:/GoodsMaintenanceServlet?method=preEdit";
        }

        int gid = Integer.parseInt(request.getParameter("gid"));
        String gname = request.getParameter("gname".trim());
        BigDecimal gprice = new BigDecimal(request.getParameter("gprice").trim());
        int gnum = Integer.parseInt(request.getParameter("gnum").trim());

        try {
            goodsService.updateGoods(gid, gname, gprice, gnum);
            request.setAttribute("msg","编辑商品成功!");
            return "f:/GoodsMaintenancePage.jsp";
        } catch (GoodsServiceException e) {
            String message = e.getMessage();
            request.setAttribute("msg", message);
            return "f:/GoodsMaintenance/EditGoodsPage.jsp";
        }
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        String order = request.getParameter("order");
        List<Goods> goods;
        if (order.equals("by_gnum_asc")) {
            goods = goodsService.findGoodsOrderByQuantityAsc();
        } else if (order.equals("by_gprice_asc")) {
            goods = goodsService.findGoodsOrderByPriceAsc();
        } else {
            goods = goodsService.getAllGoods();
        }
        request.setAttribute("goods", goods);
        return "f:/GoodsMaintenance/ListGoodsPage.jsp";
    }

    public String findByNameContains(HttpServletRequest request, HttpServletResponse response) {
        String searchString = request.getParameter("search_string").trim();
        List<Goods> goods = goodsService.findByNameContains(searchString);
        request.setAttribute("goods", goods);
        return"f:/GoodsMaintenance/SearchResultPage.jsp";
    }

    public String listGoodsSold(HttpServletRequest request, HttpServletResponse response) {
        List<GSales> goods = gSalesService.findGoodsSoldByDate(new Date());

        request.setAttribute("goods", goods);
        return "f:/GoodsMaintenance/ListGoodsSoldPage.jsp";
    }

    private Map<String, String> verifyParams(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        String gname = request.getParameter("gname");
        if (gname == null || gname.trim().isEmpty()) {
            errors.put("gname", "名称不能为空！");
        }
        String gprice = request.getParameter("gprice");
        if (gprice == null || !gprice.trim().matches("\\d+.?\\d*")) {
            errors.put("gprice", "价格须为整数或小数！");
        }
        String gnum = request.getParameter("gnum");
        if (gnum == null || !gnum.trim().matches("\\d+")) {
            errors.put("gnum", "数量须为整数，请检查输入");
        }
        return errors;
    }
}
