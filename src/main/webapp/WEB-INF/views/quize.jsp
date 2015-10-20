<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			<h3>Quize Detail</h3>
					<h4>Description:${newQuiz.description}</h4>
					<ol>
						<c:forEach items="${newQuiz.question}" var="question">
							<li>${question }</li>
						</c:forEach>
					</ol>
	 <a href="<spring:url value="/welcome" />" class="btn btn-default">
							<span class="glyphicon-hand-left glyphicon"></span> back
						</a>
	
					</p>

			</div>
		</div>
	</section>
</body>
</html>