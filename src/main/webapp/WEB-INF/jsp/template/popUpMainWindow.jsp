<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="css/popUp.css" rel="stylesheet">


<c:if test="${deleteAccount == 1}">
	<c:remove var="deleteAccount" scope="session" />
	<div id="overlay">
		<div class="popup">
			<h2>
				<fmt:message key="message.delete" />
			</h2>

			<button class="close" title="Закрыть"
				onclick="document.getElementById('overlay').style.display='none';"></button>
		</div>
	</div>
</c:if>

<c:if test="${error == 1}">
	<c:remove var="error" scope="session" />
	<div id="overlay">
		<div class="popup">
			<h2>
				<fmt:message key="message.error" />
			</h2>

			<button class="close" title="Закрыть"
				onclick="document.getElementById('overlay').style.display='none';"></button>
		</div>
	</div>
</c:if>

<c:if test="${registerAccount == 1}">
	<c:remove var="registerAccount" scope="session" />
	<div id="overlay">
		<div class="popup">
			<h2>
				<fmt:message key="message.register" />
			</h2>

			<button class="close" title="Закрыть"
				onclick="document.getElementById('overlay').style.display='none';"></button>
		</div>
	</div>
</c:if>

<c:if test="${registerAccount == 0}">
	<c:remove var="registerAccount" scope="session" />
	<div id="overlay">
		<div class="popup">
			<h2>
				<fmt:message key="message.no.register" />
			</h2>

			<button class="close" title="Закрыть"
				onclick="document.getElementById('overlay').style.display='none';"></button>
		</div>
	</div>
</c:if>


<script type="text/javascript">
	var delay_popup = 1000;
	setTimeout("document.getElementById('overlay').style.display='block'",
			delay_popup);
</script>