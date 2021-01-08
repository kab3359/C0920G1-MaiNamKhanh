<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 12/31/2020
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/create" method="post">
    <div>
        <label>ID:</label>
        <input type="text" name="id">
    </div>
    <div>
        <label>Name:</label>
        <input type="text" name="name">
    </div>
    <input type="submit" value="create">
</form>
</body>
</html>
