<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 李鑫
  Date: 2020/5/7
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form method="post" action="addStudent" id="form1" name="from1"><br>
    学号:<input type="text" id="textfield1" name="xh"><br>
    姓名:<input type="text" id="textfield2" name="name"><br>
    性别:<input type="text" id="textfield3" name="sex"><br>
    年龄:<input type="text" id="textfield4" name="age"><br>
    生日:<input type="date" id="textfield5" name="birthday"><br>
    地址:<input type="text" id="textfield6" name="address"><br>
    状态:<input type="text" id="textfield7" name="state"><br>
    年级:
    <select name="gid" id="textfield8">
        <c:forEach items="${gradeList}" var="gl">
                <option value="${gl.gid}">
                ${gl.gname}
                </option>
        </c:forEach>
    </select>
    <input type="submit" name="bottom" id="bottom" value="提交">
</form>
</body>
</html>
