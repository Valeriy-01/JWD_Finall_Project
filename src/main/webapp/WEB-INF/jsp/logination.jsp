<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./template/language.jsp"%>
<%@include file="./template/library.jsp"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>

<body>
	<%@include file="./template/header.jsp"%>


	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">
						<fmt:message key="header.login" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="header.login" /></span>
		</div>
	</div>

	<div class="site-section">
		<div class="container">


			<form class="login100-form validate-form"
				action="Controller?command=logination" method="POST">
				<div class="site-section">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-md-5">
								<div class="row">

									<div class="col-md-12 form-group">
										<label for="email"><b><fmt:message
													key="login.email" /></b></label> <input type="text" id="email"
											name="email" class="form-control form-control-lg" required
											pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
											title="<fmt:message
											key="validator.email" />">
									</div>
									<div class="col-md-12 form-group">
										<label for="password"><b><fmt:message
													key="login.password" /></b></label> <input type="text" id="password"
											name="password" class="form-control form-control-lg" required
											pattern="^.{8,}$"
											title="<fmt:message
											key="validator.password" />">
									</div>

								</div>
								<div class="row">
									<div class="col-12">
										<button type="submit" value="Login"
											class="btn btn-primary btn-lg px-5">
											<fmt:message key="header.login" />
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>
</body>

</html>