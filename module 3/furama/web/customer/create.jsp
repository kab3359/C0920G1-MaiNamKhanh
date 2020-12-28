<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/21/2020
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Retention</title>
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
                <li class="current_page_item"><a href="#">Homepage</a></li>
                <li class="current_page_item"><a href="#">About</a></li>
                <li class="current_page_item"><a href="#">Blog</a></li>
                <li class="current_page_item"><a href="#">Portfolio</a></li>
                <li class="current_page_item"><a href="#">Contact</a></li>
                <li>
                    <form class="form-inline d-flex justify-content-center md-form form-sm mt-0" action="?action=search" method="post">
                        <%--              <i class="fas fa-search" aria-hidden="true"></i>--%>
                        <input id="myInput" onkeyup="myFunction()" class="form-control form-control-sm ml-3 w-75"
                               type="text" placeholder="Search" aria-label="Search" name="search_customer">
                    </form>
                </li>
            </ul>
        </div>
        <!-- end #menu -->
    </div>
    <div id="page" >
        <div id="content" class="col-lg-10">
            <div class="title">
                <h2>Add New Customer</h2>
            </div>
            <form action="../customer?action=create" method="post">
                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>Customer ID:</th>
                        <td>
                            <c:if test="${message != null}">
                                <p style="color: red"><c:out value="${message}"/></p>
                            </c:if>
                            <input type="text" name="id" size="45">
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Type ID:</th>
                        <td>
                            <input type="text" name="typeId" size="45" value="${customer.getTypeId()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Name:</th>
                        <td>
                            <input type="text" name="name" size="45" value="${customer.getName()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Birthday:</th>
                        <td>
                            <input type="date" name="birthday" size="45" value="${customer.getBirthday()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Gender:</th>
                        <td>
                            <input type="text" name="gender" size="45" value="${customer.getGender()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Id Card:</th>
                        <td>
                            <input type="text" name="idCard" size="45" value="${customer.getIdCard()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Phone:</th>
                        <td>
                            <input type="text" name="phone" size="45" value="${customer.getPhone()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Email:</th>
                        <td>
                            <input type="text" name="email" size="45" value="${customer.getEmail()}" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer Address:</th>
                        <td>
                            <input type="text" name="address" size="45" value="${customer.getAddress()}" required>
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
        <div id="sidebar" class="col-lg-2">
            <div class="box2">
                <div class="title">
                    <h2>Integer gravida</h2>
                </div>
                <ul class="style2">
                    <li><a href="#">Amet turpis, feugiat et sit amet</a></li>
                    <li><a href="#">Ornare in hendrerit in lectus</a></li>
                    <li><a href="#">Semper mod quis eget mi dolore</a></li>
                    <li><a href="#">Quam turpis feugiat sit dolor</a></li>
                    <li><a href="#">Amet ornare in hendrerit in lectus</a></li>
                    <li><a href="#">Quam turpis feugiat sit dolor</a></li>
                    <li><a href="#">Consequat etiam lorem phasellus</a></li>
                </ul>
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

</body>
</html>
