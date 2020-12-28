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
    <title>List Service</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="http://fonts.googleapis.com/css?family=Karla:400,700" rel="stylesheet">
    <link href="../home/default.css" rel="stylesheet" type="text/css" media="all">
    <link href="../home/fonts.css" rel="stylesheet" type="text/css" media="all">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../datatables/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <link rel="stylesheet prefetch" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>

</head>
<body onload="myFunction('${message}')">
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
                <li class="current_page_item"><a href="/service">Service</a></li>
                <li class="current_page_item"><a href="/employee">Employee</a></li>
                <li class="current_page_item"><a href="/contractDetail">Contact Detail</a></li>
                <li>
                    <form class="form-inline d-flex justify-content-center md-form form-sm mt-0" action="?action=search" method="post">
                        <%--              <i class="fas fa-search" aria-hidden="true"></i>--%>
                        <input id="myInput" class="form-control form-control-sm ml-3 w-75"
                               type="text" placeholder="Search" aria-label="Search" name="search_service">
                    </form>
                </li>
            </ul>
        </div>
        <!-- end #menu -->
    </div>
    <div id="page" >
        <div id="content">
            <div class="title">
                <h2>List All Contract</h2>
            </div>
            <%--            <button class="btn btn-success" data-toggle="modal" data-target="#add">Add Customer</button>--%>
            <button class="btn btn-success" data-toggle="modal" data-target="#addNew">Add Service</button>
            <a href="?action=cusUseSer">
                <button class="btn btn-success">Show Customer Having Contract</button>
            </a>

            <div align="center">
                <table class="table table-striped table-hover table-bordered" id="tableStudent">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Deposit</th>
                        <th>Total Money</th>
                        <th>Employee</th>
                        <th>Service</th>
                        <th>Customer</th>
                        <th>Function</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listContract}" var="contract" >
                        <tr>
                            <td><c:out value="${contract.getId()}"/></td>
                            <td><c:out value="${contract.getStartDate()}"/></td>
                            <td><c:out value="${contract.getEndDate()}"/></td>
                            <td><c:out value="${contract.getDeposit()}"/></td>
                            <td><c:out value="${contract.getTotalMoney()}"/></td>
                            <td><c:out value="${contract.getEmployeeId().getName()}"/></td>
                            <td><c:out value="${contract.getServiceId().getName()}"/></td>
                            <td><c:out value="${contract.getCustomerId().getName()}"/></td>
                            <td>

<%--                                <button class=" btn btn-primary" type="button"><a class="text-white"--%>
<%--                                                                                  style="text-decoration: none" href="?action=edit&id=<c:out value='${contract.getId()}'/>">Edit</a></button>--%>
                            <a href="?action=edit&id=<c:out value='${contract.getId()}'/>">
                                <button type="button" class="btn btn-primary" data-toggle="modal">Edit</button>
                            </a>


                                <button id="btn-confirm" type="button" class="btn btn-primary" data-toggle="modal" data-target="#<c:out value='${contract.getId()}'/>">
                                    delete
                                </button>
                            </td>
                        </tr>
                        <div class="modal fade" id="<c:out value='${contract.getId()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ...<c:out value='${contract.getId()}'/>
                                    </div>
                                    <div class="modal-footer">
                                        <button id="btn-no" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <a href="?action=delete&id=<c:out value='${contract.getId()}'/>">
                                            <button id="btn-ok" type="button" class="btn-ok btn btn-primary">
                                                Delete
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="overflow: hidden">
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
                            <th>Start Date:</th>
                            <td>
                                <input id="myVariable" type="date" name="startDate" size="45" required>
                            </td>
                        </tr>
                        <tr>
                            <th>End Date:</th>
                            <td>
                                <input type="date" name="endDate" size="45" value="${service.getArea()}" required>
                            </td>
                        </tr>
                        <tr>
                            <th>Deposit:</th>
                            <td>
                                <input type="text" name="deposit" size="45" value="${service.getCost()}" required>
                            </td>
                        </tr>
                        <tr>
                            <th>Total Money:</th>
                            <td>
                                <input type="text" name="totalMoney" size="45" value="${service.getMaxPeople()}" required>
                            </td>
                        </tr>
                        <tr>
                            <th>Employee:</th>
                            <td>
                                <select name="employeeId">
                                <c:forEach var="listEmployee" items="${listEmployee}">
                                    <c:choose>
                                        <c:when test="${listEmployee.id.equals(contract.employeeId.id)}">
                                            <option value="<c:out value='${listEmployee.id}'/>"selected>
                                                <c:out value="${listEmployee.name}"></c:out>
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>select employee</option>
                                            <option value="<c:out value='${listEmployee.id}'/>">
                                                <c:out value='${listEmployee.id}'/>
                                                <c:out value="${listEmployee.name}"></c:out>
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Service:</th>
                            <td>
                                <select name="serviceId">
                                    <c:forEach var="listService" items="${listService}">
                                        <c:choose>
                                            <c:when test="${listService.id.equals(contract.serviceId.id)}">
                                                <option value="<c:out value='${listService.id}'/>"selected>
                                                    <c:out value="${listService.name}"></c:out>
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option>select service</option>
                                                <option value="<c:out value='${listService.id}'/>">
                                                    <c:out value='${listService.id}'/>
                                                    <c:out value="${listService.name}"></c:out>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Customer:</th>
                            <td>
                                <select name="customerId">
                                    <c:forEach var="listCustomer" items="${listCustomer}">
                                        <c:choose>
                                            <c:when test="${listCustomer.id.equals(contract.customerId.id)}">
                                                <option value="<c:out value='${listCustomer.id}'/>"selected>
                                                    <c:out value="${listCustomer.name}"></c:out>
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option>select customer</option>
                                                <option value="<c:out value='${listCustomer.id}'/>">
                                                    <c:out value='${listCustomer.id}'/>
                                                    <c:out value="${listCustomer.name}"></c:out>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
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
</div>
<div id="copyright" >
    <p>© Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>

<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>--%>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>


<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script type="text/javascript">
    function myFunction(message) {
        if (message) {
            $('#addNew').modal('show');
        }
    }
</script>
<script>
    $(document).ready(function () {
        $('select').selectize({
            sortField: 'text'
        });
    });
</script>
</body>
</html>
