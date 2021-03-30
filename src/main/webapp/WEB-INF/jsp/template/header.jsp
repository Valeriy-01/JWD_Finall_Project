<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="site-wrap">
	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>


	<div class="py-2 bg-light">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-9 d-none d-lg-block">
					<a href="<fmt:message key="admin.email" />" class="small mr-3"><span
						class="icon-question-circle-o mr-2"></span> <fmt:message
							key="header.question" /></a> <a
						href="<fmt:message key="admin.phone" />" class="small mr-3"><span
						class="icon-phone2 mr-2"></span> <fmt:message key="header.phone" /></a>
					<a href="<fmt:message key="admin.email"/>" class="small mr-3"><span
						class="icon-envelope-o mr-2"></span> <fmt:message
							key="header.email" /></a>
				</div>
				<div class="col-lg-3 text-right">
					<a href="Controller?command=gotologinpage" class="small mr-3"><span
						class="icon-unlock-alt"></span> <fmt:message key="header.login" /></a>
					<a href="Controller?command=gotoregisterpage"
						class="small btn btn-primary px-4 py-2 rounded-0"><span
						class="icon-users"></span> <fmt:message key="header.register" /></a>
				</div>
			</div>
		</div>
	</div>
	<header class="site-navbar py-4 js-sticky-header site-navbar-target"
		role="banner">

		<div class="container">
			<div class="d-flex align-items-center">
				<div class="site-logo">
					<a href="Controller?command=gotomainpage" class="d-block"> <img
						src="images/logo_bsuir.png" alt="Image" class="img-fluid">
					</a>
				</div>
				<div class="mr-auto">
					<nav class="site-navigation position-relative text-right"
						role="navigation">
						<ul
							class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
							<li class="active"><a href="Controller?command=gotomainpage"
								class="nav-link text-left"><fmt:message key="header.home" /></a>
							</li>
							<li class="has-children"><a
								href="Controller?command=gotoaboutpage"
								class="nav-link text-left"><fmt:message key="header.about" /></a>
								<ul class="dropdown">
									<li><a href="Controller?command=gotoaboutpage.jsp"><fmt:message
												key="header.university" /></a></li>
								</ul></li>
							<li><a href="Controller?command=gotofacultypage"
								class="nav-link text-left"><fmt:message key="header.faculty" /></a></li>
							<li><a href="Controller?command=gotocontactpage"
								class="nav-link text-left"><fmt:message key="header.contact" /></a></li>
						</ul>
						</ul>
					</nav>

				</div>
				<div class="ml-auto">
					<div class="social-wrap">
						<a href="#"><span class="icon-facebook"></span></a> <a href="#"><span
							class="icon-twitter"></span></a> <a href="#"
							class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
							class="icon-menu h3"></span></a>
					</div>
				</div>

			</div>
		</div>

	</header>