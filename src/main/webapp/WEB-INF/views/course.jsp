<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
					<h3>${course.name}</h3>
					<p>${course.courseId}</p>
					<p>${course.description}</p>
					<spring:url value="/assignment/add" var="addAssignment"></spring:url>
					<h1><a href="${addAssignment }">Add Assignments</a></h1>
					
					<p>
	 <a href="<spring:url value="/welcome" />" class="btn btn-default">
							<span class="glyphicon-hand-left glyphicon"></span> back
						</a>
	
					</p>

			</div>
		</div>
	</section>
</body>
</html>