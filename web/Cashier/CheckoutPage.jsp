<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/8
  Time: 下午5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物结算</title>
    <script type="text/javascript">
        function calculateChange(totalPrice) {
            var inputString = document.getElementById("cash_amount").value.trim();
            if (inputString !== "") {
                var cashAmount = parseFloat(inputString);
                cashAmount = Math.floor(cashAmount * 100.0);
                totalPrice = Math.floor(totalPrice * 100.0);
                if (cashAmount < totalPrice) {
                    document.getElementById("span1").innerText = "金额不足！请重新输入！";
                } else {
                    document.getElementById("span1").innerText = "找钱: " + ((cashAmount - totalPrice) / 100.0);
                }
            }
        }
    </script>
</head>

<body>

<c:if test="${empty sessionScope.salesman_obj}">
    <c:redirect url="/CashierLoginPage.jsp"/>
</c:if>

<h1>购物结算</h1>

<c:if test="${not empty requestScope.msg}">
    <span style="color: red; font-size: 14pt;">${requestScope.msg}</span><br/>
</c:if>

<h2>选择商品</h2>
<table border="1">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>购买数量</th>
    </tr>
    <c:forEach items="${requestScope.goods}" var="g">
        <tr>
            <td>${g.gname}</td>
            <td>${g.gprice}</td>
            <td>${g.gnum}</td>
            <td>
                <form action="<c:url value='/CashierServlet'/>" method="post">
                    <input type="hidden" name="method" value="sellGoods"/>
                    <input type="hidden" name="gid" value="${g.gid}"/>
                    <input type="text" name="snum" value="1"/>
                    <input type="submit" value="购买"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<c:if test="${not empty gsales_map}">
    <h2>购买的商品</h2>
    <c:set var="total_price" value="0" scope="page"/>
    <table border="1">
        <tr>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>购买数量</th>
            <th>总价</th>
        </tr>
        <c:forEach items="${gsales_map}" var="entry">
            <tr>
                <td>${entry.value.gname}</td>
                <td>${entry.value.gprice}</td>
                <td>${entry.value.snum}</td>
                <td>${entry.value.gprice * entry.value.snum}</td>
                <c:set var="total_price" value="${total_price + entry.value.gprice * entry.value.snum}"/>
            </tr>
        </c:forEach>
        <tr>
            <td><b>总计</b></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><b>${pageScope.total_price}</b></td>
        </tr>
    </table>
    <a href="<c:url value='/CashierServlet?method=clearList'/>">清空</a><br/>
    请输入实际交费金额:<input type="text" name="cash_amount" id="cash_amount"/>
    <input type="button" value="计算找零" id="button1" onclick="calculateChange(${pageScope.total_price})"/><br/>
    <span id="span1"></span><br/>
</c:if>
<br/>
<a href="<c:url value='/MainPage.jsp'/>">返回首页</a>
</body>
</html>
