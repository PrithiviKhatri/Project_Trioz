<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <li><a href="<spring:url value="/welcome"/>">Home</a></li>
<li><a href="<spring:url value="/course/add"/>">Add Course</a></li>
<li><a href="<spring:url value="/course"/>">Show Course</a></li>
<li><a href="<spring:url value="/enroll/enrollStudent"/>">Enroll Student</a></li>
<li><a href="<spring:url value="/displayListOfStudents"/>">Edit Student</a></li>
 --%>
<c:forEach items="${menuItems }" var="menuItem" >
	<li><a href="<spring:url value="${menuItem.value }"/>">${menuItem.key}</a></li>
</c:forEach>

