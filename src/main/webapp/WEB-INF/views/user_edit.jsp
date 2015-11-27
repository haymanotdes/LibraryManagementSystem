<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit an author</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="../user/${users.id}" method="post">
	<table>
		<tr>
			<td>firstName:</td>
			<td><input type="text" name="firstName" value="${users.firstName}"/> </td>
		</tr>
		<tr>
			<td>lastName:</td>
			<td><input type="text" name="lastName" value="${users.lastName}" /> </td>
		</tr>
		<tr>
			<td>phoneNumber:</td>
			<td><input type="text" name="phoneNumber"  value="${users.phoneNumber}"/> </td>
		</tr>
		<tr>
			<td>emailAddress:</td>
			<td><input type="text" name="emailAddress" value="${users.emailAddress}" /> </td>
		</tr>
		<tr>
			<td>street:</td>
			<td><input type="text" name="street"  value="${users.address.street}"/> </td>
		</tr>
		<tr>
			<td>city:</td>
			<td><input type="text" name="city" value="${users.address.city}" /> </td>
		</tr><tr>
			<td>state:</td>
			<td><input type="text" name="state" value="${users.address.state}" /> </td>
		</tr>
		<tr>
			<td>zipCode:</td>
			<td><input type="text" name="zipCode" value="${users.address.zipCode}" /> </td>
		</tr>
		<tr>
			<td>country:</td>
			<td><input type="text" name="country" value="${users.address.country}"/> </td>
		</tr>
		
		<tr>
			<td>userName:</td>
			<td><input type="text" name="userName" value="${users.username}" /> </td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="password" name="password"  value="${users.password}"/> </td>
		</tr>
		
			<tr>
			<td>Authority:</td>
		<td>
		 <form:select items="${roles}" itemLabel="name" itemValue="name" path="users.authority"/>
		</td>
		</tr>
		
		<form:hidden path="users.enabled" value="TRUE"  />
		
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?userId=${users.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>