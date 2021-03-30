<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form method="post">
	<button class="but" type="submit" name="locale" value="ru">
		<fmt:message key="footer.ru" />
	</button>
	<button type="submit" name="locale" value="en">
		<fmt:message key="footer.en" />
	</button>
</form>