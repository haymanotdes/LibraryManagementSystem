<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>
<br>

<h1>Borrow this Book Copy</h1>

 <form action="bookcopyborrow22" commandName="borrow"  method="get">
 <table>
		<tr>
			<td>Borrow Data:</td>
			<td><input type="date" name="takeDate"> </td>
		</tr>
		<tr>
			<td>Return Date:</td>
			<td><input type="date" name="returnDate"></td>
		</tr>
		<tr>
			<td>User:</td>
		<td>
			<select name="userid">
				<option value="">select user</option>
				<c:forEach var="user" items="${users}">
				  <option value="${user.id}">${user.firstName}</option>
				 </c:forEach>
				 
			</select>
		</td>
		</tr>
		<tr>
			<td><input name="bookcopyid" value="${bookcopyid}" type="hidden"/></td>
			<td><input type="submit"/></td>
		</tr>
			
		
	</table>
	</form>
 
</body>
</html>