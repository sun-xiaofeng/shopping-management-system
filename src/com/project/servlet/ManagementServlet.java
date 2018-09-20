package com.project.servlet;

import cn.itcast.servlet.BaseServlet;
import com.project.entity.Salesman;
import com.project.exception.SalesmanServiceException;
import com.project.service.GSalesService;
import com.project.service.SalesmanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementServlet extends BaseServlet {
    private GSalesService gss = new GSalesService();
    private SalesmanService ss = new SalesmanService();


    public String addSalesman(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> errors = verifyParams(request);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            return "f:/Management/AddSalesmanPage.jsp";
        }
        String sname = request.getParameter("sname").trim();
        String spassword = request.getParameter("spassword").trim();
        try {
            ss.addSalesman(sname, spassword);
            request.setAttribute("msg", "添加售货员成功！");
            return "f:/ManagementPage.jsp";
        } catch (SalesmanServiceException e) {
            String message = e.getMessage();
            request.setAttribute("msg", message);
            return "f:/Management/AddSalesmanPage.jsp";
        }
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        Salesman s = ss.findById(sid);
        request.setAttribute("salesman", s);
        return "f:/Management/EditSalesmanPage.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> errors = verifyParams(request);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            return "f:/ManagementServlet?method=preEdit";
        }
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname").trim();
        String spassword = request.getParameter("spassword").trim();
        try {
            ss.updateSalesman(sid, sname, spassword);
            request.setAttribute("msg", "编辑售货员成功！");
            return "f:/ManagementPage.jsp";
        } catch (SalesmanServiceException e) {
            String message = e.getMessage();
            request.setAttribute("msg", message);
            return "f:/Management/EditSalesmanPage.jsp";
        }
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        try {
            ss.deleteById(sid);
            request.setAttribute("msg", "删除售货员成功！");
        } catch (SalesmanServiceException e) {
            String message = e.getMessage();
            request.setAttribute("msg", message);
        }
        return "/ManagementPage.jsp";
    }

    public String listSalesman(HttpServletRequest request, HttpServletResponse response) {
        List<Salesman> salesmen = ss.getAllSalesman();
        request.setAttribute("salesmen", salesmen);
        return "f:/Management/ListSalesmanPage.jsp";
    }

    private Map<String, String> verifyParams(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        String sname = request.getParameter("sname");
        if (sname == null || sname.trim().isEmpty()) {
            errors.put("sname", "用户名不能为空！");
        }
        String spassword = request.getParameter("spassword");
        if (spassword == null || spassword.trim().isEmpty()) {
            errors.put("spassword", "密码不能为空！");
        }
        return errors;
    }
}
