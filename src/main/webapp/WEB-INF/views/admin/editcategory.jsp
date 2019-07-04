<%-- 
    Document   : editcategory
    Created on : Jun 27, 2019, 4:00:32 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Edit Category</title>
    </head>
    <body>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Category/Edit</li>
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
					<div class="panel-heading">Edit Category</div>
					<div class="panel-body">
						<div class="col-md-6">
							 
                             
                              <form role="form" action="<c:url value="/Admin/Category/Update"/>" method="post">
                                        <c:forEach items="${category}" var="c">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <div class="form-group">
                                            <label>Category ID</label>
                                            <input class="form-control" type="number" value="${c.id}" name="id" readonly>
                                             <p class="help-block">${error_title}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Category Title</label>
                                            <input class="form-control" type="text" value="${c.title}" name="title">
                                             <p class="help-block">${error_title}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Category Tag</label>
                                            <input class="form-control" type="text" value="${c.tags}" name="tags">
                                             <p class="help-block">${error_tag}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Category Description</label>
                                            <textarea class="form-control" name="description" rows="7">${c.description}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Parent Category</label>
                                            <select class="form-control" name="pid">
                                                <option value="${c.pid}" selected>${c.pid}</option>
                                                <option value="0">Main</option>
                                                <c:forEach items="${categorylist}" var="cat">
                                                    <option value="${cat.id}"> ${cat.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                      
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                        </c:forEach>
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
