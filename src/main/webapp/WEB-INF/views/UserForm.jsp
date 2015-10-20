<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Admin</title>
</head>
<body>
	<section class="container">
		<form action="saveUser" class="form-horizontal" method="POST">
			<fieldset>
				<legend>Add new User</legend>



				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First
						Name</label>
					<div class="col-lg-10">
						<input id="firstName" name="firstName" type="text"
							class="input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last
						Name</label>
					<div class="col-lg-10">
						<input id="lastName" name="lastName" type="text"
							class="input-large" />
					</div>
				</div>




				<div class="form-group">
					<label class="control-label col-lg-2" for="userName">User
						Name</label>
					<div class="col-lg-10">
						<div class="input-prepend">
							<input id="username" name="userName" type="text"
								class="input-large" />
						</div>
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<div class="input-prepend">
							<input id="password" name="password" class="input-large" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="Role">Role</label>
					<div class="col-lg-10">
						<div class="input-prepend">
							<!-- <input type="checkbox" name="roles" /> ROLE_STUDENT <br>
							<input type="checkbox" name="role_professor" /> ROLE_PROFESSOR
 -->
							<input type="radio" name="role" value="ROLE_STUDENT">ROLE_STUDENT<br>
							<input type="radio" name="role" value="ROLE_PROFESSOR">ROLE_PROFESSOR

						</div>
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="AddUser" />
					</div>
				</div>

			</fieldset>
		</form>
	</section>
</body>
</html>
