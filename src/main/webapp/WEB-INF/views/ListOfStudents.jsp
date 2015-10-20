<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE HTML>
<html>
<head>
<title>Professors</title>

</head>
<body>
	<div id="global">
		<h2>List of Students</h2>


		<table>
			<tr>

				<th>Name</th>
				<th>UserName</th>
				<th>UserID</th>
				<th>Level</th>
			</tr>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.firstName}${user.lastName}</td>
					<td>${user.userName}</td>
					<td>${user.userId}</td>
					<td>${course.student.courses}</td>
					<td><spring:url value="/editStudentByAdmin/{userId}"
							var="edit">
							<spring:param name="userId" value="${user.userId}" />
						</spring:url> <a href="${edit}">EditStudent</a><br /></td>



				</tr>
				<br>
			</c:forEach>



		</table>




	</div>
</body>
</html>