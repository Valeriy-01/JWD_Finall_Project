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
	<%@include file="./template/popUpPersonWindow.jsp"%>
	<%@include file="./template/userCheck.jsp"%>
	<%@include file="./template/accountHeader.jsp"%>


	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">
						<fmt:message key="header.personalAcc" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="header.personalAcc" /></span>
		</div>
	</div>

	<div>
		<div class="container">
			<c:if test="${result == 1}">
				<h3>
					<span class="current"><fmt:message key="user.entered" /></span>
				</h3>
			</c:if>
			<c:if test="${result == 0}">
				<h3>
					<span class="current"><fmt:message key="user.not.entered" /></span>
				</h3>
			</c:if>
			<c:if test="${result == -1}">
				<h3>
					<span class="current"><fmt:message key="user.not.determined" /></span>
				</h3>
			</c:if>
		</div>

	</div>

	<form class="login100-form validate-form"
		action="Controller?command=gotoeditpage" method="POST">
		<div class="site-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-sm-10">
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="name"><b><fmt:message
											key="register.name" /></b></label> <input type="text" id="name"
									class="form-control form-control-sm" value="${user.name}"
									readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="surname"><b><fmt:message
											key="register.surname" /></b></label> <input type="text" id="surname"
									class="form-control form-control-sm" value="${user.surname}"
									readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="faculty"><b><fmt:message
											key="register.faculty" /></b></label> <input type="text" id="faculty"
									class="form-control form-control-sm"
									<c:if test="${user.facultyId == 1}">
	                                  value="<fmt:message key="home.networks" />"
                                    </c:if>
									<c:if test="${user.facultyId == 2}">
	                                  value="<fmt:message key="home.design" />"
                                    </c:if>
									<c:if test="${user.facultyId == 3}">
	                                  value="<fmt:message key="home.management" />"
                                    </c:if>
									<c:if test="${user.facultyId == 4}">
	                                  value="<fmt:message key="home.electronics" />"
                                    </c:if>
									<c:if test="${user.facultyId == 5}">
	                                  value="<fmt:message key="home.infocommunications" />"
                                    </c:if>
									<c:if test="${user.facultyId == 6}">
	                                  value="<fmt:message key="home.economics" />"
                                    </c:if>
									readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="first_subject"><b><fmt:message
											key="register.sub_1" /></b></label> <input type="text"
									id="firstSubjectResult" class="form-control form-control-sm"
									value="${user.state.firstSubjectResult}" readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="second_subject"><b><fmt:message
											key="register.sub_2" /></b></label> <input type="text"
									id="secondSubjectResult" class="form-control form-control-sm"
									value="${user.state.secondSubjectResult}" readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="language_result"><b><fmt:message
											key="register.sub_3" /></b></label> <input type="text"
									id="thirdSubjectResult" class="form-control form-control-sm"
									value="${user.state.thirdSubjectResult}" readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="certificate"><b><fmt:message
											key="register.certif" /></b></label> <input type="text"
									id="certificateResult" class="form-control form-control-sm"
									value="${user.state.certificateResult}" readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="passport"><b><fmt:message
											key="register.passport" /></b></label> <input type="text" id="passport"
									name="passport" class="form-control form-control-sm"
									value="${user.passport}" readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="email"><b><fmt:message
											key="register.email" /></b></label> <input type="text" id="email"
									class="form-control form-control-sm"
									value="${user.userAccess.email}" readonly>
							</div>
							<div class="col-md-12 form-group">
								<label for="password"><b><fmt:message
											key="register.password" /></b></label> <input type="text" id="password"
									class="form-control form-control-sm"
									value="${user.userAccess.password}" readonly>
							</div>

							<button type="submit" name="passport" value="${user.passport}"
								class="btn btn-primary btn-lg px-4">
								<fmt:message key="personal.edit" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>

	<div style="justify-content: center; display: flex">
		<form action="Controller?command=deleteaccount" method="POST"
			style="margin-right: 670px">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<button type="submit" name="passport" value="${user.passport}"
								class="btn btn-primary btn-lg px-4" style="margin-left: 120%">
								<fmt:message key="personal.delete" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<form action="Controller?command=checkadmissionresult" method="POST"
			style="margin-right: 270px">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<button type="submit" name="passport" value="${user.passport}"
								class="btn btn-primary btn-lg px-4" style="margin-left: 4%">
								<fmt:message key="personal.result" />
							</button>
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