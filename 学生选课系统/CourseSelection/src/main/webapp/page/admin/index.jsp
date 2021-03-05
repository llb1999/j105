<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/28 0028
  Time: 下午 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
<link href="../../css/flat-ui.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
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
</nav>

</body>
</html>
