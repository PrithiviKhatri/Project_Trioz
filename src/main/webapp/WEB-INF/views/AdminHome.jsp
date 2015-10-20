<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<spring:url value="/addUser" var="userUserUrl">
</spring:url>
<a href="${userUserUrl}">Add User</a>
<br />
<br>
<br>
<br>


<%-- <spring:url value="/updateProfessor" var="updateProfessorUrl" >
</spring:url>
<a href="${updateProfessorUrl}">Update Professor</a><br/>
 --%>
<spring:url value="/displayListOfProfessor" var="listOfProfessor">
</spring:url>
<a href="${listOfProfessor}">List All Professors</a>
<br />
<br>
<br>
<br>

<spring:url value="/course/add" var="addCourseUrl">
</spring:url>
<a href="${addCourseUrl}">Add Course</a>
<br />


</html>