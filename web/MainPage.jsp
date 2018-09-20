<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/5
  Time: 下午5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商超购物管理系统</title>
</head>
<body>
<div style="text-align: center; margin-top: 80px; font-size: 12pt">
    <h1>商超购物管理系统</h1>
    <a href="<c:url value='/GoodsMaintenancePage.jsp'/>">商品维护</a>
    <a href="<c:url value='/CashierLoginPage.jsp'/>">前台收银</a>
    <a href="<c:url value='/ManagementPage.jsp'/>">售货员管理</a>
</div>
</body>
</html>
