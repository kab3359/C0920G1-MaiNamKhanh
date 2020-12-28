<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/21/2020
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Edit</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="http://fonts.googleapis.com/css?family=Karla:400,700" rel="stylesheet">
    <link href="../home/default.css" rel="stylesheet" type="text/css" media="all">
    <link href="../home/fonts.css" rel="stylesheet" type="text/css" media="all">
    <link rel="stylesheet" type="text/css" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div id="wrapper" class="container-fluid">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <img src="../home/logo.PNG">
            </div>
            <div id="name">
                <h1>Mai Nam Khánh - C0920G1</h1>
            </div>
        </div>
    </div>
    <div id="menu-wrapper">
        <div id="menu" >
            <ul>
                <li class="current_page_item"><a href="/home">Homepage</a></li>
                <li class="current_page_item"><a href="/customer">Customer</a></li>
                <li class="current_page_item"><a href="/employee">Employee</a></li>
                <li class="current_page_item"><a href="/contract">Contract</a></li>
                <li class="current_page_item"><a href="/contractDetail">Contact Detail</a></li>
                <li>
                    <form class="form-inline d-flex justify-content-center md-form form-sm mt-0">
                        <%--              <i class="fas fa-search" aria-hidden="true"></i>--%>
                        <input id="myInput" onkeyup="myFunction()" class="form-control form-control-sm ml-3 w-75"
                               type="text" placeholder="Search" aria-label="Search">
                    </form>
                </li>
            </ul>
        </div>
        <!-- end #menu -->
    </div>
    <div id="page" >
        <div id="content">
            <div class="title">
                <h2>Edit Service</h2>
            </div>
            <%--            <button class="btn btn-success" data-toggle="modal" data-target="#add">Add Customer</button>--%>
            <form action="?action=update" method="post">
                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>Service ID:</th>
                        <td>
                            <c:if test="${message != null}">
                                <p style="color: red"><c:out value="${message}"/></p>
                            </c:if>
                            <input type="text" name="id" size="45" value="${service.getId()}">
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
                        <th>Rent Type ID:</th>
                        <td>
                            <select name="rentTypeId" required>
                                <c:forEach var="listRentType" items="${listRentType}">
                                    <c:choose>
                                        <c:when test="${listRentType.id.equals(service.rentTypeId.id)}">
                                            <option value="<c:out value='${listRentType.id}'/>"selected>
                                                <c:out value="${listRentType.name}"></c:out>
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="<c:out value='${listRentType.id}'/>">
                                                <c:out value="${listRentType.name}"></c:out>
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Service Type Id:</th>
                        <td>
                            <select name="serviceTypeId" required>
                                <c:forEach var="listServiceType" items="${listServiceType}">
                                    <c:choose>
                                        <c:when test="${listServiceType.id.equals(service.serviceTypeId.id)}">
                                            <option value="<c:out value='${listServiceType.id}'/>"selected>
                                                <c:out value="${listServiceType.name}"></c:out>
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="<c:out value='${listServiceType.id}'/>">
                                                <c:out value="${listServiceType.name}"></c:out>
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
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
    </div>
</div>


<div id="copyright" >
    <p>© Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>

<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
