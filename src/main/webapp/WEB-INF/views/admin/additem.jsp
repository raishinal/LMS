<%-- 
    Document   : additem
    Created on : Jun 28, 2019, 9:06:33 AM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Add Item</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Item/Add</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Item</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Add Product</div>
                        <div class="panel-body">
                            <div class="col-md-6">


                                <form role="form" action="<c:url value="/Admin/Item/Add?${_csrf.parameterName}=${_csrf.token}"/>" method="post" enctype="multipart/form-data">

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="form-group">
                                        <label>Item Name</label>
                                        <input class="form-control" type="text" placeholder="Item name here..." name="name">
                                        <p class="help-block">${error_title}</p>
                                    </div>

                                    <div class="form-group">
                                        <label>Stock</label>
                                        <input class="form-control" type="number" placeholder="How many in stock" name="stock">
                                        <p class="help-block">${error_title}</p>
                                    </div>

                                    <div class="form-group">
                                        <label>Item Price</label>
                                        <input class="form-control" type="text" placeholder="Item Price here.." name="price">
                                        <p class="help-block">${error_tag}</p>
                                    </div>

                                    <div class="form-group">
                                        <label>Item Description</label>
                                        <textarea class="form-control" name="description" rows="7"></textarea>
                                    </div>


                                    <div class="form-group">
                                        <label>Choose Category</label>
                                        <select class="form-control" name="category">

                                            <c:forEach items="${categorylist}" var="cat">
                                                <option value="${cat.id}"> ${cat.title}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Choose Tags</label>
                                        <select class="form-control" name="tags">

                                            <c:forEach items="${tagslist}" var="t">
                                                <option value="${t.tags}"> ${t.tags}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Item Image</label>
                                        <input type="file" name="image" placeholder="Select image file">
                                        <p class="help-block"></p>
                                    </div>

                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button type="reset" class="btn btn-default">Reset Button</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

        </div><!--/.main-->
        <jsp:include page="js.jsp"/>
    </body>
</html>
