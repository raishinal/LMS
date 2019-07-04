<%-- 
    Document   : manageuser
    Created on : Jun 29, 2019, 2:13:02 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>UserMangagement Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Users</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">User Management</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">User List</div>
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
                </div>
            </div><!--/.row-->	
            <div class="row">

            </div><!--/.main-->
            <jsp:include page="js.jsp"/>
    </body>
</html>
