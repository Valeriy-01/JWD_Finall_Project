<%@include file="./language.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900"
	rel="stylesheet">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<link rel="stylesheet" href="css/jquery.fancybox.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">

<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/aos.css">
<link href="css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet"
	type="text/css">

<link rel="stylesheet" href="css/style.css">



</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

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
						<a href="#" class="small mr-3"><span
							class="icon-question-circle-o mr-2"></span> <fmt:message
								key="header.question" /></a> <a href="#" class="small mr-3"><span
							class="icon-phone2 mr-2"></span> <fmt:message key="header.phone" /></a>
						<a href="#" class="small mr-3"><span
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
						<a href="index.jsp" class="d-block"> <img
							src="images/logo_bsuir.png" alt="Image" class="img-fluid">
						</a>
					</div>
					<div class="mr-auto">
						<nav class="site-navigation position-relative text-right"
							role="navigation">
							<ul
								class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
								<li class="active"><a href="index.jsp"
									class="nav-link text-left"><fmt:message key="header.home" /></a>
								</li>
								<li class="has-children"><a href="about.jsp"
									class="nav-link text-left"><fmt:message key="header.about" /></a>
									<ul class="dropdown">
										<li><a href="about.jsp"><fmt:message
													key="header.university" /></a></li>
									</ul></li>
								<li><a href="courses.jsp" class="nav-link text-left"><fmt:message
											key="header.faculty" /></a></li>
								<li><a href="contact.jsp" class="nav-link text-left"><fmt:message
											key="header.contact" /></a></li>
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


		<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
			style="background-image: url('images/bg_1.jpg')">
			<div class="container">
				<div class="row align-items-end justify-content-center text-center">
					<div class="col-lg-7">
						<h2 class="mb-0">
							<fmt:message key="header.personalAcc" />
						</h2>
					</div>
				</div>
			</div>
		</div>


		<div class="custom-breadcrumns border-bottom">
			<div class="container">
				<a href="index.jsp"><fmt:message key="header.home" /></a> <span
					class="mx-3 icon-keyboard_arrow_right"></span> <span
					class="current"><fmt:message key="header.personalAcc" /></span>
			</div>
		</div>

		<form class="login100-form validate-form"
			action="Controller?command=gotoeditpage" method="POST">
			<div class="site-section">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-sm-10">
							<div class="row">
								<div class="col-md-12 form-group">
									<label for="name"><b><fmt:message
												key="register.name" /></b></label> <input type="text" id="name"
										class="form-control form-control-sm"
										value="${sessionScope.name}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="surname"><b><fmt:message
												key="register.surname" /></b></label> <input type="text" id="surname"
										class="form-control form-control-sm"
										value="${sessionScope.surname}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="faculty"><b><fmt:message
												key="register.faculty" /></b></label> <input type="text" id="faculty"
										class="form-control form-control-sm"
										value="${sessionScope.faculty}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="maths"><b><fmt:message
												key="register.sub_1" /></b></label> <input type="text" id="maths"
										class="form-control form-control-sm"
										value="${sessionScope.maths}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="physics"><b><fmt:message
												key="register.sub_2" /></b></label> <input type="text" id="physics"
										class="form-control form-control-sm"
										value="${sessionScope.physics}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="russian"><b><fmt:message
												key="register.sub_3" /></b></label> <input type="text" id="russian"
										class="form-control form-control-sm"
										value="${sessionScope.russian}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="certificate"><b><fmt:message
												key="register.certif" /></b></label> <input type="text"
										id="certificate" class="form-control form-control-sm"
										value="${sessionScope.certificate}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="passport"><b><fmt:message
												key="register.passport" /></b></label> <input type="text" id="passport"
										name="passport" class="form-control form-control-sm"
										value="${sessionScope.passport}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="email"><b><fmt:message
												key="register.email" /></b></label> <input type="text" id="email"
										class="form-control form-control-sm"
										value="${sessionScope.email}" readonly>
								</div>
								<div class="col-md-12 form-group">
									<label for="password"><b><fmt:message
												key="register.password" /></b></label> <input type="text" id="password"
										class="form-control form-control-sm"
										value="${sessionScope.password}" readonly>
								</div>

								<button type="submit" name="passport"
									value="${sessionScope.passport}"
									class="btn btn-primary btn-lg px-4">
									<fmt:message key="personal.edit" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<form action="Controller?command=deleteaccount" method="POST">
		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<button type="submit" name="passport"
							value="${sessionScope.passport}"
							class="btn btn-primary btn-lg px-4" style="margin-left: 4%">
							<fmt:message key="personal.delete" />
						</button>
						<button type="submit" value="Result"
							class="btn btn-primary btn-lg px-4" formaction="index.jsp"
							style="float: right;">
							<fmt:message key="personal.result" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>



	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<p class="mb-4">
						<img src="images/logo_bsuir.png" alt="Image" class="img-fluid">
					</p>
				</div>
				<div class="col-lg-3">
					<h3 class="footer-heading">
						<span><fmt:message key="footer.university" /></span>
					</h3>
					<ul class="list-unstyled">
						<li><a href="news-single.jsp"><fmt:message
									key="footer.news" /></a></li>
					</ul>
				</div>
				<div class="col-lg-3">
					<h3 class="footer-heading">
						<span><fmt:message key="footer.subjects" /></span>
					</h3>
					<ul class="list-unstyled">
						<li><a href="course-single2.jsp"><fmt:message
									key="footer.science" /> &amp; <fmt:message
									key="footer.engineering" /></a></li>
						<li><a href="course-single6.jsp"><fmt:message
									key="footer.economics" /> &amp; <fmt:message
									key="footer.finance" /></a></li>
						<li><a href="course-single3.jsp"><fmt:message
									key="footer.science" /></a></li>
						<li><a href="course-single1.jsp"><fmt:message
									key="footer.contact" /></a></li>
					</ul>
				</div>
				<div class="col-lg-3">
					<h3 class="footer-heading">
						<span><fmt:message key="footer.center" /></span>
					</h3>
					<ul class="list-unstyled">
						<li><a href="contact.jsp"><fmt:message
									key="footer.center" /></a></li>
					</ul>
				</div>
			</div>

			<div class="row">
				<div class="containerLan">
					<%@include file="./languageSelect.jsp"%>
				</div>
				<div class="col-12">
					<div class="copyright">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							<fmt:message key="footer.copyright" />
							&copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							<fmt:message key="footer.rights" />
							</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>


	</div>
	<!-- .site-wrap -->


	<!-- loader -->
	<div id="loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#51be78" /></svg>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/jquery.countdown.min.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.fancybox.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.mb.YTPlayer.min.js"></script>




	<script src="js/main.js"></script>

</body>

</html>