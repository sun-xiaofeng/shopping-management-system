<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/9
  Time: 上午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>售货员管理</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style1.css'/>"/>
</head>
<body>
<h1>售货员管理</h1>
<span class="error_msg">${requestScope.msg}</span><br/>

<a href="<c:url value='/Management/AddSalesmanPage.jsp'/>">添加售货员</a><br/>
<a href="<c:url value='/ManagementServlet?method=listSalesman'/>">查询售货员</a><br/>
<a href="<c:url value='/MainPage.jsp'/>">返回首页</a>
</body>
</html>