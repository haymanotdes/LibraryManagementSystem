<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Book</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="../book/${books.id}" method="post">
	<table>
		<tr>
			<td>title:</td>
			<td><input type="text" name="name" value="${books.name}" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="isbn" value="${books.isbn}" /> </td>
	    </tr>
	    <tr>
			<td>Publisher:</td>
		<td>
		 <form:select items="${publisherlist}" itemLabel="name" itemValue="id" path="book.publisher.id"/>
		</td>
		</tr>
		
		<%-- <tr>
			<td>Categories:</td>
		<td>
		 <form:select items="${categorylist}" itemLabel="name" itemValue="id" path="book.category.id"/>
		</td>
		</tr> --%>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?bookId=${books.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>