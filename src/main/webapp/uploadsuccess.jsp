<%--
  Created by IntelliJ IDEA.
  User: aTwo
  Date: 2020/10/17
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <img src="upload/${file}">
    <p>文件名:${file}</p>
     <a href="/download?filename=${file}">文件下载</a>
</body>
</html>
