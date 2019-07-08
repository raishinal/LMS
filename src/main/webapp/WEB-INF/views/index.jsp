<%-- 
    Document   : index
    Created on : Jun 27, 2019, 3:59:41 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
	
	<title>LMS Home</title>
              <jsp:include page="static.jsp"/>
   

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
							<h1>List Management System</h1>
							</div>
					</div>
				</div>
			</div>
		</div>
		<aside id="colorlib-hero">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="flexslider">
							<ul class="slides">
                                                            <li style="background-image: url(<c:url value="/resources/front/images/img_bg_1.jpg"/>);">
						   		<div class="overlay"></div>
						   	</li>
                                                        <li style="background-image: url(<c:url value="/resources/front/images/img_bg_2.jpg"/>);">
						   		<div class="overlay"></div>
						   	</li>
                                                        <li style="background-image: url(<c:url value="/resources/front/images/img_bg_3.jpg"/>);">
						   		<div class="overlay"></div>
						   	</li>
                                                        <li style="background-image: url(<c:url value="/resources/front/images/img_bg_4.jpg"/>);">
						   		<div class="overlay"></div>
						   	</li>	
						  	</ul>
					  	</div>
				  	</div>
			  	</div>
		  	</div>
		</aside>

	
		<div class="colorlib-blog">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center colorlib-heading animate-box">
						<h2>Latest Items</h2>
						<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name</p>
					</div>
				</div>
				<div class="row">
                                    <c:forEach items="${items}" var="item">
					<div class="col-md-4 animate-box">
						<article class="article-entry">
							<div class="admin">
								<p><span><i class="icon-user2"></i>${item.tags}</span> <span><a href="#"><i class="icon-bubble3"></i> ${item.stock}</a></span></p>
							</div>
							<div class="desc2">
								<h2><a href="<c:url value="/Item/${item.id}"/>">${item.name}</a></h2>
							</div>
							<a href="<c:url value="/Item/${item.id}"/>" class="blog-img" style="background-image: url(<c:url value="/resources/itemimage/${item.imageName}"/>);"></a>
							<div class="desc">
								<p>Price: Rs ${item.price}</p>
							</div>
						</article>
					</div>
                                    </c:forEach>
				</div>
			</div>
		</div>
		<div class="colorlib-blog">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center colorlib-heading animate-box">
						<h2>Popular Items</h2>
						<p>popular Items By likes</p>
					</div>
				</div>
				<div class="row">
                                    <c:forEach items="${popularitems}" var="item">
					<div class="col-md-4 animate-box">
						<article class="article-entry">
							<div class="admin">
								<p><span><i class="icon-user2"></i>${item.tags}</span> <span><a href="#"><i class="icon-bubble3"></i> ${item.stock}</a></span></p>
							</div>
							<div class="desc2">
								<h2><a href="<c:url value="/Item/${item.id}"/>">${item.name}</a></h2>
							</div>
							<a href="<c:url value="/Item/${item.id}"/>" class="blog-img" style="background-image: url(<c:url value="/resources/itemimage/${item.imageName}"/>);"></a>
							<div class="desc">
								<p>Price: Rs ${item.price}</p>
							</div>
						</article>
					</div>
                                    </c:forEach>
				</div>
			</div>
		</div>

                <jsp:include page="footer.jsp"/>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
	</div>
	
	

	</body>
</html>

