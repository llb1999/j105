<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3 0003
  Time: 下午 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
<html>
<head>
    <title>此学生个人信息</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-expand-lg" role="navigation">
    <a class="navbar-brand" href="#" ><font color=" #34495e">学生在线选课系统——管理员端</font></a>

    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
    <div class="collapse navbar-collapse" id="navbar-collapse-01">
        <ul class="nav navbar-nav mr-auto">
            <li><a href="/admin/displayAllStudentInfo.do"><strong>管理学生</strong></a></li>
            <li><a href="/admin/displayAllTeacherInfo.do"><strong>管理教师</strong></a></li>
        </ul>
        <p class="navbar-text navbar-right">你好！管理员：${sessionScope.ADMIN_IN_SESSION.username}
            <a href="/admin/adminLogin.do"><font color=" #34495e">退出登录</font></a></p>
    </div>
</div>
<a href="/admin/displayAllStudentInfo.do">返回管理全部学生信息</a>
<h4>修改此学生个人信息</h4>
<form method="post" action="/admin/updateStudentSelfInfo.do">
    <input type="text" value="${student.stu_id}" name="stu_id" hidden="hidden"><%--学号不能改，所以隐藏--%>
    姓名：<input type="text" value="${student.username}" name="username"><br/><br/>
    密码：<input type="text" value="${student.password}" name="password"><br/><br/>
    年龄:<input type="text" value="${student.age}" name="age"><br/><br/>
    班级:<input type="text" value="${student.classNum}" name="classNum"><br/><br/><%--class是关键字，所以换名字--%>
    学院:<input type="text" value="${student.college}" name="college"><br/><br/>
    联系方式:<input type="text" value="${student.phoneNumber}" name="phoneNumber"><br/><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
