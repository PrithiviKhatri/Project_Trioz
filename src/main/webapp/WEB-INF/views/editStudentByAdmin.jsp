<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
</head>
<body>
	<section class="container">
		<spring:url value="/student/editStudentByAdmin" var="edit"></spring:url>
		<form:form modelAttribute="editStudent" action="${edit}"
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
					<label class="control-label col-lg-2 col-lg-2" for="lastName">LastName</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="userName">UserName</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="student.level">Level</label>
					<div class="col-lg-10">

						<form:input id="student.level" path="student.level" type="text" />
						<form:errors path="student.level" cssClass="text-danger" />

					</div>
				</div>


			<%-- 	<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="student.joinedDate">Joined Date</label>
					<div class="col-lg-10">
						<form:input id="student.joinedDate" path="student.joinedDate" type="text" />
						<form:errors path="student.joinedDate" cssClass="text-danger" />

					</div>
				</div> --%>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Update Student" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>