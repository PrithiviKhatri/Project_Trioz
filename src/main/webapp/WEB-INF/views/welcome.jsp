<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
	Language: <a href="?language=en_US">English</a> | <a href="?language=np_NPL">Nepali</a>
	<h1><spring:message code="welcome.message" ></spring:message></h1>
</body>
</html>