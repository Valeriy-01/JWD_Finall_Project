<%@include file="./template/library.jsp"%>
<%@include file="./template/language.jsp"%>
<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>
<body>
	<%@include file="./template/header.jsp"%>

	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end">
				<div class="col-lg-7">
					<h2 class="mb-0">
						<fmt:message key="header.about" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="#"><fmt:message key="header.home" /></a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current"><fmt:message
					key="header.about" /></span>
		</div>
	</div>

	<div class="container pt-5 mb-5">
		<div class="row">
			<div class="col-lg-4">
				<h2 class="section-title-underline">
					<span><fmt:message key="about.history" /></span>
				</h2>
			</div>
			<div class="col-lg-4">
				<p>
					<fmt:message key="about.historyUniversity" />
				</p>
			</div>
			<div class="col-lg-4">
				<p>
					<fmt:message key="about.historyBuilding" />
				</p>
			</div>
		</div>
	</div>

	<div class="site-section">
		<div class="container">
			<div class="row mb-5">
				<div class="col-lg-6 mb-lg-0 mb-4">
					<img src="images/course_1.jpg" alt="Image" class="img-fluid">
				</div>
				<div class="col-lg-5 ml-auto align-self-center">
					<h2 class="section-title-underline mb-5">
						<span><fmt:message key="home.networks" /></span>
					</h2>
					<p>
						<fmt:message key="about.historyBuilding" />
					</p>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6 order-1 order-lg-2 mb-4 mb-lg-0">
					<img src="images/course_3.jpg" alt="Image" class="img-fluid">
				</div>
				<div class="col-lg-5 mr-auto align-self-center order-2 order-lg-1">
					<h2 class="section-title-underline mb-5">
						<span><fmt:message key="home.management" /></span>
					</h2>
					<p>
						<fmt:message key="about.managementFaculty" />
					</p>
				</div>
			</div>
		</div>
	</div>
	<%@include file="./template/philosophy.jsp"%>
	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>

</body>

</html>