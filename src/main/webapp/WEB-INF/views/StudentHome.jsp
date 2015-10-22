<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<%-- <script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
 --%>
<h3>Welcome Professor ${user.firstName}</h3>
<br>
<br>
<%-- <form>
	<input type="button" value="Edit Your Profile"
		onclick="toggle_visibility('profileForm');">
</form> --%>
<br>
<br>
<h3>Courses taught</h3>
<table>
	<tr>
		<c:choose>
			<c:when test="${not empty {user.professor.courses}}">
				<c:forEach var="course" items="${user.professor.courses}">
					<spring:url value="/course/aea?courseId=${course.courseId}"
						var="showcourse">
					</spring:url>
					<a href="${showcourse}">${course.name}</a>
					<br>
					<br>
				</c:forEach>
			</c:when>


			<c:otherwise>
				<font color="red">Currently no courses not assigned to Professor</font> 
        <br>
				<br />
			</c:otherwise>
		</c:choose>

	</tr>
</table>


<%-- <div id="profileForm" style="display: none">
	<form:form modelAttribute="user" method="post">
		<table border="1">
			<tr>
				<form:input id="userId" path="" type="text" />
				<td>Academic Qualification</td>
				<td><form:input id="academicQualification"
						path="professor.academicQualification" type="text" /></td>
			</tr>
		
			<tr>
				<td>Experience</td>
				<td><form:textarea id="experience" path="professor.experience"
						type="text" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="Update Profile" onclick="sendProfessorDetails();"></td>
			</tr>
		</table>
	<h4 align="center"> <a href="#" onclick="toggle_visibility(\'profileForm\');"><b>EXIT</b> </a> </h4>
	</form:form>
	<!-- Success - or Validation errors -->
	<div id="errors" style="display: none"></div>
	<div id="success" style="display: none"></div>
</div> --%>
</html>