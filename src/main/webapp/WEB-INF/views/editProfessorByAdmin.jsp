<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section class="container">
		<spring:url value="/professor/editProfessorByAdmin" var="edit"></spring:url>
		<form:form modelAttribute="editProfessor" action="${edit}"
			class="form-horizontal" method="POST">
			<form:hidden path="userId" />


			<fieldset>
				<legend></legend>
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName">FirstName</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" />
						<form:errors path="firstName" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description">UserName</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description">UserName</label>
					<div class="col-lg-10">
						<b>Choose the courses:</b>
						<%-- 						<form:checkboxes path="professor.courses" items="${courses}" />
 --%>
						<table>
							<c:forEach items="${courses}" var="course" varStatus="status">
								<tr>
									<td><form:checkbox path="professor.courses"
											value="${course.courseId}" /></td>

									<td><c:out value="${course.name}" /></td>
								</tr>
							</c:forEach>
						</table>
						<form:errors path="professor.courses" cssClass="text-danger" />

					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Update Professor" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>