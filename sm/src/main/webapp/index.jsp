<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部打印</title>
</head>
<body>

<center>
    <table border="1">
        <a href="addStudent.jsp">添加</a>

        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>生日</th>
            <th>地址</th>
            <th>状态</th>
            <th>年级</th>
        </tr>
        <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.xh}</td>
            <td>${s.name}</td>
            <td>${s.sex}</td>
            <td>${s.age}</td>
            <td>${s.birthday}</td>
            <td>${s.address}</td>
            <td>${s.state}</td>
            <td>${s.gid}</td>
            </tr>
            </c:forEach>
    </table>
</center>
</body>
</html>
