<%-- 
    Document   : categories
    Created on : Jun 28, 2019, 8:22:06 AM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="static.jsp"/>
        <title>Categories</title>
        
    </head>
    <body>
       <div class="colorlib-loader"></div>
       <div id="page">
           <jsp:include page="header.jsp"/>
           <div class="container">
		<div class="row">
			<div class="col-xl-2 col-lg-3 col-md-4">
				<div class="sidebar-categories">
					<div class="head">Browse Categories</div>
					<ul class="main-categories">
                                            <c:forEach items="${categorylist}" var="cat">
						<li class="main-nav-list"><a data-toggle="collapse" href="#${cat.title}" aria-expanded="true" aria-controls="${cat.title}"><span
								 class="lnr lnr-arrow-right"></span>${cat.title}<span class="number">(53)</span></a>
							<ul class="" id="${cat.title}" data-toggle="collapse" aria-expanded="true" aria-controls="${cat.title}"> 
                                                            <!--class collapse if we don't want to expand our category-->
                                                            <c:forEach items="${sublist}" var="sub">
                                                             <c:if test="${cat.id==sub.pid}">
                                                            <li class="main-nav-list-child"><a href="<c:url value="/Category/Item/Show/${sub.id}"/>" onclick="location.replace('<c:url value="/Category/Item/Show/${sub.id}"/>')"> ${sub.title}<span class="number">(13)</span></a></li>
								</c:if>
                                                            </c:forEach>
							</ul>
						</li>
                                                </c:forEach>
                                              
					</ul>
				</div>
				<div class="sidebar-filter mt-50">
					<div class="top-filter-head">Item Filters</div>
					<div class="common-filter">
						<div class="head">Brands</div>
						<form action="#">
							<ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">Apple<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="asus" name="brand"><label for="asus">Asus<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="gionee" name="brand"><label for="gionee">Gionee<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="micromax" name="brand"><label for="micromax">Micromax<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="samsung" name="brand"><label for="samsung">Samsung<span>(19)</span></label></li>
							</ul>
						</form>
					</div>
					<div class="common-filter">
						<div class="head">Color</div>
						<form action="#">
							<ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="black" name="color"><label for="black">Black<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="balckleather" name="color"><label for="balckleather">Black
										Leather<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="blackred" name="color"><label for="blackred">Black
										with red<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="gold" name="color"><label for="gold">Gold<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="spacegrey" name="color"><label for="spacegrey">Spacegrey<span>(19)</span></label></li>
							</ul>
						</form>
					</div>
					
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting">
						<select>
							<option value="1">Default sorting</option>
							<option value="1">Default sorting</option>
							<option value="1">Default sorting</option>
						</select>
					</div>
					<div class="sorting mr-auto">
						<select>
							<option value="1">Show 12</option>
							<option value="1">Show 12</option>
							<option value="1">Show 12</option>
						</select>
					</div>
					<div class="pagination">
						<a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
						<a href="#" class="active">1</a>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
						<a href="#">6</a>
						<a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				
					<div class="row">
						<!-- single product -->
                                                <c:forEach items="${subitem}" var="item">
						<div class="col-lg-4 col-md-6">
							<div class="single-product">
                                                            <a href="<c:url value="/Item/${item.id}"/>">
								<img class="img-fluid" src="<c:url value="/resources/itemimage/${item.imageName}"/>" alt="item_image">
                                                                </a>
								<div class="product-details">
									<h6>${item.name}</h6>
									<div class="price">
										<h6>Rs. ${item.price}</h6>
										<!--<h6 class="l-through">$210.00</h6>-->
									</div>
									<div class="prd-bottom">

										<a href="" class="social-info">
											<span class="ti-bag"></span>
											<p class="hover-text">add to bag</p>
										</a>
										<a href="" class="social-info">
											<span class="lnr lnr-heart"></span>
											<p class="hover-text">Wishlist</p>
										</a>
										<a href="" class="social-info">
											<span class="lnr lnr-sync"></span>
											<p class="hover-text">compare</p>
										</a>
										<a href="" class="social-info">
											<span class="lnr lnr-move"></span>
											<p class="hover-text">view more</p>
										</a>
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
                                                </c:forEach>
						
					</div>
				
				
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting mr-auto">
						<select>
							<option value="1">Show 12</option>
							<option value="1">Show 12</option>
							<option value="1">Show 12</option>
						</select>
					</div>
					<div class="pagination">
						<a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
						<a href="#" class="active">1</a>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
						<a href="#">6</a>
						<a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
					</div>
				</div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>
           
            <jsp:include page="footer.jsp"/>
       </div>
    </body>
</html>
