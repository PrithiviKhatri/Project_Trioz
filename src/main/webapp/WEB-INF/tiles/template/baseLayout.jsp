<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">
	<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">
	<style type="text/css">@import url("<c:url value="/resource/css/style.css"/>");</style>
	<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
	<div class="container">
		<div class="header">
			<ul id="navigation">
				<tiles:insertAttribute name="navigation"></tiles:insertAttribute>
			</ul>
			<%-- <img alt="Logo" src="<c:url value="/resource/images/TriozLogo.png"/>"> --%>
						<div class="clear"></div>
			<i>${user.userName } is currently logged In!</i> <a href="#">logout</a>
			<h2>Online Education System</h2>
			Language: <a href="?language=en_US">English</a> | <a href="?language=np_NPL">Nepali</a>
		</div>
		<div class="row">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>