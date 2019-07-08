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
        <title>Profile Page</title>
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
                                <form role="form" action="<c:url value="/User/UpdateUser?${_csrf.parameterName}=${_csrf.token}"/>"
                                      method="post" enctype="multipart/form-data">
                                    <div class="row form-group">
                                        <div class="col-md-6">
                                            <label>First Name</label>
                                            <input type="text" id="fname" name="fname" class="form-control" value="${userdetail.firstname}">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Last Name</label>
                                            <input type="text" id="lname" name="lname" class="form-control" value="${userdetail.lastname}">
                                        </div>
                                    </div>

                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>Email</label>
                                            <input type="text" id="email" name="email" class="form-control" value="${userdetail.email}">
                                        </div>
                                    </div>

                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>Phone</label>
                                            <input type="text" id="subject" name="phone" class="form-control" value="${userdetail.phone}">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>Date of Birth</label>
                                            <input type="date" class="form-control" name="dob" pattern="1999-01-01" title="dob" value="${userdetail.dob}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Country</label>
                                        <input type="text" class="form-control" name="country" value="${userdetail.country}">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Interest</label>
                                        <input type="text" class="form-control" name="interest" value="${userdetail.interest}">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" class="form-control" name="address" value="${userdetail.address}">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>User Name</label>
                                            <input type="text" id="subject" name="username" class="form-control" value="${userdetail.userName}">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-6">
                                            <label>Your Current Profile</label>
                                            <input type="text" id="fname" name="imagename" class="form-control" value="${userdetail.imageName}" >
                                            <img src="<c:url value="/resources/userimage/${userdetail.imageName}"/>"/>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Add New Image</label>
                                                <input type="file" name="image" placeholder="Select image file if u want to change">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <input type="submit" value="Save" class="btn btn-primary">
                                    </div>
                                </form>
                            </c:if>
                            <c:if test="${user_type==2}">
                                <form role="form" action="<c:url value="/Retailer/UpdateUser?${_csrf.parameterName}=${_csrf.token}"/>"
                                      method="post" enctype="multipart/form-data">
                                    <div class="row form-group">
                                        <div class="col-md-6">
                                            <label>First Name</label>
                                            <input type="text" id="fname" name="fname" class="form-control" value="${userdetail.firstname}">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Last Name</label>
                                            <input type="text" id="lname" name="lname" class="form-control" value="${userdetail.lastname}">
                                        </div>
                                    </div>

                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>Email</label>
                                            <input type="text" id="email" name="email" class="form-control" value="${userdetail.email}">
                                        </div>
                                    </div>

                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>Phone</label>
                                            <input type="text" id="subject" name="phone" class="form-control" value="${userdetail.phone}">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>Date of Birth</label>
                                            <input type="date" class="form-control" name="dob" pattern="1999-01-01" title="dob" value="${userdetail.dob}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Country</label>
                                        <input type="text" class="form-control" name="country" value="${userdetail.country}">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Interest</label>
                                        <input type="text" class="form-control" name="interest" value="${userdetail.interest}">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" class="form-control" name="address" value="${userdetail.address}">
                                        <p class="help-block"></p>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-12">
                                            <label>User Name</label>
                                            <input type="text" id="subject" name="username" class="form-control" value="${userdetail.userName}">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col-md-6">
                                            <label>Your Current Profile</label>
                                            <input type="text" id="fname" name="imagename" class="form-control" value="${userdetail.imageName}" >
                                            <img src="<c:url value="/resources/userimage/${userdetail.imageName}"/>"/>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Add New Image</label>
                                                <input type="file" name="image" placeholder="Select image file if u want to change">
                                            </div>
                                        </div>
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
