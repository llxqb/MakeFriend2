<%--
  Created by IntelliJ IDEA.
  User: li.liu
  Date: 2018/8/3
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
<script src="bootstrap/js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-select.min.js"></script>
<link href="bootstrap/css/bootstrap-select.min.css" rel="stylesheet"/>
<script src="layer/layer.js"></script>
<script src="js/index.js"></script>
<html>
<head>
    <title>matching</title>
</head>

<body>

<c:if test="${msg==2}">
    <div>提交成功</div>
</c:if>


<form action="matchingHuman.matchingHuman">
    <label style="padding: 5px"><input type="submit" name="submit" value="查看我的有缘人"/></label>
</form>

<c:if test="${msg==1}">
    <font color="green">没有内容</font>
</c:if>

<c:if test="${msg==0}">
    <table style="margin-top: 5px" width="580px" border="1" cellpadding="0" cellspacing="0" id="projectTableId">
        <tr style="height: 30px;text-align: center">
            <td width="120px" bgcolor="#EFEFEF">姓名</td>
            <td width="120px" bgcolor="#EFEFEF">年龄</td>
            <td width="120px" bgcolor="#EFEFEF">籍贯</td>
            <td width="120px" bgcolor="#EFEFEF">微信号</td>
            <td width="220px" bgcolor="#EFEFEF">兴趣爱好</td>
        </tr>

        <c:forEach items="${userList}" var="us" varStatus="stus">
            <tr align="center">
                <td height="30">${us.mime_name } </td>
                <td height="30">${us.mime_year  }</td>
                <td height="30">${us.mime_area  }</td>
                <td height="30">${us.mime_wx_num  }</td>
                <td height="30">${us.mime_interest  }</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="logout.jsp">重新录入我的信息</a>
</body>
</html>
