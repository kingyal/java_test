<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/2/25
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table width="500px" align="center" border="1px" cellspacing="0">
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>gender</th>
            <th>registTime</th>
        </tr>
        <c:forEach items="${requestScope.pageInfo.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.gender}</td>
                <td>${user.resistTime}</td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align: center">
        <a href="${pageContext.request.contextPath}/users?pageNum=1&pageSize=2">首页</a>
        <c:if test="${requestScope.pageInfo.hasPreviousPage}">
            <a href="${pageContext.request.contextPath}/users?pageNum=${requestScope.pageInfo.prePage}&pageSize=2">上一页</a>
        </c:if>
        <c:forEach begin="1" end="${requestScope.pageInfo.pages}" var="i">
            <a href="${pageContext.request.contextPath}/users?pageNum=${i}&pageSize=2">
                <c:if test="${requestScope.pageInfo.pageNum==i}">
                    <span style="color: red">${i}</span>
                </c:if>
                <c:if test="${requestScope.pageInfo.pageNum!=i}">
                    <span style="color: black">${i}</span>
                </c:if>
            </a>
        </c:forEach>
        <c:if test="${requestScope.pageInfo.hasNextPage}">
            <a href="${pageContext.request.contextPath}/users?pageNum=${requestScope.pageInfo.nextPage}&pageSize=2">下一页</a>
        </c:if>
        <a href="${pageContext.request.contextPath}/users?pageNum=${requestScope.pageInfo.pages}&pageSize=2">末页</a>
    </div>
</body>
</html>
