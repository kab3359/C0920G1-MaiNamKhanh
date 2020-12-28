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

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Customer Management Application </title>
    <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS tạo nút bấm di chuyển trang end -->
  <script type="text/javascript">

    $(function () {
      let pageSize = 2; // Hiển thị số sản phẩm trên 1 trang
      showPage = function (page) {
        $(".contentPage").hide();
        $(".contentPage").each(function (n) {
          if (n >= pageSize * (page - 1) && n < pageSize * page)
            $(this).show();
        });
      }
      showPage(1);
      ///** Cần truyền giá trị vào đây **///
      let totalRows = <c:out value="${countCustomer}"/>; // Tổng số sản phẩm hiển thị
      let btnPage = 5; // Số nút bấm hiển thị di chuyển trang
      let iTotalPages = Math.ceil(totalRows / pageSize);

      let obj = $('#pagination').twbsPagination({
        totalPages: iTotalPages,
        visiblePages: btnPage,
        onPageClick: function (event, page) {
          console.info(page);
          showPage(page);
        }
      });
      console.info(obj.data());
    });
  </script>
    <style>
        /** CSS căn id pagination ra giữa màn hình **/
        #pagination {
            display: flex;
            display: -webkit-flex; /* Safari 8 */
            flex-wrap: wrap;
            -webkit-flex-wrap: wrap; /* Safari 8 */
            justify-content: center;
            -webkit-justify-content: center;
        }
    </style>
</head>
<body>

<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
  <a href="?action=new">Add New Customer</a>
  <a href="?action=index">List All Customer</a>
</h2>
<h2 style="text-align: center">List Of Customer</h2>
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
  <table class="table table-striped table-hover table-bordered" >
    <tr>
      <th>Id</th>
      <th>TypeId</th>
      <th>Name</th>
      <th>Birthday</th>
      <th>Gender</th>
      <th>IdCard</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Address</th>
      <th>Function</th>
    </tr>

    <c:forEach items="${listCustomer}" var="customer" >
    <tr class="contentPage">
        <td><c:out value="${customer.getId()}"/></td>
        <td><c:out value="${customer.getTypeId()}"/></td>
        <td><c:out value="${customer.getName()}"/></td>
        <td><c:out value="${customer.getBirthday()}"/></td>
        <td><c:out value="${customer.getGender()}"/></td>
        <td><c:out value="${customer.getIdCard()}"/></td>
        <td><c:out value="${customer.getPhone()}"/></td>
        <td><c:out value="${customer.getEmail()}"/></td>
        <td><c:out value="${customer.getAddress()}"/></td>
        <td>

          <button class=" btn btn-primary" type="button"><a class="text-white"
            style="text-decoration: none" href="?action=edit&id=<c:out value='${customer.getId()}'/>">Edit</a></button>

<%--          <button class=" btn btn-danger" type="button" onclick="return confirm()" ><a class="text-white"--%>
<%--           style="text-decoration: none" href="?action=delete&id=<c:out value='${customer.getId()}'/>">Delete</a></button>--%>

          <button id="btn-confirm" type="button" class="btn btn-primary" data-toggle="modal" data-target="#<c:out value='${customer.getId()}'/>">
            delete
          </button>
        </td>
      </tr>
      <div class="modal fade" id="<c:out value='${customer.getId()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              ...<c:out value='${customer.getId()}'/>
            </div>
            <div class="modal-footer">
              <button id="btn-no" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <button id="btn-ok" type="button" class="btn-ok btn btn-primary"><a href="?action=delete&id=<c:out value='${customer.getId()}'/>"> Delete</a>
              </button>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </table>
  <ul id="pagination"></ul>
</div>

</body>
</html>
