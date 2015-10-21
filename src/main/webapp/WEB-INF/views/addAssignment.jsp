<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section class="container">
		<spring:url value="/assignment/add" var="save"></spring:url>
		<form:form modelAttribute="newAssignment" action="${save}" class="form-horizontal" method="POST">
			<fieldset>
				<legend>Add new assignment</legend>
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="title"><spring:message code="addAssignment.form.title.label"/></label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text"/>
						<form:errors path="title" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description"><spring:message code="addAssignment.form.description.label"/></label>
					<div class="col-lg-10">
						<form:input id="description" path="description" type="text"/>
						<form:errors path="description" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="assignDate"><spring:message code="addAssignment.form.assignDate.label"/></label>
					<div class="col-lg-10">
						<form:input id="assignDate" path="assignDate" type="text"/>
						<form:errors path="assignDate" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="dueDate"><spring:message code="addAssignment.form.dueDate.label"/></label>
					<div class="col-lg-10">
						<form:input id="dueDate" path="dueDate" type="text"/>
						<form:errors path="dueDate" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>