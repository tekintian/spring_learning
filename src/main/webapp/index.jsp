<%--
  @User: Tekin   @Date: 2018/6/1  @Time: 23:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Hello World Demo</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <ul style="margin-top: 5rem;">
        <li><a href="<%=basePath %>hello">Hello demo</a></li>
        <li><a href="<%=basePath %>hello/p1">Hello p1 demo</a></li>
    </ul>
</div>

</body>
</html>