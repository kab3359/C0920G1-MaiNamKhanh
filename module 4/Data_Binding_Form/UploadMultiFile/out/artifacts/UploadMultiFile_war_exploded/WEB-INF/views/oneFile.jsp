<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 12/13/2019
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form id="formUploadFile" method="POST" action="uploadOneFile" enctype="multipart/form-data" modelAttribute="myFile">
    File: <input type="file" name="multipartFile" /> <br /> <br/>
    Description: <form:input path="description"/> <br />
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>
