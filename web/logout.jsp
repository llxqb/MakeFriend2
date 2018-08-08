<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: li.liu
  Date: 2018/8/1
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookies[i].setMaxAge(0);
            response.addCookie(cookies[i]);
        }
    }
//    session.removeAttribute("mySession");//根据参数清除对应的值
%>

<head>
    <title>清除缓存</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script src="bootstrap/js/jquery-3.2.1.min.js"></script>
    <script src="layer/layer.js"></script>
    <style>
        body {
            padding: 20px;
        }
    </style>
</head>
<body>

<div>
    清除成功<a style="margin-left: 12px" href="home.jsp">重新录入</a>
</div>
</body>
</html>
