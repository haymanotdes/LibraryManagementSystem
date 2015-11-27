<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Publisher_list</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>
<br>
<h1>Publisher</h1>
	<table class="hoverTable">
	<c:forEach var="publisher" items="${publishers}">
	<tr>
		<td>${publisher.name}</td>	
		<td>${publisher.phone}</td>
		<td>${publisher.fax}</td>
		<td>${publisher.url}</td>	
		<td><a href="${publisher.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addPublisher"> Add Publisher</a>
</body>
</html>