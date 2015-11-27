<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Borrow Fines</title>

</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>
<br>
<h3>Borrow Fines</h3>





<table class="hoverTable" cellpadding="0" cellspacing="0">
<tr>
   		<th>User </th>
   		<th>Effected Date</th>
    	<th>Take Date</th>
     	<th>Return Date</th>
 </tr>
<c:forEach var="fine" items="${fines}">
	<tr>
		<td>${fine.borrow.user.userName}</td>
		<td>${fine.effectedDate}</td>
		<td>${fine.borrow.takeDate}</td>
		<td>${fine.borrow.returnDate}</td>
	</tr>
</c:forEach>
</table>
 
</body>
</html>