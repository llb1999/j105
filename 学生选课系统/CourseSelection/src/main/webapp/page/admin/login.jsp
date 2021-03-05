<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22 0022
  Time: 下午 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>学生在线选课系统</title>
  <link href="../../css/login.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="../../js/jQuery1.7.js"></script>
</head>
<body>
<div id="tab">
  <div id="tab1">学生在线选课系统</div>
  <ul class="tab_menu">
    <a href="/page/student/login.jsp"><li  style="width:33%;">学生登录</li></a>
    <a href="/page/teacher/login.jsp"><li style="width:33%;">教师登录</li></a>
    <a href="/page/admin/login.jsp"><li class="selected" style="width:34%;">管理员登录</li></a>

  </ul>
  <div class="tab_box">
    <div>
      <div class="msg_box">${msg}</div>
      <form action="/admin/adminLogin.do" method="post" class="stu_login_error">
        <div id="username">
          <label>帐&nbsp;&nbsp;&nbsp;号：</label>
          <input type="text" id="stu_username_hide" name="username"/>
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="stu_password_hide" name="password"/>
        </div>
        <div id="remember">
          <label></label>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="bottom"><h2>©2020 <span>京ICP证030173号</span>学生选课系统</h2></div>
<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="../../img/1.jpg"></a></li>
  </ul>
</div>
</body>
</html>