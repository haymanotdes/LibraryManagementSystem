<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit an author</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="../author/${authors.id}" method="post">
	<table>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="fname" value="${authors.fname}" /> </td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lname" value="${authors.lname}" /> </td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" value="${authors.email}" /> </td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="phone" value="${authors.phone}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	
	<form action="delete?authorId=${authors.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>