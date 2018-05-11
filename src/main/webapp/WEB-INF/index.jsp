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
			<p>Cast:</p>
			<ul>
			<c:forEach items="${movie.actresses}" var="actor">
				<li>${actor.name}</li>
			</c:forEach>
			</ul>
			<hr>
		</c:forEach>
	</fieldset>
	
	<fieldset>
		<legend>Add an Actor or Actress</legend>
		<form:form method="POST" action="/actors" modelAttribute="actress">
		    <form:label path="name">Name
		    <form:errors path="name"/>
		    <form:input path="name"/></form:label>
		    
		    <input type="submit" value="Submit"/>
		</form:form>
	</fieldset>
	
	<fieldset>
		<legend>All Actresses and Actors</legend>
		<c:forEach items="${actresses}" var="actor">
			<p><a href="/actor/${actor.id}">${actor.name}</a></p>
		</c:forEach>
	</fieldset>
	
	<fieldset>
		<legend>Add an Actor or Actress to a Movie</legend>
		<form action="/cast" method="post">
			<p>Actors and Actresses:
				<select name="actor_id">
					<c:forEach items="${actresses}" var="actor">
						<option value="${actor.id}">${actor.name}</option>
					</c:forEach>
				</select>
			</p>
			<p>Movies:
				<select name="movie_id">
					<c:forEach items="${movies}" var="movie">
						<option value="${movie.id}">${movie.title}</option>
					</c:forEach>
				</select>
			</p>
			<button type="submit">Submit</button>
		</form>
	</fieldset>

</body>
</html>