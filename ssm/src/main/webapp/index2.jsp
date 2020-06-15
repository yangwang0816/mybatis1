<%--
  Created by IntelliJ IDEA.
  User: 李鑫
  Date: 2020/5/10
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script language="javscript" type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script language="javascript">
        //指定分页提交表单
        function goPage(page){
            //1.设置页面到表单
            $("#setPage").val(page);
            //2.提交表单  条件+页码
            $("#form1").submit();  //提交表单
        }
    </script>
</head>
<body>
<a href="showGrade">添加学生</a><br/>
<h2>所有学生信息如下:</h2>
<form name="form1" id="form1" method="post" action="searchStudent">
    <!--定义表单对象存放页码-->
    <input type="hidden" value="1" name="page" id="setPage">
    姓名:<input type="text" value="${condition.name}" name="name"/>
    年龄:<input type="text" value="${condition.startAge}" name="startAge"/>-
    <input type="text" value="${condition.endAge}" name="endAge"/>
    <input type="submit" value="搜索" name="ss"/>
</form>
<table border="2" width="80%">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>地址</td>
        <td>状态</td>
        <td>生日</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="s">
        <tr>
            <td>${s.xh}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.sex}</td>
            <td>${s.address}</td>
            <td>${s.state}</td>
            <td>${s.birthday}</td>
            <td><a href="getOne?xh=${s.xh}">修改</a>
                <a href="javascript:if(confirm('确定想删除吗?')) location.href='delete?xh=${s.xh}';">删除</a></td>
        </tr>
    </c:forEach>
</table>
<hr/>
当前是第${pageInfo.pageNum}页，每页${pageInfo.pageSize}条，共${pageInfo.total}条，共${pageInfo.pages}页<br/>
<a href="javascript:goPage(${pageInfo.navigateFirstPage})">首页</a>
<a href="javascript:goPage(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</a>
<a href="javascript:goPage(${pageInfo.nextPage==0?pageInfo.navigateLastPage:pageInfo.nextPage})">下一页</a>
<a href="javascript:goPage(${pageInfo.navigateLastPage})">尾页</a>
</body>
</html>
