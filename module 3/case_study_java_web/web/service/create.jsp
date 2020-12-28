<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/14/2020
  Time: 3:04 AM
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
<h1 style="text-align: center"><a href="?action=index">List All Service</a> </h1>
<h3 style="text-align: center">Add New Service </h3>
<div align="center">
    <form action="?action=create" method="post">
        <table class="table table-striped table-hover table-bordered">
            <tr>
                <th>ID:</th>
                <td>
                    <c:if test="${message != null}">
                        <p style="color: red"><c:out value="${message}"/></p>
                    </c:if>
                    <input type="text" name="id" size="45">
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="${service.getName()}" required>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="area" size="45" value="${service.getArea()}" required>
                </td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td>
                    <input type="text" name="cost" size="45" value="${service.getCost()}" required>
                </td>
            </tr>
            <tr>
                <th>Max People:</th>
                <td>
                    <input type="text" name="maxPeople" size="45" value="${service.getMaxPeople()}" required>
                </td>
            </tr>
            <tr>
                <th>Type Rent ID:</th>
                <td>
                    <input type="text" name="rentTypeId" size="45" value="${service.getRentTypeId()}" required>
                </td>
            </tr>
            <tr>
                <th>Service Type Id:</th>
                <td>
                    <input type="text" name="serviceTypeId" size="45" value="${service.getServiceTypeId()}" required>
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <input type="text" name="standardRoom" size="45" value="${service.getStandardRoom()}" required>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="45" value="${service.getDescription()}" required>
                </td>
            </tr>
            <tr>
                <th>Pool Area:</th>
                <td>
                    <input type="text" name="poolArea" size="45" value="${service.getPoolArea()}" required>
                </td>
            </tr>
            <tr>
                <th>Num Floor:</th>
                <td>
                    <input type="text" name="numFloor" size="45" value="${service.getNumFloor()}" required>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" class="btn btn-success text-white">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
