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
        <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,700,900" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/animate.css"/>">
	<!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/icomoon.css"/>">
	<!-- Bootstrap  -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/bootstrap.css"/>">

	<!-- Magnific Popup -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/magnific-popup.css"/>">

	<!-- Flexslider  -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/flexslider.css"/>">

	<!-- Owl Carousel -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/owl.theme.default.min.css"/>">
	
	<!-- Flaticons  -->
        <link rel="stylesheet" href="<c:url value="/resources/front/fonts/flaticon/font/flaticon.css"/>">

	<!-- Theme style  -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/style.css"/>">

	<!-- Modernizr JS -->
        <script src="<c:url value="/resources/front/js/modernizr-2.6.2.min.js"/>"></script>
	
        <title>Single Item Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
          <script type="text/javascript">
              
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
                        </div>
                        <div class="col-md-4 animate-box">
                            <div class="work-desc">
                                <h1>${item.name}</h1>
                                <h2>Price: Rs.${item.price}</h2>
                                <h2>In Stock: ${item.stock}</h2>
                                <p>${item.description}</p>
                                <p>

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
                                
                                <form>
                                
                                <input type="text" name="name" id="name"/>
                                <button type="button" id="likes" onclick="like();"></button>
                                </form>
                                <p id="result">result</p>
                            </div>
                        </div>

                    </div>

                </div>


                <jsp:include page="footer.jsp"/>
            </div>
            
          
<!-- jQuery Easing -->
        <script src="<c:url value="/resources/front/js/jquery.easing.1.3.js"/>"></script>
	<!-- Bootstrap -->
        <script src="<c:url value="/resources/front/js/bootstrap.min.js"/>"></script>
	<!-- Waypoints -->
        <script src="<c:url value="/resources/front/js/jquery.waypoints.min.js"/>"></script>
	<!-- Stellar Parallax -->
        <script src="<c:url value="/resources/front/js/jquery.stellar.min.js"/>"></script>
	<!-- Flexslider -->
        <script src="<c:url value="/resources/front/js/jquery.flexslider-min.js"/>"></script>
	<!-- Owl carousel -->
        <script src="<c:url value="/resources/front/js/owl.carousel.min.js"/>"></script>
	<!-- Magnific Popup -->
        <script src="<c:url value="/resources/front/js/jquery.magnific-popup.min.js"/>"></script>
        <script src="<c:url value="/resources/front/js/magnific-popup-options.js"/>"></script>
	<!-- Counters -->
        <script src="<c:url value="/resources/front/js/jquery.countTo.js"/>"></script>
	<!-- Main -->
        <script src="<c:url value="/resources/front/js/main.js"/>"></script>
    </body>
</html>
