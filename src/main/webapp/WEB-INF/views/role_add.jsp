<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Role</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="addRole" commandName="role"  method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" /> </td>
		</tr>
	</table>
	<input type="submit"/>
	
	</form>
</body>
</html>