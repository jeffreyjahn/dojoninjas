<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jeff's new JSP File</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojo</form:label>
			<form:select path="dojo">
				<c:forEach var="d" items="${ dojos }">
					<form:option value="${ d.id }" label="${ d.name }"/>
				</c:forEach>
			</form:select>
			<form:errors path="dojo"/>
		</p>
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName"/>
			<form:errors path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">What Name:</form:label>
			<form:input path="lastName"/>
			<form:errors path="lastName"/>
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:input type="number" path="age" />
			<form:errors path="age"/>
		</p>
		<input type="submit" value="Create">
	</form:form>
	
</body>
</html>