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
	<table>
	<c:forEach var="bookCopy" items="${bookCopies}">
	<tr>
		<td>${bookCopy.id}</td>
		<td>${bookCopy.condtion}</td>
		<td>${bookCopy.book.name}  ${bookCopy.book.isbn} 
		<td><a href="${bookCopy.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addCopy"> Add Book Copy</a>
</body>
</html>