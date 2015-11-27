<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit a bookCopy</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<form action="../bookcopy/${bookCopy.id}" method="post">
	<table>
		<tr>
			<td>Book:</td>
			<td><input type="text" name="id" value="${bookCopy.id}" /> </td>
		</tr>
		<tr>
			<td>Condtion:</td>
			<td><select name="condtion" >
					
					<option value="EXCELENT" <c:if test="${bookCopy.condtion} == 'EXCELENT'}">selected="selected"</c:if>>EXCELENT</option>
					<option value="GOOD" <c:if test="${bookCopy.condtion} == 'GOOD'}">selected="selected"</c:if>>GOOD</option>
					<option value="VERY_GOOD" <c:if test="${bookCopy.condtion} == 'VERY_GOOD'}">selected="selected"</c:if>>VERY_GOOD</option>
					
					<option value="GOOD" <c:if test="${bookCopy.condtion} == 'GOOD'}">selected="selected"</c:if>>GOOD</option>
					
					<option value="BAD" <c:if test="${bookCopy.condtion} == 'BAD'}">selected="selected"</c:if>>BAD</option>
													
					
			</select>
			 </td>
		</tr>
		<tr>
			<td>condtion:</td>
			<td><input type="text" name="numOfBooks" value="${bookCopy.condtion}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?bookCopyId=${bookCopy.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>