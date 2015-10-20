<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
	<ol>
		<c:forEach items="${courselist }" var="course">
			<spring:url value="/course/area?courseId=${course.courseId }" var="url"></spring:url>
			<li><a href="${url }">${course.name}</a></li>
	</c:forEach>
	</ol>
	
</body>
</html>