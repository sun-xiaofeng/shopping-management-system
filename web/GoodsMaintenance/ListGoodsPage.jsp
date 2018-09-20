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
    <title>显示所有商品</title>
</head>
<body>
<h1>显示所有商品</h1>
<a href="<c:url value='/GoodsMaintenanceServlet?method=findAll&order=no_order'/>">按添加时间排序</a>
<a href="<c:url value='/GoodsMaintenanceServlet?method=findAll&order=by_gnum_asc'/>">按商品数量升序</a>
<a href="<c:url value='/GoodsMaintenanceServlet?method=findAll&order=by_gprice_asc'/>">按商品价格升序</a>
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
<form action="<c:url value='/GoodsMaintenanceServlet'/>" method="post">
    输入关键字查询商品
    <input type="hidden" name="method" value="findByNameContains"/>
    <input type="text" id="search_string" name="search_string"/>
    <input type="submit" value="搜索"/>
</form>

<a href="<c:url value='/GoodsMaintenancePage.jsp'/>">返回商品维护</a>
</body>
</html>
