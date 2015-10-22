<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE HTML>
<html>
<head>
<title>Students</title>

</head>
<body>
	<div id="global">
		<h2>List of Students</h2>


		<table border="1" style="width: 100%">
			<tr>

				<th>Name</th>
				<th>UserName</th>
				<th>UserID</th>
				<th>Level</th>
				<th>Action</th>
			</tr>

			<c:forEach var="userInfo" items="${users}">
				<tr>
					<td>${userInfo.firstName}${userInfo.lastName}</td>
					<td>${userInfo.userName}</td>
					<td>${userInfo.userId}</td>
					<td>${userInfo.student.level}</td>
					<td><spring:url value="/student/editStudentByAdmin/{userId}"
							var="edit">
							<spring:param name="userId" value="${userInfo.userId}" />
						</spring:url> <a href="${edit}">EditStudent</a><br /></td>



				</tr>
				<br>
			</c:forEach>



		</table>




	</div>
</body>
</html>