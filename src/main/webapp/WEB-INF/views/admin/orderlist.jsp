<%-- 
    Document   : displaycategory
    Created on : Jun 27, 2019, 4:00:19 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Display Category</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Order/Show</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Orders</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Order Table</div>
                        <div class="panel-body">
                            <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                 <thead>
                                    <tr>
                                        <th data-field="id" data-checkbox="true" >Cart ID</th>
                                        <th data-field="name" data-sortable="true">Item name</th>
                                        <th data-field="quantity"  data-sortable="true">Quantity</th>
                                        <th data-field="price" data-sortable="true">Price</th>
                                        <th data-field="date" data-sortable="true">Order Date</th>
                                        <th>Delivered</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orders}" var="od">
                                        <tr>
                                            <td>${od.id}</td>
                                            <td>${od.productname}</td>
                                            <td>${od.quantity}</td>
                                            <td>${od.price}</td>
                                            <td>${od.orderdate}</td>
                                            <td><a href="<c:url value="/Admin/Order/Delivered/${od.id}"/>" onclick="return confirm('Are you sure?')">Delivered</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div><!--/.row-->	
            <div class="row">

            </div><!--/.main-->
            <jsp:include page="js.jsp"/>
    </body>
</html>
