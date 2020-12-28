<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/14/2020
  Time: 11:02 AM
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
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
    <a href="?action=new">Add New Customer</a>
    <a href="customer">List All Customer</a>
</h2>
<h2 style="text-align: center">List Of Customer</h2>
<form action="?action=search" method="post">
    <input type="text" name="search" size="45">
</form>
<div class="container" align="center">
    <table class="table table-striped table-hover table-bordered" >
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Function</th>
        </tr>
        <tr>
        <c:forEach items="${listCustomer}" var="customer" >
            <td><c:out value="${customer.getId()}"/></td>
            <td><c:out value="${customer.getName()}"/></td>
            <td><c:out value="${customer.getPhone()}"/></td>
            <td><c:out value="${customer.getEmail()}"/></td>
            <td>

                <button class=" btn btn-primary" type="button"><a class="text-white"
                                                                  style="text-decoration: none" href="?action=edit&id=<c:out value='${customer.getId()}'/>">Edit</a></button>

                <button class=" btn btn-danger" type="button"><a class="text-white"
                                                                 style="text-decoration: none" href="?action=delete&id=<c:out value='${customer.getId()}'/>">Delete</a></button>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
