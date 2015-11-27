<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit publisher</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="../publisher/${publishers.id}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${publishers.name}" /> </td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="phone" value="${publishers.phone}" /> </td>
		</tr>
		<tr>
			<td>Fax:</td>
			<td><input type="text" name="fax" value="${publishers.fax}" /> </td>
		</tr>
		<tr>
			<td>Url:</td>
			<td><input type="text" name="url" value="${publishers.url}" /> </td>
		</tr>
	</table>
	
	
	<input type="submit" value="update"/>
	</form>
	<form action="delete?publisherId=${publishers.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>