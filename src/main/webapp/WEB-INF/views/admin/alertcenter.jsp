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
                                        <th data-field="id" data-checkbox="true" >Alert Id</th>
                                        <th data-field="title" data-sortable="true">Alert Title</th>
                                        <th data-field="tags"  data-sortable="true">Alert cause</th>
                                        <th data-field="description" data-sortable="true">Alert detail</th>
                                        <th data-field="type" data-sortable="true">Alert date</th>
                                        <th data-field="type" data-sortable="true">Alert related Id</th>
                                        <th>Resolved</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${alerts}" var="al">
                                        <tr>
                                            <td>${al.id}</td>
                                            <td>${al.title}</td>
                                            <td>${al.cause}</td>
                                            <td>${al.detail}</td>
                                            <td>${al.date}</td>
                                            <td>${al.relatedid}</td>
                                            <td><a href="<c:url value="/Admin/Alert/Delete/${cat.id}"/>"  onclick="return confirm('Are you sure?')">Resolved</a></td>
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
