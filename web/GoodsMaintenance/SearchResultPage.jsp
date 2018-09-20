<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/5
  Time: 下午5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索商品</title>
</head>
<body>
<h1>按关键字搜索商品：${param.search_string}</h1>

<table border="1" id="mytable">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>备注</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>


    <c:forEach items="${requestScope.goods}" var="g">
        <tr>
            <td>${g.gname}</td>
            <td>${g.gprice}</td>
            <td>${g.gnum}</td>
            <td>
                <c:if test="${g.gnum < 10}">商品数量不足10件！</c:if>
            </td>
            <td>
                <a href="<c:url value='/GoodsMaintenanceServlet?method=preEdit&gid=${g.gid}'/>">编辑</a>
            </td>
            <td>
                <a href="<c:url value='/GoodsMaintenanceServlet?method=delete&gid=${g.gid}'/>">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br/>

<a href="<c:url value='/GoodsMaintenanceServlet?method=findAll&order=no_order'/>">返回商品列表</a>
</body>
</html>
