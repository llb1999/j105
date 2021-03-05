<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22 0022
  Time: 下午 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
<head>
    <title>学生在线选课系统</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
    <a class="navbar-brand" href="#" ><font color="#34495e">学生在线选课系统——教师端</font></a>

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
<h5>开课信息</h5>

<form action="/teacher/addCourse.do" method="post">
    课程名称:<input type="text" name="courseName"/><br/><br/>
    课程学分:<input type="text" name="courseScore"/><br/><br/>
    课程课时:<input type="text" name="courseTime"/><br/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
