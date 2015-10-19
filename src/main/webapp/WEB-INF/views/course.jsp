<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			<h3>Course Detail</h3>
					<h4>Name:${course.name}</h4>
					<p>Description:${course.description}</p>
					<p>Assignment Lists:</p>
					<table border="1" style="width:100%">
							<tr>
								<td>Title</td>
								<td>Description</td>
								<td>AssignDate</td>
								<td>DueDate</td>
								<td>Action</td>
							</tr>
						<c:forEach items="${course.assignments }" var="assignment">
							<tr>
								<td>${assignment.title}</td>
								<td>${assignment.description}</td>
								<td>${assignment.assignDate}</td>
								<td>${assignment.dueDate}</td>
								<spring:url value="/assignment/edit/${assignment.assignmentId }" var="edit"></spring:url>
								<spring:url value="/assignment/delete/${course.courseId }/${assignment.assignmentId }" var="delete"></spring:url>
								<td><a href="${edit }">Edit</a>|<a href="${delete }">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
					<spring:url value="/assignment/add" var="addAssignment"></spring:url>
					<br><a href="${addAssignment }">Add Assignments</a>
					
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