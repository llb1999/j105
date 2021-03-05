<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/24 0024
  Time: 下午 17:45
  To change this template use File | Settings | File Templates.
--%>
<html>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
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

<a href="/teacher/displayManageAllCourse.do">返回管理课程</a><span id="span"></span>

<c:if test="${empty course.studentList}">
    <br/><h2>暂无数据</h2>
</c:if>

<c:if test="${!empty course.studentList}">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h5>课程名称：${course.courseName}</h5>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12" >
    <table style="overflow:scroll;" class="table table-striped table-hover animated fadeIn" align="center">
        <tr>
            <th>学生编号</th>
            <th>学生姓名</th>
            <th>分数</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${course.studentList}" var="student" varStatus="item">
            <tr>
                <td>${item.index+1}</td>
                <td>${student.username}</td>
                <td>
                    <form method="post" action="/teacher/updateStudentCourseScore.do">
                        <input type="text" name="courseName" id="courseName" value="${course.courseName}" hidden="hidden">
                        <input type="text" name="studentName" id="studentName" value="${student.username}" hidden="hidden">
                        <input type="text" name="score" id="score" value="${student.score}" style="width: 40px">
                        <input type="submit" value="修改分数">
                    </form>
                </td>
                <td>
                    <a href="/teacher/deleteStudentFromCourse.do?studentName=${student.username}&courseName=${course.courseName}">剔除该人员</a>
                </td>
            </tr>
        </c:forEach>
    </table>
                </div></div>
        </div>
    </div>
</c:if>

</body>
</html>
