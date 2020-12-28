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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body onload="isError('${message}')">
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
                <h2>List All Service</h2>
            </div>
            <%--            <button class="btn btn-success" data-toggle="modal" data-target="#add">Add Customer</button>--%>
            <button class="btn btn-success" data-toggle="modal" data-target="#addNew">Add Service</button>
            <div align="center">
                <table class="table table-striped table-hover table-bordered" id="tableStudent">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Area</th>
                        <th>Cost</th>
                        <th>Max People</th>
                        <th>Rent Type ID</th>
                        <th>Service Type Id</th>
                        <th>Standard Room</th>
                        <th>Description</th>
                        <th>Pool Area</th>
                        <th>Num Floor</th>
                        <th>Function</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listService}" var="service" >
                        <tr>
                            <td><c:out value="${service.getId()}"/></td>
                            <td><c:out value="${service.getName()}"/></td>
                            <td><c:out value="${service.getArea()}"/></td>
                            <td><c:out value="${service.getCost()}"/></td>
                            <td><c:out value="${service.getMaxPeople()}"/></td>
                            <td><c:out value="${service.getRentTypeId().getName()}"/></td>
                            <td><c:out value="${service.getServiceTypeId().getName()}"/></td>
                            <td><c:out value="${service.getStandardRoom()}"/></td>
                            <td><c:out value="${service.getDescription()}"/></td>
                            <td><c:out value="${service.getPoolArea()}"/></td>
                            <td><c:out value="${service.getNumFloor()}"/></td>
                            <td>

                                <button class=" btn btn-primary" type="button"><a class="text-white"
                                                                                  style="text-decoration: none" href="?action=edit&id=<c:out value='${service.getId()}'/>">Edit</a></button>

                                    <%--          <button class=" btn btn-danger" type="button" onclick="return confirm()" ><a class="text-white"--%>
                                    <%--           style="text-decoration: none" href="?action=delete&id=<c:out value='${customer.getId()}'/>">Delete</a></button>--%>

                                <button id="btn-confirm" type="button" class="btn btn-primary" data-toggle="modal" data-target="#<c:out value='${service.getId()}'/>">
                                    delete
                                </button>
                            </td>
                        </tr>
                        <div class="modal fade" id="<c:out value='${service.getId()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Delete Service</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure delete <c:out value='${service.getId()}'/>
                                    </div>
                                    <div class="modal-footer">
                                        <button id="btn-no" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <a href="?action=delete&id=<c:out value='${service.getId()}'/>">
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
            <div class="modal-body" style="overflow: auto" >
                <form action="../service?action=create" method="post">
                    <table class="table table-striped table-hover table-bordered" >
                        <tr>
                            <th>Service ID:</th>
                            <td>
                                <input type="text" name="id" size="45" value="${service.getId()}">
                                <c:if test="${messageId != null}">
                                    <p style="color: red"><c:out value="${messageId}"/></p>
                                </c:if>
                                <c:if test="${messageDupplicate != null}">
                                <p style="color: red"><c:out value="${messageDupplicate}"/></p>
                                </c:if>
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
                                <c:if test="${messageArea != null}">
                                    <p style="color: red"><c:out value="${messageArea}"/></p>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>Cost:</th>
                            <td>
                                <input type="text" name="cost" size="45" value="${service.getCost()}" required>
                                <c:if test="${messageCost != null}">
                                    <p style="color: red"><c:out value="${messageCost}"/></p>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>Max People:</th>
                            <td>
                                <input type="text" name="maxPeople" size="45" value="${service.getMaxPeople()}" required>
                                <c:if test="${messageMaxPeople != null}">
                                    <p style="color: red"><c:out value="${messageMaxPeople}"/></p>
                                </c:if>
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
                                <c:if test="${messagePoolArea != null}">
                                    <p style="color: red"><c:out value="${messagePoolArea}"/></p>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>Num Floor:</th>
                            <td>
                                <input type="text" name="numFloor" size="45" value="${service.getNumFloor()}" required>
                                <c:if test="${messageNumFloor != null}">
                                    <p style="color: red"><c:out value="${messageNumFloor}"/></p>
                                </c:if>
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
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <div class="modal-content">
            <div class="modal-header justify-content-center">
                <div class="icon-box">
                    <i class="material-icons">&#xE876;</i>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body text-center">
                <h4>Great!</h4>
                <c:if test="${message == 'access'}">
                    <p>New service has been created successfully.</p>
                </c:if>
                <c:if test="${message == 'delete'}">
                    <p>Service has been delete successfully.</p>
                </c:if>
                <c:if test="${message == 'edit'}">
                    <p>Service has been edit successfully.</p>
                </c:if>
            </div>
        </div>
    </div>
</div>

<div id="copyright" >
    <p>Design by KhanhMN1</p>
</div>

<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>--%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
    function isError(message) {
        if (message === "error") {
            $('#addNew').modal('show');
        }else if (message === "access" || message === "delete" || message === "edit"){
            $('#myModal').modal('show');
        }
    }
</script>
</body>
</html>
