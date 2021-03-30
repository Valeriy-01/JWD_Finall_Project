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
						<fmt:message key="home.designDescription" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
    <div class="container">
      <a href="Controller?command=gotomainpage"><fmt:message key="header.home"/></a>
      <span class="mx-3 icon-keyboard_arrow_right"></span>
      <a href="Controller?command=gotofacultypage"><fmt:message key="header.faculty"/></a>
      <span class="mx-3 icon-keyboard_arrow_right"></span>
      <span class="current"><fmt:message key="home.design"/></span>
    </div>
  </div>

	<div class="site-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mb-4">
					<p>
						<img src="images/course_2.jpg" alt="Image" class="img-fluid">
					</p>
				</div>
				<div class="col-lg-5 ml-auto align-self-center">
					<h2 class="section-title-underline mb-5">
						<span><fmt:message key="courseSingle.details" /></span>
					</h2>
					<p>
						<fmt:message key="courseSingle_2.technologies" />
					</p>
					<p>
						<fmt:message key="courseSingle_2.successfully" />
					</p>

					<p>
						<a href="#" class="btn btn-primary rounded-0 btn-lg px-5"><fmt:message
								key="courseSingle.enroll" /></a>
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