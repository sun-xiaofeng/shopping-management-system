<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunxiaofeng208
  Date: 2018/9/11
  Time: 下午12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有售货员</title>
</head>
<body>
<h1>显示所有售货员</h1>

<table border="1">
    <tr>
        <th>售货员姓名</th>
        <th>密码</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${requestScope.salesmen}" var="s">
        <tr>
            <td>${s.sname}</td>
            <td>${s.spassword}</td>
            <td>
                <a href="<c:url value='/ManagementServlet?method=preEdit&sid=${s.sid}'/>">编辑</a>
            </td>
            <td>
                <a href="<c:url value='/ManagementServlet?method=delete&sid=${s.sid}'/>">删除</a>
            </td>
        </tr>
    </c:forEach>
</table><br/>
<a href="<c:url value='/ManagementPage.jsp'/>">返回售货员管理</a>
</body>
</html>
