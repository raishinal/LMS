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
        <title>Edit password Page</title>
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
                                     <jsp:include page="sidebar.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 animate-box">
                            <h2 class="contact-head">See and edit your profile</h2>
                            <c:if test="${user_type==1}">
                                <form role="form" action="<c:url value="/User/UpdatePassword?${_csrf.parameterName}=${_csrf.token}"/>"
                                      method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label>Previous Password</label>
                                        <input type="password" class="form-control" name="ppassword" placeholder="Enter previous Password">
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


                                    <div class="form-group">
                                        <input type="submit" value="Save" class="btn btn-primary">
                                    </div>
                                </form>		
                            </c:if>
                            <c:if test="${user_type==2}">
                                <form role="form" action="<c:url value="/Retailer/UpdatePassword?${_csrf.parameterName}=${_csrf.token}"/>"
                                      method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label>Previous Password</label>
                                        <input type="password" class="form-control" name="ppassword" placeholder="Enter previous Password">
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


                                    <div class="form-group">
                                        <input type="submit" value="Save" class="btn btn-primary">
                                    </div>
                                </form>		
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>

            <div id="map" class="colorlib-map"></div>

            <jsp:include page="footer.jsp"/>
        </div>

    </body>
</html>
