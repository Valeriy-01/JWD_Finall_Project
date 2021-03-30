<%@include file="./template/language.jsp"%>
<%@include file="./template/library.jsp"%>
<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>

<body>
	<%@include file="./template/header.jsp"%>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message key="header.home" /></a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current"><fmt:message
					key="header.news" /></span>
		</div>
	</div>

	<div class="site-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-9 mb-4">
					<p class="mb-5">
						<img src="images/8.jpg" alt="BSUIR" class="img-fluid">
					</p>
					<p>
						<fmt:message key="news.description_1" />
					</p>
					<p>
						<fmt:message key="news.description_2" />
					</p>
					<p>
						<fmt:message key="news.description_3" />
					</p>
					<p>
						<fmt:message key="news.description_4" />
					</p>
					<p>
						<fmt:message key="news.description_5" />
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