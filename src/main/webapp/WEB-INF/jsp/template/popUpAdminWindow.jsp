<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="css/popUp.css" rel="stylesheet">


<c:if test="${createAdmissionResult == 1}">
	<c:remove var="createAdmissionResult" scope="session" />
	<div id="overlay">
		<div class="popup">
			<h2>
				<fmt:message key="message.create" />
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