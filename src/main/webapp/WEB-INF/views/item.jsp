<%-- 
    Document   : item
    Created on : Jun 30, 2019, 1:48:13 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Single Item Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript">

            $(document).ready(function () {
                //        alert('jquery is ready')
                $("#id_get_time").click(function () {
                    //              alert('Button Clicked');
                    $.ajax({
                        url: 'get_time',
                        success: function (data) {
                            $("#id_time").html(data);
                        }
                    });
                });
            });
        </script>

    </head>
    <body>
        <div id="page">
            <jsp:include page="header.jsp"/>
            <div class="colorlib-intro">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center">
                            <div class="intro">
                                <h1>Item Detail</h1>
                                <p><span><a href="<c:url value="/Index"/>">Home</a></span> / <span>Work</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="colorlib-work">
                <div class="container">

                    <div class="row">
                        <div class="col-md-6 animate-box">
                            <div class="work-detail">
                                <img src="<c:url value="/resources/itemimage/${item.imageName}"/>" class="img-responsive" alt="html5 bootstrap template by colorlib.com">

                            </div>
                            <div class="row">
                                <c:if test="${likecheck !=0}">
                                    <form action="<c:url value="/User/Item/Like/${item.id}"/>" mehod="GET">
                                        <button id="like" class="fa fa-thumbs-up"/></button>                           
                                    </form>

                                </c:if>

                                <button id="id_get_time">Get Server Time</button>
                                <p id="id_time"></p>
                            </div>
                        </div>
                        <div class="col-md-4 animate-box">
                            <div class="work-desc">
                                <h1>${item.name}</h1>
                                <h2>Price: Rs.${item.price}</h2>
                                <h2>In Stock: ${item.stock}</h2>
                                <p>${item.description}</p>
                                <p>

                                    <c:if test="${user_type!=2 && user_type!=3}">
                                    <form action="<c:url value="/User/Order/${item.id}"/>" method="get">
                                        <div class="row form-group">
                                            <div class="col-md-12">
                                                <label>In Stock: ${item.stock}</label>
                                                <input type="number" id="email" name="no" class="form-control" value="1" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" value="Buy Now" class="btn btn-primary" onclick="return confirm('Are you sure?')">
                                        </div>
                                    </form>

                                </c:if>




                            </div>
                        </div>

                    </div>

                </div>


                <jsp:include page="footer.jsp"/>
            </div>



    </body>
</html>
