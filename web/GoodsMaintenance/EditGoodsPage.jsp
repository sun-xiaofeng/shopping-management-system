<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/5
  Time: 下午7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑商品</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style1.css'/>"/>
</head>
<body>

<h1>编辑商品</h1>
<span class="error_msg">${requestScope.msg}</span><br/>

<form action="<c:url value='/GoodsMaintenanceServlet'/>" method="post">
    <input type="hidden" name="method" value="edit"/>
    <input type="hidden" name="gid" value="${requestScope.goods.gid}"/>
    商品名称: <input type="text" name="gname" value="${requestScope.goods.gname}"/>&nbsp;<span class="error_msg">${requestScope.errors.gname}</span><br/>
    商品价格: <input type="text" name="gprice" value="${requestScope.goods.gprice}"/>&nbsp;<span class="error_msg">${requestScope.errors.gprice}</span><br/>
    商品数量: <input type="text" name="gnum" value="${requestScope.goods.gnum}"/>&nbsp;<span class="error_msg">${requestScope.errors.gnum}</span><br/>
    <input type="submit" value="提交"/><br/>
</form>

<a href="<c:url value='/GoodsMaintenancePage.jsp'/>">返回商品维护</a>
</body>
</html>
