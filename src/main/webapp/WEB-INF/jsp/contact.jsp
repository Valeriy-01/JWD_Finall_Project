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
						<fmt:message key="header.contact" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="header.contact" /></span>
		</div>
	</div>



	<div class="container pt-5 mb-5">
		<div class="row">
			<div class="col-lg-4">
				<h2 class="section-title-underline">
					<span><fmt:message key="contact.title" /></span>
				</h2>
			</div>
			<div class="col-lg-4">
				<p>
					<fmt:message key="contact.info" />
				</p>
			</div>
			<div class="col-lg-4">
				<p>
					<fmt:message key="contact.description.first" />
				</p>
				<p>
					<fmt:message key="contact.description.second" />
				</p>
			</div>
			<p class="mb-5">
					<img src="images/committee.jpg" width="110%" alt="Committee timetable" class="img-fluid">
				</p>
		</div>
	</div>



	<%@include file="./template/philosophy.jsp"%>
	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>

</body>

</html>