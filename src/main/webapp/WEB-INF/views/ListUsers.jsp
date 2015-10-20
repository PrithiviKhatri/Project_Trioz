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


		<table>
			<tr>

				<th>Name</th>
				<th>Phone</th>
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
					<%-- <td><c:forEach items="${user.roles}" var="Role">
							<h1>${Role.role}</h1>
						</c:forEach></td> --%>
					<td>${user.role}</td>
					<td><spring:url value="/deleteUser/{userId}" var="Delete">
							<spring:param name="userId" value="${user.userId}" />
						</spring:url> <a href="${Delete}">DeleteUser</a><br /></td>



				</tr>
				<br>
			</c:forEach>



		</table>




	</div>
</body>
</html>