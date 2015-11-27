<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>book_list</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h1>Books currently in the Library</h1>
	<table class="hoverTable">
	<c:forEach var="book" items="${books}">
	<tr>
	<td>
		${book.name} 
		</td>
		<td>
		${book.isbn} 
		</td>
		<td>
		Book publisher name:</p>${book.publisher.name} 
	<%-- 	<p>Book category name:</p>${book.category.name} </br> --%>
		<%-- <c:forEach var="author" items="${book.author}">
		<tr>
			<td>${author.fname}</td>
		</tr>
		</c:forEach> --%>
		<td>
		<a href="${book.id}">edit
		</td>
	</tr> 
	</c:forEach>
	</table>
	
	<a href="addBook"> Add a Book</a>
</body>
</html>