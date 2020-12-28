<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/12/2020
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form method="post" action="${pageContext.request.contextPath}/display-discount">
    <label>Product Description: </label>
    <input type="text" name="productDescription" placeholder="Enter Description: "/><br>
    <label>List Price: </label>
    <input type="text" name="price" placeholder="Enter Price: "/><br>
    <label>Discount Percent: </label>
    <input type="text" name="discountPercent" placeholder="Enter Percent: "/><br>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>
