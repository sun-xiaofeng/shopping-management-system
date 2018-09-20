<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/11
  Time: 下午1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改售货员信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/style1.css'/>"/>
</head>
<h1>更改售货员信息</h1>
${requestScope.msg}
<form action="<c:url value='/ManagementServlet'/>" method="post">
    <input type="hidden" name="method" value="edit">
    <input type="hidden" name="sid" value="${requestScope.salesman.sid}"/>
    售货员姓名:<input type="text" name="sname" value="${requestScope.salesman.sname}"/>&nbsp;<span class="error_msg">${requestScope.errors.sname}</span><br/>
    售货员密码:<input type="text" name="spassword" value="${requestScope.salesman.spassword}"/>&nbsp;<span class="error_msg">${requestScope.errors.spassword}</span><br/>
    <input type="submit" value="提交"/>
</form>
<body>


</body>
</html>
