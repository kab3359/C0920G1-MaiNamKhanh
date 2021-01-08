<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/31/2020
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/money", method="post">
<label>USD:</label>
<input type="text" name="usd">
<label>VND:</label>
<input type="text" name="vnd" value="${rs}">
<button type="submit">Chuyển</button>
</form>
</body>
</html>
