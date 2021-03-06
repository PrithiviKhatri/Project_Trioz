<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE HTML>
<html>
<head>
<title>Users</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>
	<div id="global">
		<h2>List of Users</h2>


		<table border="1" style="width: 100%">
			<tr>

				<th>Name</th>
				<th>UserName</th>
				<th>UserID</th>
				<th>UserRole</th>
				<th>Delete User</th>
			</tr>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.firstName}${user.lastName}</td>
					<td>${user.userName}</td>
					<td>${user.userId}</td>
					<td>${user.role}</td>
					<td><spring:url value="/user/deleteUser/{userId}" var="Delete">
							<spring:param name="userId" value="${user.userId}" />
						</spring:url> <a href="${Delete}">DeleteUser</a></td>
				</tr>
			</c:forEach>



		</table>




	</div>
</body>
</html>