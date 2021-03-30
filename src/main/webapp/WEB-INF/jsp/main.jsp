<%@include file="./template/language.jsp"%>
<%@include file="./template/library.jsp"%>
<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>

<body>
    <%@include file="./template/popUpMainWindow.jsp"%>
	<%@include file="./template/header.jsp"%>


	<div class="hero-slide owl-carousel site-blocks-cover">
		<div class="intro-section"
			style="background-image: url('images/hero_1.jpg');">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-12 mx-auto text-center" data-aos="fade-up">
						<h1>
							<fmt:message key="home.nameOfUniversity" />
						</h1>
					</div>
				</div>
			</div>
		</div>

		<div class="intro-section"
			style="background-image: url('images/hero_2.jpg');">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-12 mx-auto text-center" data-aos="fade-up">
						<h1>
							<fmt:message key="home.photoDescription" />
						</h1>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="site-section">
		<div class="container">


			<div class="row mb-5 justify-content-center text-center">
				<div class="col-lg-6 mb-5">
					<h2 class="section-title-underline mb-3">
						<span><fmt:message key="home.popularFaculty" /></span>
					</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="owl-slide-3 owl-carousel">
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
	</div>




	<div class="section-bg style-1"
		style="background-image: url('images/about_1.jpg');">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h2 class="section-title-underline style-2">
						<span><fmt:message key="home.university" /></span>
					</h2>
				</div>
				<div class="col-lg-8">
					<p class="lead">
						<fmt:message key="home.universityDescription" />
					</p>
					<p>
						<fmt:message key="home.universityDescriptionC" />
					</p>
					<p>
						<a href="Controller?command=gotoaboutpage"><fmt:message
								key="home.read" /></a>
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