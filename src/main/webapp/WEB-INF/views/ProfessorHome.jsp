<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<h3>Welcome Professor ${user.firstName}</h3>
<table>
	<h5>Courses taught</h5>
	<tr>
		<c:forEach var="course" items="${user.professor.courses}">
			<spring:url value="/course/area?courseId=${course.courseId}"
				var="showcourse">
			</spring:url>
			<a href="${showcourse}">${course.name}</a>
			<br>
			<br>
		</c:forEach>
		<br>
		<br />

		<br>
		<br>

	</tr>
</table>
</html>