<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3 0003
  Time: 下午 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
<html>
<head>
    <title>此学生选课信息</title>
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
<a href="/admin/displayAllStudentInfo.do">返回管理全部学生</a>
<c:if test="${empty courseList}">
    <br/><h4>暂无数据</h4>
</c:if>
<c:if test="${!empty courseList}">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h5>此学生选课信息</h5>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12" >
<table style="overflow:scroll;" class="table table-striped table-hover animated fadeIn" align="center">
    <tr>
        <th>编号</th>
        <th>课程名称</th>
        <th>授课教师</th>
        <th>课程学分</th>
        <th>课程学时</th>
        <th>课程得分</th>
    </tr>
    <c:forEach items="${courseList}" var="courseList" varStatus="item">
        <tr>
            <td>${item.index+1}</td>
            <td>${courseList.courseName}</td>
            <td>${courseList.teaName}</td>
            <td>${courseList.courseScore}</td>
            <td>${courseList.courseTime}</td>
            <td>${courseList.score}</td>
        </tr>
    </c:forEach>
</table>
    </div>
    </div>
    </div>
    </div>
</c:if>
</body>
</html>
