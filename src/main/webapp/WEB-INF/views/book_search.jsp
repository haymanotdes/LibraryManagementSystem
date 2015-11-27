<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>book search</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<br>
<br>

<h3>Book Search</h3>

<form action="<spring:url value="/book/search" htmlEscape="true"/>" method="post" style="width:100%">
<table style="width:100%">


<tr>
<td>
publisher
</td>
	<td>
		
		<select name="publisher" >
		<option value=""></option>
		<c:forEach var="publisher" items="${publishers}">
		  <option value="${publisher.id}">${publisher.name}</option>
		 </c:forEach>
		 
		</select>
		
	</td>
</tr>
<tr>
<td>
author
</td>
	<td>
		
		<select name="author">
		<option value=""></option>
		<c:forEach var="author" items="${authors}">
		  <option value="${author.id}">${author.fname}</option>
		 </c:forEach>
		 
		</select>
		
	</td>
</tr>
<tr>
<td>
book name
</td>
<td>
	<input type="text" name="name">
</td>
</tr>

<tr>
<td>
	<input type="submit" class="btn" value="search">
	
</td>
</tr>


</table>
</form>


<br>
<br>
<br>
<table class="hoverTable" align="left" cellpadding="2" cellspacing="3">
<tr>
<td>
Book
</td>
<td>
Action
</td>
<td>
Manage
</td>
</tr>

<c:forEach var="book" items="${books}">
<tr>
<td>
${book.name}
</td>
<td>
<a href="<%=request.getContextPath()%>/bookcopy/listavailable/${book.id}">borrow this book</a>

</td>
<td>
${book.id}
</td>
</tr>
 </c:forEach>
</table>


<style style="text/css">
  	.hoverTable{
		width:100%; 
		border-collapse:collapse; 
	}
	.hoverTable td{ 
		padding:7px; border:#4e95f4 1px solid;
	}
	/* Define the default color for all the table rows */
	.hoverTable tr{
		background: #8C6A3D;
	}
	/* Define the hover highlight color for the table row */
    .hoverTable tr:hover {
          background-color: white;
    }
</style>



</body>
</html>