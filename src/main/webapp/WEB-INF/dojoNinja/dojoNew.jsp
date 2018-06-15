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
	<h1>New Dojo</h1>
	<form:form action="/dojos/new" method="post" modelAttribute="dojo">
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors path="name"/>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>