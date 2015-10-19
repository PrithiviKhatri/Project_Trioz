<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<section class="container"> <spring:url
		value="/enroll/enrollStudent" var="enrollStudent"></spring:url> 
		<form:form
		modelAttribute="newEnroll" action="${enrollStudent}"
		class="form-horizontal" method="POST">
		<fieldset>
			<legend>Enroll Student to Course</legend>
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="course"><spring:message
						code="enrollStudent.form.course.label" /></label>
				<div class="col-lg-10">
					<form:select id="courseList" path="courseId" items="${courses}"
						itemLabel="name" itemValue="courseId" />
						
						
					<form:errors path="courseId" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="student"><spring:message
						code="enrollStudent.form.student.label" /></label>
				<div class="col-lg-10">
				<form:select<%--  multiple="true" --%> path="students" items="${students}" itemLabel="studentId" itemValue="studentId" />
				
				
				<%-- <form:checkbox id="studentList" items="${students}" path="students" itemValue="studentId" itemLabel="level" value="studentId"/> --%>
					<%-- <form:select id="studentList" path="students" items="${students}"
						itemLabel="studentId" itemValue="studentId" /> --%>
					<form:errors path="students" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Enroll" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>