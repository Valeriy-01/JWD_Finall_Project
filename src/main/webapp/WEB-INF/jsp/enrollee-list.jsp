<%@include file="./template/language.jsp"%>
<%@include file="./template/library.jsp"%>
<!DOCTYPE html>

<head>
<title><fmt:message key="header.title" /></title>
<%@include file="./template/link.jsp"%>
</head>

<body>
	<%@include file="./template/adminCheck.jsp"%>
	<%@include file="./template/accountHeader.jsp"%>


	<div class="site-section ftco-subscribe-1 site-blocks-cover pb-4"
		style="background-image: url('images/bg_1.jpg')">
		<div class="container">
			<div class="row align-items-end justify-content-center text-center">
				<div class="col-lg-7">
					<h2 class="mb-0">
						<fmt:message key="list.title" />
					</h2>
				</div>
			</div>
		</div>
	</div>


	<div class="custom-breadcrumns border-bottom">
		<div class="container">
			<a href="Controller?command=gotomainpage"><fmt:message
					key="header.home" /></a> <span class="mx-3 icon-keyboard_arrow_right"></span>
			<span class="current"><fmt:message key="list.title" /></span>
		</div>
	</div>

	<table class="table table-striped table-bordered table-hover"
		style="margin: 2% 6% 2% 2%">
		<thead>
			<tr>
				<th style="min-width: 5px"><fmt:message key="user.id" /></th>
				<th style="min-width: 65px"><fmt:message key="user.faculty" /></th>
				<th style="min-width: 15px"><fmt:message key="user.surname" /></th>
				<th style="min-width: 15px"><fmt:message key="user.name" /></th>
				<th style="min-width: 30px"><fmt:message key="user.total" /></th>
				<th style="min-width: 20px"><fmt:message key="user.email" /></th>
				<th style="min-width: 50px"><fmt:message key="user.passport" /></th>
				<th style="min-width: 40px"><fmt:message key="user.operations" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${sessionScope.users}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.facultyId}" /></td>
					<td><c:out value="${user.surname}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.state.totalScope}" /></td>
					<td><c:out value="${user.userAccess.email}" /></td>
					<td><c:out value="${user.passport}" /></td>
					<td style="max-width: 260px; margin-right: 20px">
						<form action="Controller?command=gotoedituserfromadmin"
							method="POST">
							<button type="submit" name="passport" value="${user.passport}"
								class="btn btn-warning col-lg-11">
								<span style="margin-right: 5px"
									class="glyphicon glyphicon-pencil"><fmt:message
										key="user.edit" /></span>
							</button>
						</form>
						<form action="Controller?command=deleteaccountfromadmin"
							method="POST">
							<button type="submit" name="passport" value="${user.passport}"
								class="btn btn-info col-lg-11 col-lg-offset-1">
								<span style="margin-right: 5px"
									class="glyphicon glyphicon-align-justify"><fmt:message
										key="user.delete" /></span>
							</button>
						</form>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="Controller?command=createlistofenrolled" method="POST">
		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<button type="submit" class="btn btn-primary btn-lg px-4">
							<fmt:message key="list.form" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>


	<%@include file="./template/footer.jsp"%>
	<%@include file="./template/loader.jsp"%>

</body>

</html>