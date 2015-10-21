<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h2>Assignment Added Successfully!!</h2>
					<h3>${assignment.title}</h3>
					<p>${assignment.description}</p>
					<p>
						<strong>Assign Date</strong> : ${assignment.assignDate}
					</p>
					<p>
						<strong>Due Date</strong> : ${assignment.dueDate}
					</p>
					<p>
	 <a href="<spring:url value="/assignment/add" />" class="btn btn-default">
							<span class="glyphicon-hand-left glyphicon"></span> back
						</a>
	
					</p>

			</div>
		</div>
	</section>
</body>
</html>