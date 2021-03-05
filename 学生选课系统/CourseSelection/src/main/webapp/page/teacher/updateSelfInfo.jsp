<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3 0003
  Time: 上午 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
<html>
<head>
    <title>学生在线选课系统</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
    <a class="navbar-brand" href="#" ><font color=" #34495e">学生在线选课系统——教师端</font></a>

    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
    <div class="collapse navbar-collapse" id="navbar-collapse-01">
        <ul class="nav navbar-nav mr-auto">
            <li><a href="/page/teacher/addCourse.jsp"><strong>增加新课</strong></a></li>
            <li><a href="/teacher/displayManageAllCourse.do"><strong>管理课程信息</strong></a></li>
            <li><a href="/teacher/displaySelfInfo.do"><strong>修改个人信息</strong></a></li>
        </ul>
        <p class="navbar-text navbar-right">你好！教师：${sessionScope.TEACHER_IN_SESSION.username}
            <a href="/student/studentLogin.do"><font color=" #34495e">退出登录</font></a></p>
    </div>
</nav>
<a href="/teacher/displayManageAllCourse.do">返回管理课程</a>
<h4>教师修改个人信息</h4>
<form method="post" action="/teacher/updateSelfInfo.do">
    <input type="text" value="${teacher.tea_id}" name="tea_id" hidden="hidden"><%--工号不能改，所以隐藏--%>
    姓名：<input type="text" value="${teacher.username}" name="username"><br/><br/>
    密码：<input type="text" value="${teacher.password}" name="password"><br/><br/>
    年龄：<input type="text" value="${teacher.age}" name="age"><br/><br/>
    学院：<input type="text" value="${teacher.college}" name="college"><br/><br/>
    职称：<input type="text" value="${teacher.professionalTitle}" name="professionalTitle"><br/><br/>
    联系方式：<input type="text" value="${teacher.phoneNumber}" name="phoneNumber"><br/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
