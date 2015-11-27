<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add an author</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="addAuthor" commandName="author"  method="post">
	<table>
		<tr>
			<td>FirstName:</td>
			<td><input type="text" name="fname" /> </td>
		</tr>
		<tr>
			<td>LastName:</td>
			<td><input type="text" name="Ilname" /> </td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" /> </td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="phone" /> </td>
		</tr>
	</table>
	<input type="submit"/>
	
	</form>
</body>
</html>