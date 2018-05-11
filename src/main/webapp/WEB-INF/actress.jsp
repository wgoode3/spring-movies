<!DOCTYPE html>
<html>
<head>
	<title>Movies</title>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>
	
	<fieldset>
		<legend>Edit ${actress.name}</legend>
		<form:form method="POST" action="/actor/${actress.id}/update" modelAttribute="actress" style="display:inline;">
		    <form:label path="name">Name
		    <form:errors path="name"/>
		    <form:input path="name"/></form:label>
		    
		    <input type="submit" value="Submit"/>
		</form:form>
		
		<a href="/"><button>Cancel</button></a>
		<form action="/actor/${actress.id}/delete/" method="post" style="display:inline;">
			<button type="submit">Delete</button>
		</form>
	</fieldset>

</body>
</html>