<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/14/2020
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<html>
<head>
    <title>Customer Management Application </title>
</head>
<body>
<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
    <a href="new">Add New Customer</a>
    <a href="index">List All Customer</a>
</h2>
<h2 style="text-align: center">List Of Customer</h2>
<form action="/searchById" method="post" style="align-content: center">
    <input type="text" name="search" size="45" placeholder="Search by Id">
    <c:if test="${message != null}">
        <p style="color: red"><c:out value="${message}"/></p>
    </c:if>
</form>
<form action="/searchByName" method="post" style="align-content: center">
    <input type="text" name="search" size="45" placeholder="Search by name">
    <c:if test="${message != null}">
        <p style="color: red"><c:out value="${message}"/></p>
    </c:if>
</form>
<div class="container" align="center">
    <table class="table table-striped table-hover table-bordered" >
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>

        <c:forEach items="${listCustomerType}" var="customerType" >
            <tr>
                <td><c:out value="${customerType.getTypeId()}"/></td>
                <td><c:out value="${customerType.getTypeName()}"/></td>
                <td>

                    <button class=" btn btn-primary" type="button"><a class="text-white"
                                                                      style="text-decoration: none" href="edit?id=<c:out value='${customerType.getTypeId()}'/>">Edit</a></button>

                    <button class=" btn btn-danger" type="button"><a class="text-white"
                                                                     style="text-decoration: none" href="delete?id=<c:out value='${customerType.getTypeId()}'/>">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
