<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
	<div id="global">
		<h4>${Message}</h4>
		<p>
		<h5>Details:</h5>
		user Name: ${newUser.firstName} ${newUser.lastName}<br />

		<!-- Need to display list of courses -->
		
		<spring:url value="/displayListOfProfessor" var="listOfProfessor">
		</spring:url>
		<a href="${listOfProfessor}">Back</a>

	</div>
</body>
</html>