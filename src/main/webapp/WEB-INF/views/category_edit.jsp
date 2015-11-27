<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit a category</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="../category/${categories.id}" method="post">
	<table>
		<tr>
			<td>Category Name:</td>
			<td><input type="text" name="name" value="${categories.name}" /> </td>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?categoryId=${categories.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>