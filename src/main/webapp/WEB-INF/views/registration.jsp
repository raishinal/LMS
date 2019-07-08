<%-- 
    Document   : registration
    Created on : Jun 29, 2019, 10:17:09 AM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Registration Page</title>
    </head>
    <body>
        <div class="colorlib-loader"></div>

        <div id="page">
            <jsp:include page="header.jsp"/>
        </div>
           <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li class="active">Sign Up</li>
			</ol>
		</div><!--/.row-->

				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">User Registration</div>
					<div class="panel-body">
					   <div class="col-lg-9">
                                    <form role="form" action="<c:url value="/UserRegistration?${_csrf.parameterName}=${_csrf.token}"/>"
                                         method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input type="text" class="form-control" name="fname" placeholder="Enter first name">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input type="text" class="form-control" name="lname" placeholder="Enter last name">
                                            <p class="help-block"></p>
                                        </div>
                                      
                                        
                                        <div class="form-group">
                                            <label>E-mail</label>
                                            <input type="email" class="form-control" name="email" placeholder="Enter email">
                                            <p class="help-block"></p>
                                        </div>
         
                                        <div class="form-group">
                                            <label>Phone</label>
                                            <input type="text" class="form-control" name="phone" placeholder="Enter phone">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Date of Birth</label>
                                            <input type="date" class="form-control" name="dob" pattern="1999-01-01" title="dob" placeholder="Enter date of birth">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Country</label>
                                            <input type="text" class="form-control" name="country" placeholder="Enter country">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Interest</label>
                                            <input type="text" class="form-control" name="interest" placeholder="Enter your interest here..">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Address</label>
                                            <input type="text" class="form-control" name="address" placeholder="Enter your address here.">
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
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label>User Image</label>
                                            <input type="file" name="image" placeholder="Select image file">
                                            <p class="help-block"></p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Username</label>
                                            <input type="text" class="form-control" name="username" placeholder="Enter username">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input type="password" class="form-control" name="password" placeholder="Enter Password">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Confirm Password</label>
                                            <input type="password" class="form-control" name="cpassword" placeholder="Confirm Password">
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
    </body>
</html>
