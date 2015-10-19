<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section class="container">
		<spring:url value="/course/add" var="save"></spring:url>
		<form:form modelAttribute="newCourse" action="${save}" class="form-horizontal" method="POST">
			<fieldset>
				<legend>Add new course</legend>
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code="addCourse.form.name.label"/></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description"><spring:message code="addCourse.form.description.label"/></label>
					<div class="col-lg-10">
						<form:input id="description" path="description" type="text"/>
						<form:errors path="description" cssClass="text-danger"/>
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