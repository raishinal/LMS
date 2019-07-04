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
        <title>Items List</title>
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
                                    <div class="contact-info-wrap-flex">
                                        <c:if test="${user_type==1}">
                                            <div class="con-info">
                                                <p><span><i class="icon-location-2"></i></span> <a href="<c:url value="/User/Profile"/>">Your personal Detail</a></p>
                                            </div>
                                            <div class="con-info">
                                                <p><span><i class="icon-phone3"></i></span> <a href="<c:url value="/User/ChangePassword"/>">Change Password</a></p>
                                            </div>

                                            <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/User/Order/Show"/>">My orders</a></p>
                                            </div>
                                        </c:if>
                                        <c:if test="${user_type==2}">
                                            <div class="con-info">
                                                <p><span><i class="icon-location-2"></i></span> <a href="<c:url value="/Retailer/Profile"/>">Your personal Detail</a></p>
                                            </div>
                                            <div class="con-info">
                                                <p><span><i class="icon-phone3"></i></span> <a href="<c:url value="/Retailer/ChangePassword"/>">Change Password</a></p>
                                            </div>
                                            <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/Retailer/Items/Add"/>">Add Items</a></p>
                                            </div>

                                            <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/Retailer/Items/Show"/>">My Items</a></p>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 animate-box">
                        <div class="panel-body">
                        <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                <thead>
                                    <tr>
                                        <th data-field="id" data-checkbox="true" >Item ID</th>
                                        <th data-field="name" data-sortable="true">Item Name</th>
                                        <th data-field="category"  data-sortable="true">Item Category</th>
                                        <th data-field="price" data-sortable="true">Item Price</th>
                                        <th>In page</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${itemlist}" var="item">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td>${item.category}</td>
                                            <td>${item.price}</td>

                                            <td><a href="<c:url value="/Item/${item.id}"/>">Page</a></td>
                                            <td><a href="<c:url value="/Retailer/Item/Edit/${item.id}"/>">Edit</a></td>
                                            <td><a href="<c:url value="/Retailer/Item/Delete/${item.id}"/>" onclick="return confirm('Are you sure?')">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
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
