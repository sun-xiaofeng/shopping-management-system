<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/8
  Time: 下午4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>售货员登录</title>
    <script type="text/javascript">
        function _change() {
            var image = document.getElementById("img");
            image.src = "VerifyCodeServlet?a=" + new Date().getTime();
        }
    </script>
    <link rel="stylesheet" type="text/css" href="<c:url value='style1.css'/>">
</head>
<body>
<h1>欢迎使用商超购物管理系统</h1>

<c:if test="${not empty sessionScope.salesman_obj}">
    <c:redirect url="/CashierServlet?method=loadGoods"/>
</c:if>

<c:set var="username" value="" scope="page"/>
<c:if test="${not empty cookie.username.value}">
    <c:set var="username" value="${cookie.username.value}" scope="page"/>
</c:if>

<span class="error_msg">${requestScope.msg}</span>

<c:if test="${not empty sessionScope.num_attempts}">
    <span class="error_msg">用户名和密码不匹配！</span><br/>
    <c:choose>
        <c:when test="${sessionScope.num_attempts eq 3}" >
            <span class="error_msg">登录失败超过3次！</span>
            <c:redirect url="/MainPage.jsp"/>
        </c:when>
        <c:otherwise>
            <span class="error_msg">您还有${3 - sessionScope.num_attempts}次登录机会</span>
        </c:otherwise>
    </c:choose>

</c:if>

<form action="<c:url value='/CashierServlet'/>" method="post">
    <input type="hidden" name="method" value="login"/>
    用户名:<input type="text" name="username" value="${username}"/><br/>
    密　码:<input type="password" name="password"/><br/>
    验证码:<input type="text" name="verifyCode" style="width: 70px;"/>
    <img id="img" src="VerifyCodeServlet"/>
    <a href="javascript:_change()">换一张</a><br/>
    <input type="submit" value="登录"/>
</form>
<br/>
<a href="<c:url value='/MainPage.jsp'/>">返回首页</a>
</body>
</html>
