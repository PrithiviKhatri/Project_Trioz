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
		Full Name: ${user.firstName} ${user.lastName}<br /><br> Courses Taught :
		<c:forEach var="course" items="${user.professor.courses}">
			<br>
			<br>${course.name} 
					</c:forEach>
		<spring:url value="/welcome" var="home">
		</spring:url>
		<form action="${home}" method="get">
			<input id="submit" type="submit" value="Home">
		</form>

	</div>
</body>
</html>