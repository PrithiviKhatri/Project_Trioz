<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<spring:url value="/user/addUser" var="userUserUrl">
</spring:url>
<a href="${userUserUrl}">Add User</a>
<p><b>You can add user and assign Role like <i>PROFESSOR , ADMIN</i> to him.</b></p><br />

<br />
<br>



<%-- <spring:url value="/updateProfessor" var="updateProfessorUrl" >
</spring:url>
<a href="${updateProfessorUrl}">Update Professor</a><br/>
 --%>
<spring:url value="/professor/displayListOfProfessor" var="listOfProfessor">
</spring:url>
<a href="${listOfProfessor}">List All Professors</a>
<p><b>displays list of professor .And also give link to each professor to edit information about him</b></p><br />

<br />
<br>


<spring:url value="/student/displayListOfStudent" var="listOfStudents">
</spring:url>
<a href="${listOfStudents}">List All Students</a>
<p><b>displays list of students .And also give link to each student to edit information about him</b></p><br />
<br>
<br>
<br>

<spring:url value="/course/add" var="addCourseUrl">
</spring:url>
<a href="${addCourseUrl}">Add Course</a>
<p><b>you can add courses</b></p><br />
<br />
<br>


<spring:url value="/course" var="ListAllCourses">
</spring:url>
<a href="${ListAllCourses}">Available Courses</a>
<p><b>displays list of courses and also give link to edit information about each course</b></p><br />

<br />
<br />



</html>