<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java"  %>
<html>
<body>
<center>
学生信息如下:<br/>
    <a href="/showGrade">添加</a>
<table border="1">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>地址</td>
        <td>生日</td>
        <td>状态</td>
        <td>操作</td>

    </tr>
    <c:forEach items="${pageInfo.list}" var="l">
        <tr>
            <td>${l.xh}</td>
            <td>${l.name}</td>
            <td>${l.age}</td>
            <td>${l.sex}</td>
            <td>${l.address}</td>
            <td>${l.birthday}</td>
            <td>${l.state}</td>

            <td>
                <a href="javascript:del(${l.xh})">删除</a>
                <a href="javascript:update(${l.xh})">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
    当前是第${pageInfo.pageNum},每页${pageInfo.pageSize},共${pageInfo.total}条,共${pageInfo.pages}页
    <br>
    <a href="studentPage?page=${pageInfo.navigateFirstPage}">首页</a>
    <a href="studentPage?page=${pageInfo.prePage==0?1:pageInfo.prePage}">上一页</a>
    <a href="studentPage?page=${pageInfo.nextPage==0?pageInfo.navigateFirstPage:pageInfo.nextPage}">下一页</a>
    <a href="studentPage?page=${pageInfo.navigateLastPage}">尾页</a>
</center>
</body>
<script>
    function del(xh) {
        if (confirm("确认删除?")) {
            window.location.href="delete?xh="+xh;
        }
    }
    function update(xh) {
        window.location.href="/getOne?xh="+xh;
    }
</script>
</html>
