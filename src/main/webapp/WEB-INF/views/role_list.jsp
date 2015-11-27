<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Role_list</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<br><br>
<h1>Role</h1>
	<table class="hoverTable">
	<c:forEach var="role" items="${roles}">
	<tr>
		<td>${role.name}</td>	
		
		 <sec:authorize access="hasRole('ROLE_ADMIN')" >	
		<td><a href="${role.id}">edit</a></td>
		</sec:authorize>
	</tr>
	</c:forEach>
	</table>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')" >
	<a href="addRole"> Add role</a>
	</sec:authorize>
</body>
</html>