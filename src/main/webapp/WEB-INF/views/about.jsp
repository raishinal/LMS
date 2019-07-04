<%-- 
    Document   : about
    Created on : Jun 29, 2019, 12:07:58 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <jsp:include page="static.jsp"/>
        <title>About Page</title>
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
							<h1>About Us</h1>
							<p><span><a href="<c:url value="/Index"/>">Home</a></span> / <span>About</span></p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="colorlib-about">
			<div class="container">
				<div class="row row-pb-lg">
					<div class="col-md-6 animate-box">
						<div class="about-wrap">
							<h2>About Landing</h2>
							<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
							<p>The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way.</p>
						</div>
					</div>
					<div class="col-md-6 animate-box">
                                            <div class="video colorlib-video" style="background-image: url(<c:url value="/resources/front/images/img_bg_2.jpg"/>);">
							<a href="https://vimeo.com/channels/staffpicks/93951774" class="popup-vimeo"><i class="icon-play3"></i></a>
							<div class="overlay"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center colorlib-heading animate-box">
						<h2>Colleagues</h2>
						<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 text-center animate-box">
						<div class="staff-entry">
                                                    <a href="#" class="staff-img" style="background-image: url(<c:url value="/resources/front/images/person1.jpg"/>);"></a>
							<div class="desc">
								<h3>Emily Turner</h3>
								<span>Programmer</span>
								<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
								<p>
									<ul class="colorlib-social-icons">
										<li><a href="#"><i class="icon-twitter"></i></a></li>
										<li><a href="#"><i class="icon-facebook"></i></a></li>
										<li><a href="#"><i class="icon-linkedin"></i></a></li>
										<li><a href="#"><i class="icon-dribbble"></i></a></li>
									</ul>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 text-center animate-box">
						<div class="staff-entry">
                                                    <a href="#" class="staff-img" style="background-image: url(<c:url value="/resources/front/images/person2.jpg"/>);"></a>
							<div class="desc">
								<h3>Adam Morris</h3>
								<span>Graphic Designer</span>
								<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
								<p>
									<ul class="colorlib-social-icons">
										<li><a href="#"><i class="icon-twitter"></i></a></li>
										<li><a href="#"><i class="icon-facebook"></i></a></li>
										<li><a href="#"><i class="icon-linkedin"></i></a></li>
										<li><a href="#"><i class="icon-dribbble"></i></a></li>
									</ul>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 text-center animate-box">
						<div class="staff-entry">
                                                    <a href="#" class="staff-img" style="background-image: url(<c:url value="/resources/front/images/person3.jpg"/>);"></a>
							<div class="desc">
								<h3>Noah Nelson</h3>
								<span>Web Designer</span>
								<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
								<p>
									<ul class="colorlib-social-icons">
										<li><a href="#"><i class="icon-twitter"></i></a></li>
										<li><a href="#"><i class="icon-facebook"></i></a></li>
										<li><a href="#"><i class="icon-linkedin"></i></a></li>
										<li><a href="#"><i class="icon-dribbble"></i></a></li>
									</ul>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 text-center animate-box">
						<div class="staff-entry">
                                                    <a href="#" class="staff-img" style="background-image: url(<c:url value="/resources/front/images/person4.jpg"/>);"></a>
							<div class="desc">
								<h3>Dorothy Murphy</h3>
								<span>UI/UX Designer</span>
								<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
								<p>
									<ul class="colorlib-social-icons">
										<li><a href="#"><i class="icon-twitter"></i></a></li>
										<li><a href="#"><i class="icon-facebook"></i></a></li>
										<li><a href="#"><i class="icon-linkedin"></i></a></li>
										<li><a href="#"><i class="icon-dribbble"></i></a></li>
									</ul>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<jsp:include page="footer.jsp"/>
	</div>
    </body>
</html>
