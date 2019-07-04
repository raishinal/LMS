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
        <title>Edit item</title>
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
                                    <div class="contact-info-wrap-flex">
                                        
                                            <div class="con-info">
                                                <p><span><i class="icon-location-2"></i></span> <a href="<c:url value="/Retailer/Profile"/>">Your personal Detail</a></p>
                                            </div>
                                            <div class="con-info">
                                                <p><span><i class="icon-phone3"></i></span> <a href="<c:url value="/Retailer/ChangePassword"/>">Change Password</a></p>
                                            </div>
                                            <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/Retailer/Items/Add"/>">Add Items</a></p>
                                            </div>

                                            <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/Retailer/Items/Show"/>">My Items</a></p>
                                            </div>
                                     
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 animate-box">
                            <h2 class="contact-head">Edit your item</h2>
                             
                        	          <form role="form" action="<c:url value="/Retailer/Item/Update?${_csrf.parameterName}=${_csrf.token}"/>" method="post" enctype="multipart/form-data">
                                    
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <div class="form-group">
                                            <label>Item Id</label>
                                            <input class="form-control" type="number" value="${item.id}" name="id" readonly>
                                            <p class="help-block">${error_title}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Item Name</label>
                                            <input class="form-control" type="text" value="${item.name}" name="name">
                                            <p class="help-block">${error_title}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Stock</label>
                                            <input class="form-control" type="number" value="${item.stock}" name="stock">
                                            <p class="help-block">${error_title}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Item Price</label>
                                            <input class="form-control" type="text" value="${item.price}" name="price">
                                            <p class="help-block">${error_tag}</p>
                                        </div>

                                        <div class="form-group">
                                            <label>Item Description</label>
                                            <textarea class="form-control"  name="description" rows="7">${item.description}</textarea>
                                        </div>
                                      


                                        <div class="form-group">
                                            <label>Category</label>
                                            <input class="form-control" type="number" value="${item.category}" name="category" readonly>

                                        </div>
                                        <div class="form-group">
                                            <label>Tags</label>
                                            <input class="form-control" type="text" value="${item.tags}" name="tags" readonly>

                                        </div>
                                        <div class="form-group">
                                            <label>Image</label>
                                            <input class="form-control" type="text" value="${item.imageName}" name="imagename" readonly>

                                        </div>
                                        <div class="form-group">
                                            <label>Item Image</label>
                                            <input type="file" name="image" placeholder="Select image file if u want to edit">
                                            <p class="help-block"></p>
                                        </div>
                                 
                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button type="reset" class="btn btn-default" >Reset Button</button>

                                </form>
                 

                        </div>
                    </div>
                </div>
            </div>

            <div id="map" class="colorlib-map"></div>

            <jsp:include page="footer.jsp"/>
        </div>

    </body>
</html>
