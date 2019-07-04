<%-- 
    Document   : dashboard
    Created on : Jun 27, 2019, 6:54:04 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin - Dashboard</title>
        <jsp:include page="static.jsp"/>



    </head>

    <body>
        <jsp:include page="header.jsp"/>


   


        </div>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">		
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Icons</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
            </div><!--/.row-->

            <div class="row">
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-blue panel-widget ">
                        <div class="row no-padding">
                            <div class="col-sm-3 col-lg-5 widget-left">
                                <svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
                            </div>
                            <div class="col-sm-9 col-lg-7 widget-right">
                                <div class="large">${no_of_order}</div>
                                <div class="text-muted">New Orders</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-10 col-md-4 col-lg-3">
                    <div class="panel panel-orange panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-2 col-lg-3 widget-left">
                                <svg class="glyph stroked empty-message"><use xlink:href="#stroked-empty-message"></use></svg>
                            </div>
                            <div class="col-sm-4 col-lg-5 widget-right">
                                <div class="large">${no_of_items}</div>
                                <div class="text-muted">New Items</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-teal panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-3 col-lg-5 widget-left">
                                <svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>
                            </div>
                            <div class="col-sm-9 col-lg-7 widget-right">
                                <div class="large">${no_of_users}</div>
                                <div class="text-muted">New Users</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6 col-lg-3">
                    <div class="panel panel-red panel-widget">
                        <div class="row no-padding">
                            <div class="col-sm-2 col-lg-3 widget-left">
                                <svg class="glyph stroked app-window-with-content"><use xlink:href="#stroked-app-window-with-content"></use></svg>
                            </div>
                            <div class="col-sm-11 col-lg-9 widget-right">
                                <div class="large">${pageviewcount} </div>
                                <div class="text-muted">Page Views <a href="<c:url value="/Admin/Pagecount/Reset"/>" onclick="return confirm('Are you sure?')">Reset</a> </div>
                                <div class="text-muted">${pageviewcountdate}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.row-->

            <div class="row">
                <div class="col-md-8">
                      <div class="panel panel-default">
                        <div class="panel-heading">New Orders</div>
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
                                    <c:forEach items="${orderlist}" var="od">
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
                        <div class="panel panel-default">
                        <div class="panel-heading">New Users</div>
                        <div class="panel-body">
                            <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                <thead>
                                    <tr>
                                        <th data-field="Id" data-checkbox="true" >User ID</th>
                                        <th data-field="firstname" data-sortable="true">User first name</th>
                                        <th data-field="lastname"  data-sortable="true">User last name</th>
                                        <th data-field="username" data-sortable="true">username</th>
                                        <th data-field="email" data-sortable="true">user email</th>
                                        <th data-field="status" data-sortable="true">user status</th>
                                        <th data-field="address" data-sortable="true">user address</th>
                                        <th>Edit User</th>
                                        <th>Remove User</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${userlist}" var="user">
                                        <tr>
                                            <td>${user.id}</td>
                                            <td>${user.firstname}</td>
                                            <td>${user.lastname}</td>
                                            <td>${user.userName}</td>
                                            <td>${user.email}</td>
                                            <td>${user.active}</td>
                                            <td>${user.address}</td>

                                            <td><a href="<c:url value="/Admin/User/Edit/${user.id}"/>" onclick="return confirm('Are you sure?')">Edit</a></td>
                                            <td><a href="<c:url value="/Admin/User/Remove/${user.id}"/>" onclick="return confirm('Are you sure?')">Remove</a></td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                     <div class="panel panel-default">
                        <div class="panel-heading">Latest Items</div>
                        <div class="panel-body">
                            <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                <thead>
                                    <tr>
                                        <th data-field="id" data-checkbox="true" >Item ID</th>
                                        <th data-field="name" data-sortable="true">Item Name</th>
                                        <th data-field="category"  data-sortable="true">Item Category</th>
                                        <th data-field="price" data-sortable="true">Item Price</th>
                                        <th>Page</th>
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
                                            <td><a href="<c:url value="/Admin/Item/Edit/${item.id}"/>">Edit</a></td>
                                            <td><a href="<c:url value="/Admin/Item/Delete/${item.id}"/>" onclick="return confirm('Are you sure?')">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                    
                </div><!--/.col-->

                <div class="col-md-4">

                    <div class="panel panel-red">
                        <div class="panel-heading dark-overlay"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>Calendar</div>
                        <div class="panel-body">
                            <div id="calendar"></div>
                        </div>
                    </div>

                    <div class="panel panel-blue">
                        <div class="panel-heading dark-overlay"><svg class="glyph stroked clipboard-with-paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg>Alert List</div>
                        <div class="panel-body">
                            <ul class="todo-list">
                                <c:forEach items="${alerts}" var="al">
                                <li class="todo-list-item">
                                    <div class="checkbox">
                                        <input type="checkbox" id="checkbox" />
                                        <label for="checkbox">${al.title} <span> Cause: ${al.cause}</span></label>
                                    </div>
                                    <div class="pull-right action-buttons">
                                        <a href="<c:url value="/Admin/Alert/Delete/${al.id}"/>" class="trash" onclick="return confirm('Are you sure?')"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg>resolve</a>
                                    </div>
                                </li>
                                </c:forEach>
                              
                            </ul>
                        </div>
                        
                    </div>

                </div><!--/.col-->
            </div><!--/.row-->
        </div>	



        <jsp:include page="js.jsp"/>
    </body>

</html>
