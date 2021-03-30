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
						<fmt:message key="header.register" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="header.register" /></span>
		</div>
	</div>

	<form class="login100-form validate-form"
		action="Controller?command=registration" method="POST">
		<div class="site-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-5">
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="name"><b><fmt:message
											key="register.name" /></b></label> <input type="text" id="name"
									name="name" class="form-control form-control-lg" required
									pattern="^([А-Я][а-я]{1,75}|[A-Z][a-z]{1,75})$"
									title="<fmt:message
											key="validator.name" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="surname"><b><fmt:message
											key="register.surname" /></b></label> <input type="text" id="surname"
									name="surname" class="form-control form-control-lg" required
									pattern="^([А-Я][а-я]{1,75}|[A-Z][a-z]{1,75})$"
									title="<fmt:message
											key="validator.surname" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="faculty"><b><fmt:message
											key="register.faculty" /></b></label> <select type="text" id="faculty"
									name="faculty" class="form-control form-control-lg" required>
									<option value="Факультет Компьютерных Систем И Сетей"><fmt:message
											key="home.networks" /></option>
									<option value="Факультет Компьютерного Проектирования"><fmt:message
											key="home.design" /></option>
									<option
										value="Факультет Информационных Технологий И Управления"><fmt:message
											key="home.management" /></option>
									<option value="Факультет Радиотехники И Электроники"><fmt:message
											key="home.electronics" /></option>
									<option value="Факультет Инфокоммуникаций"><fmt:message
											key="home.infocommunications" /></option>
									<option value="Инженерно-Экономический Факультет"><fmt:message
											key="home.economics" /></option>
								</select>
							</div>
							<div class="col-md-12 form-group">
								<label for="maths"><b><fmt:message
											key="register.sub_1" /></b></label> <input type="text" id="maths"
									name="sub_1" class="form-control form-control-lg" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="physics"><b><fmt:message
											key="register.sub_2" /></b></label> <input type="text" id="physics"
									name="sub_2" class="form-control form-control-lg" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="russian"><b><fmt:message
											key="register.sub_3" /></b></label> <input type="text" id="russian"
									name="sub_3" class="form-control form-control-lg" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="certificate"><b><fmt:message
											key="register.certif" /></b></label> <input type="text" id="certificate"
									name="certificate" class="form-control form-control-lg"
									required pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="passport"><b><fmt:message
											key="register.passport" /></b></label> <input type="text" id="passport"
									name="passport" class="form-control form-control-lg" required
									pattern="^[a-zA-Z0-9]+$"
									title="<fmt:message
											key="validator.passport" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="email"><b><fmt:message
											key="register.email" /></b></label> <input type="text" id="email"
									name="email" class="form-control form-control-lg" required
									pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
									title="<fmt:message
											key="validator.email" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="password"><b><fmt:message
											key="register.password" /></b></label> <input type="text" id="password"
									name="password" class="form-control form-control-lg" required
									pattern="^.{8,}$"
									title="<fmt:message
											key="validator.password" />">
							</div>

						</div>
						<div class="row">
							<div class="col-12">
								<button type="submit" value="Register"
									class="btn btn-primary btn-lg px-5">
									<fmt:message key="header.register" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>

	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>

</body>

</html>