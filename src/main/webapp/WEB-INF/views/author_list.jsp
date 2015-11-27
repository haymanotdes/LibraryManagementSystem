<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>author_list</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h1>Authors</h1>
	<table class="hoverTable">
	<c:forEach var="author" items="${authors}">
	<tr>
		<td>Author first Name:</td>
		<td>${author.fname}</td> 
		<td>Author last Name:</td>
		<td>${author.lname}</td> 
		<td>Author email:</td>
		<td>${author.email}</td>
		<td>Author phone:</td>
		<td>${author.phone}</td>
		
		<td><a href="${author.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addAuthor"> Add an author</a>
</body>
</html>