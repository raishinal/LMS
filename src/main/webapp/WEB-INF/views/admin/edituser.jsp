<%-- 
    Document   : register
    Created on : Jun 28, 2019, 7:44:13 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="static.jsp"/>
        <title>UserEdit page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/Index"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Sign Up</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">User</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Edit User</div>
                        <div class="panel-body">
                            <div class="col-lg-9">
                                <form role="form" action="<c:url value="/Admin/UpdateUser?${_csrf.parameterName}=${_csrf.token}"/>"
                                         method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>Id</label>
                                            <input type="number" class="form-control" name="id" value="${user.id}" readonly>
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input type="text" class="form-control" name="fname" value="${user.firstname}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input type="text" class="form-control" name="lname" value="${user.lastname}">
                                            <p class="help-block"></p>
                                        </div>
                                      
                                        
                                        <div class="form-group">
                                            <label>E-mail</label>
                                            <input type="email" class="form-control" name="email" value="${user.email}">
                                            <p class="help-block"></p>
                                        </div>
         
                                        <div class="form-group">
                                            <label>Phone</label>
                                            <input type="text" class="form-control" name="phone" value="${user.phone}">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Date of Birth</label>
                                            <input type="date" class="form-control" name="dob" pattern="1999-01-01" title="dob" value="${user.dob}">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Country</label>
                                            <input type="text" class="form-control" name="country" value="${user.country}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Interest</label>
                                            <input type="text" class="form-control" name="interest" value="${user.interest}">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control" name="address" value="${user.address}">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label>Image</label>
                                            <input class="form-control" type="text" value="${user.imageName}" name="imagename" readonly>

                                        </div>
                                        <div class="form-group">
                                            <label>User Image</label>
                                            <input type="file" name="image" placeholder="Select image file if u want to edit">
                                            <p class="help-block"></p>
                                        </div>
                                      
                                        <div class="form-group">
                                            <label>User Type</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="userType"  value="ROLE_USER" checked>User
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="userType"  value="ROLE_RETAILER" >Retailer
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="userType" value="ROLE_ADMIN">Admin
                                            </label>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Username</label>
                                            <input type="text" class="form-control" name="username" value="${user.userName}">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                       
                                    </form>
                                <a class="navbar-brand" href="<c:url value="/Index"/>">Cancel</a>
                            </div>		

                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

        </div><!--/.main-->
         <jsp:include page="js.jsp"/>
    </body>
</html>
