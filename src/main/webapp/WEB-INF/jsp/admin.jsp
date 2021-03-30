<%@include file="./template/library.jsp"%>
<%@include file="./template/language.jsp"%>

<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>

<body>
    <%@include file="./template/popUpAdminWindow.jsp"%>
	<%@include file="./template/adminCheck.jsp"%>
	<%@include file="./template/accountHeader.jsp"%>

	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">
						<fmt:message key="header.admin" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message key="header.home" /></a> <span
				class="mx-3 icon-keyboard_arrow_right"></span> <span class="current"><fmt:message
					key="header.admin" /></span>
		</div>
	</div>


	<div style="justify-content: center; display: flex">
		<form action="Controller?command=gotolistofapplicants" method="POST"
			style="margin-right: 50%">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary btn-lg px-4"
								style="margin-left: 3%">
								<fmt:message key="admin.enrollee" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<form action="Controller?command=createlistofenrolled" method="POST"
			style="margin-right: 35%">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary btn-lg px-4"
								style="margin-left: 7%">
								<fmt:message key="admin.credited" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>

	</div>

	<%@include file="./template/philosophy.jsp"%>
	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>

</body>

</html>