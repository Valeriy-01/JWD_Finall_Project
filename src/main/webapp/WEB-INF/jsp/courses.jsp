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
						<fmt:message key="header.faculty" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="header.faculty" /></span>
		</div>
	</div>

	<div class="site-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="course-1-item">
						<figure class="thumnail">
							<a href="Controller?command=gotofksispage"><img
								src="images/course_1.jpg" alt="Image" class="img-fluid"></a>
							<div class="category">
								<h3>
									<fmt:message key="home.networks" />
								</h3>
							</div>
						</figure>
						<div class="course-1-content pb-4">
							<h2>
								<fmt:message key="home.networksDescription" />
							</h2>
							<div class="rating text-center mb-3">
								<span class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span>
							</div>
							<p>
								<a href="Controller?command=gotofksispage"
									class="btn btn-primary rounded-0 px-4"><fmt:message
										key="home.transition" /></a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="course-1-item">
						<figure class="thumnail">
							<a href="Controller?command=gotofkppage"><img
								src="images/course_2.jpg" alt="Image" class="img-fluid"></a>

							<div class="category">
								<h3>
									<fmt:message key="home.design" />
								</h3>
							</div>
						</figure>
						<div class="course-1-content pb-4">
							<h2>
								<fmt:message key="home.designDescription" />
							</h2>
							<div class="rating text-center mb-3">
								<span class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span>
							</div>

							<p>

								<a href="Controller?command=gotofkppage"
									class="btn btn-primary rounded-0 px-4"><fmt:message
										key="home.transition" /></a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="course-1-item">
						<figure class="thumnail">
							<a href="Controller?command=gotofitupage"><img
								src="images/course_3.jpg" alt="Image" class="img-fluid"></a>

							<div class="category">
								<h3>
									<fmt:message key="home.management" />
								</h3>
							</div>
						</figure>
						<div class="course-1-content pb-4">
							<h2>
								<fmt:message key="home.managementDescription" />
							</h2>
							<div class="rating text-center mb-3">
								<span class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span>
							</div>

							<p>
								<a href="Controller?command=gotofitupage"
									class="btn btn-primary rounded-0 px-4"><fmt:message
										key="home.transition" /></a>
							</p>
						</div>
					</div>
				</div>


				<div class="col-lg-4 col-md-6 mb-4">
					<div class="course-1-item">
						<figure class="thumnail">
							<a href="Controller?command=gotofrpage"><img
								src="images/course_4.jpg" alt="Image" class="img-fluid"></a>

							<div class="category">
								<h3>
									<fmt:message key="home.electronics" />
								</h3>
							</div>
						</figure>
						<div class="course-1-content pb-4">
							<h2>
								<fmt:message key="home.electronicsDescription" />
							</h2>
							<div class="rating text-center mb-3">
								<span class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span>
							</div>

							<p>
								<a href="Controller?command=gotofrpage"
									class="btn btn-primary rounded-0 px-4"><fmt:message
										key="home.transition" /></a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="course-1-item">
						<figure class="thumnail">
							<a href="Controller?command=gotoinfopage"><img
								src="images/course_5.jpg" alt="Image" class="img-fluid"></a>

							<div class="category">
								<h3>
									<fmt:message key="home.infocommunications" />
								</h3>
							</div>
						</figure>
						<div class="course-1-content pb-4">
							<h2>
								<fmt:message key="home.infocommunicationsDescription" />
							</h2>
							<div class="rating text-center mb-3">
								<span class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span>
							</div>

							<p>
								<a href="Controller?command=gotoinfopage"
									class="btn btn-primary rounded-0 px-4"><fmt:message
										key="home.transition" /></a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 mb-4">
					<div class="course-1-item">
						<figure class="thumnail">
							<a href="Controller?command=gotoefpage"><img
								src="images/course_6.jpg" alt="Image" class="img-fluid"></a>

							<div class="category">
								<h3>
									<fmt:message key="home.economics" />
								</h3>
							</div>
						</figure>
						<div class="course-1-content pb-4">
							<h2>
								<fmt:message key="home.economicsDescription" />
							</h2>
							<div class="rating text-center mb-3">
								<span class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span> <span
									class="icon-star2 text-warning"></span>
							</div>

							<p>
								<a href="Controller?command=gotoefpage"
									class="btn btn-primary rounded-0 px-4"><fmt:message
										key="home.transition" /></a>
							</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%@include file="./template/philosophy.jsp"%>
	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>

</body>

</html>