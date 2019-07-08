<%-- 
    Document   : sidebar
    Created on : Jul 4, 2019, 7:43:41 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  
    </head>
    <body>
         <div class="contact-info-wrap-flex">
                                        <c:if test="${user_type==1}">
                                            <div class="con-info">
                                                <p><span><i class="icon-location-2"></i></span> <a href="<c:url value="/User/Profile"/>">Your personal Detail</a></p>
                                            </div>
                                            <div class="con-info">
                                                <p><span><i class="icon-phone3"></i></span> <a href="<c:url value="/User/ChangePassword"/>">Change Password</a></p>
                                            </div>

                                            <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/User/Order/Show"/>">My orders</a></p>
                                            </div>
                                        </c:if>
                                        <c:if test="${user_type==2}">
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
                                             <div class="con-info">
                                                <p><span><i class="icon-paperplane"></i></span> <a href="<c:url value="/Retailer/Order/Show"/>">Orders</a></p>
                                            </div>
                                        </c:if>

                                    </div>
    </body>
</html>
