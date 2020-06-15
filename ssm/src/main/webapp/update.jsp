<%--
  Created by IntelliJ IDEA.
  User: 李鑫
  Date: 2020/5/7
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form method="post" action="/updateStudent" id="form2" name="from2"><br>
    学号:<input type="text" id="textfield1" name="xh" value="${s.xh}"><br>
    姓名:<input type="text" id="textfield2" name="name" value="${s.name}"><br>
    性别:<input type="text" id="textfield3" name="sex" value="${s.sex}"><br>
    年龄:<input type="text" id="textfield4" name="age" value="${s.age}"><br>
    生日:<input type="date" id="textfield5" name="birthday" ><br>
    地址:<input type="text" id="textfield6" name="address" value="${s.address}"><br>
    状态:<input type="text" id="textfield7" name="state" value="${s.state}"><br>
    年级:
    <select name="gid" id="textfield8">
        <c:forEach items="${gradeList}" var="g">
            <option value="${g.gid}"
                    <c:if test="${g.gid==s.gid}">selected</c:if>
            >${g.gname}</option>
        </c:forEach>
    </select>
    <input type="submit" name="bottom" id="bottom" value="提交">
</form>
</body>
</html>
