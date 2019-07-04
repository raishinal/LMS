<%-- 
    Document   : addcategory
    Created on : Jun 27, 2019, 4:00:09 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Category</title>
         <jsp:include page="static.jsp"/>
    </head>
    <body>
         <jsp:include page="header.jsp"/>
         <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Category/Add</li>
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
					<div class="panel-heading">Add Category</div>
					<div class="panel-body">
						<div class="col-md-6">
							 <form role="form" action="<c:url value="/Admin/Category/Add"/>" method="post">
                                        
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        
                                           
                                        <div class="form-group">
                                            <label>Parent Category</label>
                                            <select class="form-control" name="pid">
                                                <option value="0" selected>Main</option>
                                                <c:forEach items="${categorylist}" var="cat">
                                                    <option value="${cat.id}"> ${cat.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Category Title</label>
                                            <input class="form-control" type="text" placeholder="Category title here.." name="title">
                                             <p class="help-block">${error_title}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Category Tag</label>
                                            <input class="form-control" type="text" placeholder="Category tag here.." name="tags">
                                             <p class="help-block">${error_tag}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Category Description</label>
                                            <textarea class="form-control" name="description" rows="7"></textarea>
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
