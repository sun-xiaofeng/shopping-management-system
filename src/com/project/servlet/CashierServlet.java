package com.project.servlet;

import cn.itcast.servlet.BaseServlet;
import com.project.entity.GSales;
import com.project.entity.Goods;
import com.project.entity.Salesman;
import com.project.exception.GSalesServiceException;
import com.project.service.GSalesService;
import com.project.service.GoodsService;
import com.project.service.SalesmanService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashierServlet extends BaseServlet {
    private GoodsService gs = new GoodsService();
    private GSalesService gss = new GSalesService();
    private SalesmanService salesmanService = new SalesmanService();


    public String loadGoods(HttpServletRequest request, HttpServletResponse response) {
        List<Goods> goods = gs.getAllGoods();
        request.setAttribute("goods", goods);
        return "f:/Cashier/CheckoutPage.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("verify_code");
        if (!request.getParameter("verifyCode").equalsIgnoreCase(code)) {
            request.setAttribute("msg", "验证码错误");
            return "f:/CashierLoginPage.jsp";
        }

        Integer numAttempts = (Integer) session.getAttribute("num_attempts");
        if (numAttempts == null) { numAttempts = 0; }
        if (numAttempts == 3) { return "f:/CashierLoginPage.jsp"; }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean succeed = salesmanService.validatePassword(username, password);
        if (!succeed) {
            session.setAttribute("num_attempts", numAttempts + 1);
            return "f:/CashierLoginPage.jsp";
        } else {
            // 登录成功

            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24); // 设置cookie命长为1天
            response.addCookie(cookie); // 保存cookie

            Salesman salesman = salesmanService.findByName(username);
            session.setAttribute("salesman_obj", salesman);
            return "f:/CashierServlet?method=loadGoods";
        }
    }

    public String clearList(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("gsales_map");
        return "f:/CashierServlet?method=loadGoods";
    }

    public String sellGoods(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int gid = Integer.parseInt(request.getParameter("gid"));
        Goods goods = gs.findById(gid);
        int snum = Integer.parseInt(request.getParameter("snum"));

        Map<Integer, GSales> map = (Map<Integer, GSales>) session.getAttribute("gsales_map");
        if (map == null) {
            map = new HashMap<>();
            session.setAttribute("gsales_map", map);
        }

        Salesman s = (Salesman) session.getAttribute("salesman_obj");
        try {
            gss.addGSales(s.getSname(), goods.getGname(), snum);
        } catch (GSalesServiceException e) {
            request.setAttribute("msg", e.getMessage());
            return "f:/CashierServlet?method=loadGoods";
        }

        if (map.containsKey(gid)) {
            GSales gsales = map.get(gid);
            gsales.setSnum(gsales.getSnum() + snum);
        } else {
            GSales gsales = new GSales();
            gsales.setGname(goods.getGname());
            gsales.setGprice(goods.getGprice());
            gsales.setSnum(snum);
            map.put(gid, gsales);
        }
        return "f:/CashierServlet?method=loadGoods";
    }
}
