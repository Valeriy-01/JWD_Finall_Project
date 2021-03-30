<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${userSession == null}">
	<form id="foobar" method="POST"
		action="Controller?command=gotomainpage">
		<input type="submit">
	</form>
</c:if>

<script>
	setTimeout(function() {
		document.getElementById('foobar').submit();
	}, 0);
</script>

