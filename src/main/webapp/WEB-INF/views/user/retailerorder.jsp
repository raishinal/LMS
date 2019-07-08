<%-- 
    Document   : contact
    Created on : Jun 29, 2019, 12:08:05 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <link href="<c:url value="/resources/admin/css/bootstrap-table.css"/>" rel="stylesheet">
        <title>Order Page</title>
    </head>
    <body>
        <div class="colorlib-loader"></div>

        <div id="page">
            <jsp:include page="header.jsp"/>
            <div class="colorlib-intro">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center">
                            <div class="intro">
                                <h1>Welcome ${username}</h1>
                                <p><span><a href="<c:url value="/Index"/>">Home</a></span> / <span>Profile</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="colorlib-contact">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 animate-box">
                            <h2 class="contact-head">Your Information</h2>
                            <div class="row">
                                <div class="col-md-12">
                               <jsp:include page="sidebar.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 animate-box">
                            <h2 class="contact-head">Your orders</h2>
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
                                    <c:forEach items="${order}" var="od">
                                        <tr>
                                            <td>${od.id}</td>
                                            <td>${od.productname}</td>
                                            <td>${od.quantity}</td>
                                            <td>${od.price}</td>
                                            <td>${od.orderdate}</td>
                                            <td><a href="<c:url value="/Retailer/Order/Delivered/${od.id}"/>" onclick="return confirm('Are you sure?')">Delivered</a></td>
                                       
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                          		
                        </div>
                    </div>
                </div>
            </div>

            <div id="map" class="colorlib-map"></div>

            <jsp:include page="footer.jsp"/>
        </div>
           <script src="<c:url value="/resources/admin/js/bootstrap-table.js"/>"></script>

    </body>
</html>
