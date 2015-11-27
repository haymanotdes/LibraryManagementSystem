<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Category_list</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<br><br>
<h1>Category</h1>
	<table class="hoverTable">
	<c:forEach var="category" items="${categories}">
	<tr>
		<td>${category.name}</td>		
		<td><a href="${category.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addCategory"> Add a category</a>
</body>
</html>