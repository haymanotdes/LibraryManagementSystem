<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add an author</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="addUser" commandName="user"  method="post">
	<table>
		<tr>
			<td>firstName:</td>
			<td><input type="text" name="firstName" /> </td>
		</tr>
		<tr>
			<td>lastName:</td>
			<td><input type="text" name="lastName" /> </td>
		</tr>
		<tr>
			<td>phoneNumber:</td>
			<td><input type="text" name="phoneNumber" /> </td>
		</tr>
		<tr>
			<td>emailAddress:</td>
			<td><input type="text" name="emailAddress" /> </td>
		</tr>
		<tr>
			<td>street:</td>
			<td><input type="text" name="street" /> </td>
		</tr>
		<tr>
			<td>city:</td>
			<td><input type="text" name="city" /> </td>
		</tr><tr>
			<td>state:</td>
			<td><input type="text" name="state" /> </td>
		</tr>
		<tr>
			<td>zipCode:</td>
			<td><input type="text" name="zipCode" /> </td>
		</tr>
		<tr>
			<td>country:</td>
			<td><input type="text" name="country" /> </td>
		</tr>
		
		<tr>
			<td>userName:</td>
			<td><input name="username" /> </td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="password" name="password" /> </td>
		</tr>
		<tr>
			<td>Authority:</td>
		<td>
		 <form:select items="${roles}" itemLabel="name" itemValue="name" path="user.authority"/>
		</td>
		</tr>
	
					
		<%-- <form:hidden  path="user.authority"  value="ROLE_USER" /> --%>
	
		<form:hidden path="user.enabled" value="TRUE"  />
		
	</table>
	<input type="submit"/>
	
	</form>
</body>
</html>