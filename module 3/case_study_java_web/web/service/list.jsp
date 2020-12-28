<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/14/2020
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../bootstrap413/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../datatables/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Service Management Application </title>

</head>
<body>

<h1 style="text-align: center">Service Management</h1>
<h2 style="text-align: center">
    <a href="?action=new">Add New Service</a>
    <a href="?action=index">List All Service</a>
</h2>
<h2 style="text-align: center">List Of Service</h2>
<form action="?action=searchById" method="post" style="align-content: center">
    <input type="text" name="search" size="45" placeholder="Search by Id">
    <c:if test="${message != null}">
        <p style="color: red"><c:out value="${message}"/></p>
    </c:if>
</form>
<form action="?action=searchByName" method="post" style="align-content: center">
    <input type="text" name="search" size="45" placeholder="Search by name">
    <c:if test="${message != null}">
        <p style="color: red"><c:out value="${message}"/></p>
    </c:if>
</form>
<div class="container" align="center">
    <table id="tableStudent" class="table table-striped table-hover table-bordered" style="width: 100%">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max People</th>
            <th>ID Rent Type</th>
            <th>Id Service Type</th>
            <th>Standard Room</th>
            <th>Description</th>
            <th>Pool Area</th>
            <th>Num Floor</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listService}" var="service">
            <tr>
                <td><c:out value="${service.getId()}"/></td>
                <td><c:out value="${service.getName()}"/></td>
                <td><c:out value="${service.getArea()}"/></td>
                <td><c:out value="${service.getCost()}"/></td>
                <td><c:out value="${service.getMaxPeople()}"/></td>
                <td><c:out value="${service.getRentTypeId()}"/></td>
                <td><c:out value="${service.getServiceTypeId()}"/></td>
                <td><c:out value="${service.getStandardRoom()}"/></td>
                <td><c:out value="${service.getDescription()}"/></td>
                <td><c:out value="${service.getPoolArea()}"/></td>
                <td><c:out value="${service.getNumFloor()}"/></td>
                <td>

                    <button class=" btn btn-primary" type="button"><a class="text-white"
                                                                      style="text-decoration: none"
                                                                      href="?action=edit&id=<c:out value='${service.getId()}'/>">Edit</a>
                    </button>

                        <%--          <button class=" btn btn-danger" type="button" onclick="return confirm()" ><a class="text-white"--%>
                        <%--           style="text-decoration: none" href="?action=delete&id=<c:out value='${customer.getId()}'/>">Delete</a></button>--%>

                    <button id="btn-confirm" type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#<c:out value='${service.getId()}'/>">
                        delete
                    </button>
                </td>
            </tr>

                    <div class="modal fade" id="<c:out value='${service.getId()}'/>" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    ...<c:out value='${service.getId()}'/>
                                </div>
                                <div class="modal-footer">
                                    <button id="btn-no" type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                    </button>
                                    <button id="btn-ok" type="button" class="btn-ok btn btn-primary"><a
                                            href="?action=delete&id=<c:out value='${service.getId()}'/>"> Delete</a>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
        </c:forEach>
        </tbody>
    </table>
    <%--    <ul id="pagination"></ul>--%>
</div>
<%--<script src="../bootstrap413/js/bootstrap.min.js"></script>--%>
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
