<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/11
  Time: 上午11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加售货员</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style1.css'/>" />
</head>
<body>
<h1>添加售货员</h1>
<span class="error_msg">${requestScope.msg}</span><br/>
<form action="<c:url value='/ManagementServlet'/>" method="post">
    <input type="hidden" name="method" value="addSalesman"/>
    售货员姓名:<input type="text" name="sname"/>&nbsp;<span class="error_msg">${requestScope.errors.sname}</span><br/>
    售货员密码:<input type="password" name="spassword"/>&nbsp;<span class="error_msg">${requestScope.errors.spassword}</span><br/>
    <input type="submit" value="提交" /><br/>
</form><br/>
<a href="<c:url value='/ManagementPage.jsp'/>">返回售货员管理</a>
</body>
</html>
