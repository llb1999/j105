<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/22 0022
  Time: 下午 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
<html>
<head>
    <title>学生在线选课系统</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
    <a class="navbar-brand" href="#" ><font color=" #34495e">学生在线选课系统——学生端</font></a>

    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
    <div class="collapse navbar-collapse" id="navbar-collapse-01">
        <ul class="nav navbar-nav mr-auto">
            <li><a href="/student/displayAllCourse.do"><strong>选课</strong></a></li>
            <li><a href="/student/displayCheckedCourse.do"><strong>查看已选课程</strong></a></li>
            <li><a href="/student/displaySelfInfo.do"><strong>修改个人信息</strong></a></li>
        </ul>
        <p class="navbar-text navbar-right">你好！学生：${sessionScope.STUDENT_IN_SESSION.username}
            <a href="/student/studentLogin.do"><font color=" #34495e">退出登录</font></a></p>
    </div>
</nav>
<!--<h1>学生：${sessionScope.STUDENT_IN_SESSION.username}，全部已开课的课程列表</h1>--!>


<c:if test="${empty allCourses}">
    <br/><h2>暂无数据</h2>
</c:if>

<c:if test="${!empty allCourses}">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h5>全部课程</h5>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12" >

    <table style="overflow:scroll;" class="table table-striped table-hover animated fadeIn" align="center">
        <tr>
            <th>课程编号</th>
            <th>课程名称</th>
            <th>授课教师</th>
            <th>课程学分</th>
            <th>课程学时</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${allCourses}" var="allCourses" varStatus="item">
            <tr>
                <td>${item.index+1}</td>
                <td>${allCourses.courseName}</td>
                <td>${allCourses.teaName}</td>
                <td>${allCourses.courseScore}</td>
                <td>${allCourses.courseTime}</td>
                <td>
                    <a href="/student/addCourse.do?courseName=${allCourses.courseName}&courseTeacher=${allCourses.teaName}">添加课程</a>
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