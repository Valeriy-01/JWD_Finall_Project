<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./template/language.jsp"%>
<%@include file="./template/library.jsp"%>
<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>

<body>
	<%@include file="./template/userCheck.jsp"%>
	<%@include file="./template/accountHeader.jsp"%>

	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">
						<fmt:message key="header.update" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="header.update" /></span>
		</div>
	</div>

	<form class="login100-form validate-form"
		action="Controller?command=editing" method="POST">
		<div class="site-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-5">
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="name"><b><fmt:message
											key="register.name" /></b></label> <input type="text" id="name"
									name="name" class="form-control form-control-lg"
									value="${user.name}" required
									pattern="^([А-ЯЁ][а-яё]{1,75}|[A-Z][a-z]{1,75})$"
									title="<fmt:message
											key="validator.name" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="surname"><b><fmt:message
											key="register.surname" /></b></label> <input type="text" id="surname"
									name="surname" class="form-control form-control-lg"
									value="${user.surname}" required
									pattern="^([А-ЯЁ][а-яё]{1,75}|[A-Z][a-z]{1,75})$"
									title="<fmt:message
											key="validator.surname" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="faculty"><b><fmt:message
											key="register.faculty" /></b></label> <select type="text"
									id="facultyTitle" name="facultyTitle"
									class="form-control form-control-lg" required>
									<option value="Факультет Компьютерных Систем И Сетей"
										<c:if test="${user.facultyId == 1}">
	                                  selected
                                    </c:if>><fmt:message
											key="home.networks" /></option>
									<option value="Факультет Компьютерного Проектирования"
										<c:if test="${user.facultyId == 2}">
	                                  selected
                                    </c:if>><fmt:message
											key="home.design" /></option>
									<option
										value="Факультет Информационных Технологий И Управления"
										<c:if test="${user.facultyId == 3}">
	                                  selected
                                    </c:if>><fmt:message
											key="home.management" /></option>
									<option value="Факультет Радиотехники И Электроники"
										<c:if test="${user.facultyId == 4}">
	                                  selected
                                    </c:if>><fmt:message
											key="home.electronics" /></option>
									<option value="Факультет Инфокоммуникаций"
										<c:if test="${user.facultyId == 5}">
	                                  selected
                                    </c:if>><fmt:message
											key="home.infocommunications" /></option>
									<option value="Инженерно-Экономический Факультет"
										<c:if test="${user.facultyId == 6}">
	                                  selected
                                    </c:if>><fmt:message
											key="home.economics" /></option>
								</select>
							</div>
							<div class="col-md-12 form-group">
								<label for="maths"><b><fmt:message
											key="register.sub_1" /></b></label> <input type="text"
									id="first_subject" name="firstSubjectResult"
									class="form-control form-control-lg"
									value="${user.state.firstSubjectResult}" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="physics"><b><fmt:message
											key="register.sub_2" /></b></label> <input type="text"
									id="second_subject" name="secondSubjectResult"
									class="form-control form-control-lg"
									value="${user.state.secondSubjectResult}" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="language_result"><b><fmt:message
											key="register.sub_3" /></b></label> <input type="text"
									id="thirdSubjectResult" name="thirdSubjectResult"
									class="form-control form-control-lg"
									value="${user.state.thirdSubjectResult}" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="certificate"><b><fmt:message
											key="register.certif" /></b></label> <input type="text"
									id="certificateResult" name="certificateResult"
									class="form-control form-control-lg"
									value="${user.state.certificateResult}" required
									pattern="^[0-9][0-9]?$|^100$"
									title="<fmt:message
											key="validator.score" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="passport"><b><fmt:message
											key="register.passport" /></b></label> <input type="text" id="passport"
									name="passport" class="form-control form-control-lg"
									value="${user.passport}" readonly
									title="<fmt:message
											key="validator.passport" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="email"><b><fmt:message
											key="register.email" /></b></label> <input type="text" id="email"
									name="email" class="form-control form-control-lg"
									value="${user.userAccess.email}" required
									pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
									title="<fmt:message
											key="validator.email" />">
							</div>
							<div class="col-md-12 form-group">
								<label for="password"><b><fmt:message
											key="register.password" /></b></label> <input type="text" id="password"
									name="password" class="form-control form-control-lg"
									value="${user.userAccess.password}" required pattern="^.{8,}$"
									title="<fmt:message
											key="validator.password" />">
							</div>

						</div>
						<div class="row">
							<div class="col-12">
								<button type="submit" name="passport" value="${user.passport}"
									class="btn btn-primary btn-lg px-5">
									<fmt:message key="header.update" />
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