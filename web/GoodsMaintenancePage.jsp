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
    <title>商品维护</title>
    <link rel="stylesheet" type="text/css" href="style1.css"/>
</head>
<body>
<h1>商超购物管理系统>>商品维护</h1>

<span class="error_msg">${requestScope.msg}</span><br/>

<a href="<c:url value='/GoodsMaintenance/AddGoodsPage.jsp'/>">添加商品</a><br/>
<a href="<c:url value='/GoodsMaintenanceServlet?method=findAll&order=no_order'/>">查询商品</a><br/>
<a href="<c:url value='/GoodsMaintenanceServlet?method=listGoodsSold'/>">列出当日卖出商品列表</a><br/>
<a href="<c:url value='/MainPage.jsp'/>">返回首页</a>
</body>
</html>
