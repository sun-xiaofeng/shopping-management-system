<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/9
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>今日售出商品</title>
</head>
<body>
<h1>今日售出商品</h1>
<table border="1">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>销量</th>
        <th>备注</th>
    </tr>


    <c:forEach items="${requestScope.goods}" var="g">
        <tr>
            <td>${g.gname}</td>
            <td>${g.gprice}</td>
            <td>${g.gnum}</td>
            <td>${g.gsnum}</td>
            <td>
                <c:if test="${g.gsnum < 10}">商品数量不足10件！</c:if>
            </td>
        </tr>
    </c:forEach>

</table>
<br/><br/>
<a href="<c:url value='/GoodsMaintenancePage.jsp'/>">返回商品维护</a>

</body>
</html>
