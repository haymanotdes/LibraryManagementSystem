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
<br>
<br>

<h1>Available Book copies currently in the Library</h1>

<br>
<br>
	<table class="hoverTable">
	<c:forEach var="bookCopy" items="${bookCopies}">
	<tr>
		<td>${bookCopy.id}</td>
		<td>${bookCopy.condtion}
		<td>
		<form action="<%=request.getContextPath()%>/bookcopyborrow" method="get">
		<input name="bookcopy" type="hidden" value="${bookCopy.id}"/>
			<input type="submit"/>
		</form>
		
		<%-- <a href="<%=request.getContextPath()%>/bookcopyborrow/${bookCopy.id}">Borrow</a></td> --%>
	</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>