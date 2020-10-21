<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="/test?username=zs&age=20">aaa</a>
<form action="/restful" method="get">
    <input type="hidden" name="_method" value="get">
    <input type="submit" value="get">
</form>
<form action="/restful" method="post">
    <input type="hidden" name="_method" value="post">
    <input type="submit" value="post">
</form>
<form action="/restful" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="delete">
</form>
<form action="/restful" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="put">
</form>

<form action="/fileup" method="post" enctype="multipart/form-data">
    文件:<input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
