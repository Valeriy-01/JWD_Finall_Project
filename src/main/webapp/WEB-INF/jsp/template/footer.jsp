<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="page" uri="/WEB-INF/tld/taglib.tld"%>

<div class="footer">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<p class="mb-4">
					<img src="images/logo_bsuir.png" alt="Image" class="img-fluid">
				</p>
			</div>
			<div class="col-lg-3">
				<h3 class="footer-heading">
					<span><fmt:message key="footer.university" /></span>
				</h3>
				<ul class="list-unstyled">
					<li><a href="Controller?command=gotonewspage"><fmt:message
								key="footer.news" /></a></li>
				</ul>
			</div>
			<div class="col-lg-3">
				<h3 class="footer-heading">
					<span><fmt:message key="footer.subjects" /></span>
				</h3>
				<ul class="list-unstyled">
					<li><a href="Controller?command=gotofkppage"><fmt:message
								key="footer.science" /> &amp; <fmt:message
								key="footer.engineering" /></a></li>
					<li><a href="Controller?command=gotoefpage"><fmt:message
								key="footer.economics" /> &amp; <fmt:message
								key="footer.finance" /></a></li>
					<li><a href="Controller?command=gotofksispage"><fmt:message
								key="footer.science" /></a></li>
					<li><a href="Controller?command=gotofitupage"><fmt:message
								key="footer.business" /></a></li>
				</ul>
			</div>
			<div class="col-lg-3">
				<h3 class="footer-heading">
					<span><fmt:message key="footer.center" /></span>
				</h3>
				<ul class="list-unstyled">
					<li><a href="Controller?command=gotocontactpage"><fmt:message
								key="footer.center" /></a></li>
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="containerLan">
				<%@include file="./languageSelect.jsp"%>
			</div>
			<div class="col-12">
				<div class="copyright">
					<page:copyright  owner="Waleriy Goreglyad" year="2021"/>
				</div>
			</div>
		</div>
	</div>
</div>