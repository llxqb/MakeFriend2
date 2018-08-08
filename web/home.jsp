<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: li.liu
  Date: 2018/8/3
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
<script src="bootstrap/js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-select.min.js"></script>
<link href="bootstrap/css/bootstrap-select.min.css" rel="stylesheet"/>
<script src="layer/layer.js"></script>
<script src="js/index.js"></script>
<html>
<head>
    <title>look for you</title>
    <style>
        body {
            margin-left: 10px;
            padding: 10px;
        }
    </style>
</head>

<%
    Cookie[] cookies = request.getCookies();
    String groupId = null;
    String mimeName = null;
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            if ("group_id".equals(name)) {//如果是中文，cookies需要解码
                groupId = URLDecoder.decode(cookies[i].getValue(), "utf-8");
            } else if ("mime_name".equals(name)) {
                mimeName = cookies[i].getValue();
            }
        }
    }
    System.out.println("groupId2=" + groupId + " mimeName2=" + mimeName);
    //
    if (groupId != null && !groupId.equals("")  && mimeName != null && mimeName.equals("")) {
        System.out.println("111" );
        response.sendRedirect("matchingHuman.jsp");
    }else {
        System.out.println("222" );
    }
%>

<body>
<form action="home.home" method="post" onsubmit="return checkForm()">
    <div style="margin-top: 10px">
        群号：
        <input class="text" name="group_id" id="group_id"/>
    </div>
    <div style="margin-top: 20px">
        姓名：
        <input class="text" name="mime_name" id="mime_name"/>
        <a style="margin-left: 30px">年龄：</a>
        <input class="text" name="mime_year" id="mime_year"/>
    </div>
    <div style="margin-top: 20px">
        家乡：
        <input class="text" name="mime_area" id="mime_area"/>
        <a style="margin-left: 30px">性别：</a>
        <select id="mime_sex" class="selectpicker" name="mime_sex" title="请选择">
            <option value="男"> 男</option>
            <option value="女"> 女</option>
        </select>
    </div>
    <div style="margin-top: 20px">
        微信号：
        <input class="text" name="mime_wx_num" id="mime_wx_num"/>
    </div>
    <div style="margin-top: 20px">
        兴趣爱好：</br>
        <textarea style="margin-top: 5px ;margin-bottom: 20px;" rows="4" cols="100" id="mime_interest"
                  name="mime_interest" placeholder="你的兴趣爱好"></textarea>
    </div>

    <hr/>

    <div style="margin-top: 50px">
        希望对方</br>
    </div>

    <div style="margin-top: 20px">
        年龄：
        <select id="your_year" class="selectpicker" name="your_year" title="请选择">
            <option value="21-25"> 21-25</option>
            <option value="22-27"> 22-27</option>
            <option value="24-28"> 24-28</option>
            <option value="25-30"> 25-30</option>
            <option value="28-32"> 28-32</option>
            <option value="30-33"> 30-33</option>
            <option value="33-37"> 33-37</option>
            <option value="33-43"> 33-43</option>
        </select>
        <a style="margin-left: 30px">家乡：</a>
        <input class="text" name="year_area" id="year_area"/>
    </div>
    <div style="margin-top: 20px">
        兴趣爱好：</br>
        <textarea style="margin-top: 5px ;margin-bottom: 20px;" rows="4" cols="100" id="your_interest"
                  name="your_interest" placeholder="他（她）兴趣爱好"></textarea>
    </div>

    <label style="padding: 5px"><input type="submit" name="submit" value="提交"/></label>
</form>
</body>
</html>
