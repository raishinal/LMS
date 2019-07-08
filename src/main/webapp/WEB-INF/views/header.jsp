<%-- 
    Document   : header
    Created on : Jun 27, 2019, 4:00:53 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <body>
        <nav class="colorlib-nav" role="navigation">
            <div class="top-menu">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2 text-center">
                            <div id="colorlib-logo"><a href="<c:url value="/Index"/>">LMS</a></div>
                        </div>
                        <div class="col-md-1 text-center">
                            <div>     
                                <form method="GET" action="<c:url value="/Search"/>">
                                    <input type="text"  name="key" placeholder="Search Items">
                                </form>
                            </div>
                        </div>
                        <div class="col-md-9 text-right menu-1">
                            <ul>
                                <li class="active"><a href="<c:url value="/Index"/>">Home</a></li>
                                <li class="has-dropdown">
                                    <a href="<c:url value="/Category/Show"/>">Category</a>
                                    <ul class="dropdown">

                                        <c:forEach items="${sublist}" var="sub">
                                            <li><a href="<c:url value="/Category/Item/Show/${sub.id}"/>">${sub.title}</a>
                                            </c:forEach>
                                    </ul>

                                </li>
                                <li><a href="<c:url value="/About"/>">About</a></li>
                                <li><a href="<c:url value="/Contact"/>">Contact</a></li>
                                    <c:if test="${status==0}">
                                    <li class="btn-cta"><a href="<c:url value="/Register"/>">Sign Up</a></li>
                                    <li class="btn-cta"><a href="<c:url value="/Login"/>">Login</a></li>

                                </c:if>
                                    
                                <c:if test="${status==1}">

                                    <li>Welcome ${username}</li>
                                        <c:if test="${user_type==1}">
                                        <li class="btn-cta"><a href="<c:url value="/User/Profile"/>">Profile</a></li>
                                        </c:if>
                                        <c:if test="${user_type==2}">
                                        <li class="btn-cta"><a href="<c:url value="/Retailer/Profile"/>">Profile</a></li>
                                        </c:if>
                                        <c:if test="${user_type==3}">
                                        <li class="btn-cta"><a href="<c:url value="/Admin/Home"/>">DashBoard</a></li>
                                        </c:if>
                                        
                                        <li class="btn-cta"><a href="<c:url value="/Logout"/>">Logout</a></li>


                                </c:if>



                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>
