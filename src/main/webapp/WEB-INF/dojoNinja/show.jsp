<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jeff's new JSP File</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css" />
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1><c:out value="${ dojo.name }"/> Location Ninjas</h1>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="ninja" items="${ ninjas }">
		<tr>
			<td><c:out value="${ ninja.firstName }"/></td>
			<td><c:out value="${ ninja.lastName }"/></td>
			<td><c:out value="${ ninja.age }"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>