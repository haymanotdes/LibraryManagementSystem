<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<body>
<jsp:include page="menu.jsp"></jsp:include>
   <h1>Library Management System Book Add Form</h1>
	<form action="addBook" commandName="book" method="post">
	<table>
		<tr>
			<td>Title:</td>
			<td><input  Name="name" /> </td>
		<%-- 	<td><form:errors  path="name" element="div" /> --%>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input  Name="isbn" /> </td>
			<%-- <td><form:errors  path="isbn" element="div" /> --%>
		</tr>
		<tr>
			<td>Publisher:</td>
		<td>
		 <form:select items="${publisherlist}" itemLabel="name" itemValue="id" path="book.publisher.id"/>
		<%--  <td><form:errors  path="name" element="div" /> --%>
		</td>
		</tr>
		
		<tr>
			<td>Categories:</td>
		<td>
		 <form:select items="${categorylist}" itemLabel="name" itemValue="id" path="book.categoriesId" multiple="true"/>
		<%--  <td><form:errors  path="name" element="div" /> --%>
		</td>
		</tr>
		
		
		<tr>
			<td>Author:</td>
		<td>
		 <form:select items="${authorlist}" itemLabel="fname" itemValue="id" path="book.authoriesId" multiple="true"/>
		<%--  <td><form:errors  path="name" element="div" /> --%>
		</td>
		</tr>
		
		
	</table>
	<input type="submit"/>
	
	</form>
</body>
