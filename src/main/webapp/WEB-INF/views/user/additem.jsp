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
        <title>Add item</title>
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
                            <h2 class="contact-head">Add your item</h2>
                             
                        	  <form role="form" action="<c:url value="/Retailer/Item/Add?${_csrf.parameterName}=${_csrf.token}"/>" method="post" enctype="multipart/form-data">

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

                                    <button type="submit" class="btn btn-default">Submit</button>
                                    <button type="reset" class="btn btn-default">Reset </button>
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
