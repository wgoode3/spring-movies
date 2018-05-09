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
	
	<h1>Movies</h1>
	
	<fieldset>
		<legend>Add a movie</legend>
		<form:form method="POST" action="/movies" modelAttribute="movie">
		    <form:label path="title">Title
		    <form:errors path="title"/>
		    <form:input path="title"/></form:label>
		    
		    <form:label path="year">Year
		    <form:errors path="year"/>     
		    <form:input type="number" path="year"/></form:label>
		    
		    <input type="submit" value="Submit"/>
		</form:form>
	</fieldset>
	
	<fieldset>
		<legend>All Movies</legend>
		<c:forEach items="${movies}" var="movie">
			<p>${movie.title} (${movie.year})</p>
		</c:forEach>
	</fieldset>

</body>
</html>