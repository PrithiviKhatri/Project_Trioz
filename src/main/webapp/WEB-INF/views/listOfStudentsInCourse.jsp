<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students enrolled</title>
</head>
<body>

	<div id="global">
		<%-- 	<c:forEach var="test" items="${courseInfo.students}">
	HI
 ${test.level}
</c:forEach> --%>
		<h2>List of Students Enrolled in ${courseInfo.name}</h2>
		<table border="1" style="width: 100%">
			<tr>
				<th>Student ID</th>
				<th>Name</th>
				<th>Level</th>
				<th>JoinedDate</th>
			</tr>
			<c:forEach var="student" items="${courseInfo.students}">
				<tr>
					<td>${student.studentId}</td>
					<td>test</td>
					<td>${student.level}</td>
					<td>${student.joinedDate}</td>
				</tr>
				<br>
			</c:forEach>

		</table>



	</div>

</body>
</html>