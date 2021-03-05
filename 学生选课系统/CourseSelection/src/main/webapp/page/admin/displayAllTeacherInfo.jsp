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
    <!--<style>
        table,table tr th, table tr td { border:1px solid red; }
    </style>-->
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

<c:if test="${empty allTeacherInfoList}">
    <br/><h2>暂无数据</h2>
</c:if>

<c:if test="${!empty allTeacherInfoList}">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h5>管理全部教师信息</h5>
        </div>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12" >
    <table style="overflow:scroll;" class="table table-striped table-hover animated fadeIn" align="center">
        <tr>
            <th>编号</th>
            <th>工号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>密码</th>
            <th>学院</th>
            <th>职称</th>
            <th>联系方式</th>
            <th>查看开课选课信息</th>
            <th>修改信息</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${allTeacherInfoList}" var="allTeacherInfoList" varStatus="item">
            <tr>
                <td>${item.index+1}</td>
                <td>${allTeacherInfoList.tea_id}</td>
                <td>${allTeacherInfoList.username}</td>
                <td>${allTeacherInfoList.age}</td>
                <td>${allTeacherInfoList.password}</td>
                <td>${allTeacherInfoList.college}</td>
                <td>${allTeacherInfoList.professionalTitle}</td>
                <td>${allTeacherInfoList.phoneNumber}</td>
                <td><a href="/admin/displaySingleTeacherCheckedCourseInfo.do?teacherName=${allTeacherInfoList.username}">查看开课信息</a></td>
                <td><a href="/admin/displaySingleTeacherSelfInfo.do?teacherName=${allTeacherInfoList.username}">修改信息</a></td>
                <td><a href="/admin/deleteTeacher.do?teacherName=${allTeacherInfoList.username}">解雇</a></td>
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