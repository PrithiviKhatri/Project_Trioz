<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Save User</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<h4>${Message}</h4>
		<p>
		<h5>Details:</h5>
		user Name: ${user.firstName} ${user.lastName}<br />

		<spring:url value="/" var="home">
		</spring:url>
		<form action="${home}" method="get">
			<input id="submit" type="submit" value="Home">
		</form>

	</div>
</body>
</html>