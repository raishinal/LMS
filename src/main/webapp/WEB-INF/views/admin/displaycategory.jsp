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
                    <li class="active">Category/Show</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Category</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Category Table</div>
                        <div class="panel-body">
                            <table data-toggle="table" data-url="tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                                <thead>
                                    <tr>
                                        <th data-field="id" data-checkbox="true" >Category ID</th>
                                        <th data-field="title" data-sortable="true">Category Title</th>
                                        <th data-field="tags"  data-sortable="true">Category Tags</th>
                                        <th data-field="description" data-sortable="true">Category Description</th>
                                        <th data-field="type" data-sortable="true">Category Price</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${categorylist}" var="cat">
                                        <tr>
                                            <td>${cat.id}</td>
                                            <td>${cat.title}</td>
                                            <td>${cat.tags}</td>
                                            <td>${cat.description}</td>
                                            <td><c:choose>
                                                    <c:when test="${cat.pid <= 0}">Main</c:when>
                                                    <c:otherwise>Sub</c:otherwise>
                                                </c:choose> 
                                            </td>
                                            <td><a href="<c:url value="/Admin/Category/Edit/${cat.id}"/>">Edit</a></td>
                                            <td><a href="<c:url value="/Admin/Category/Delete/${cat.id}"/>"  onclick="return confirm('Are you sure?')">Delete</a></td>
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
