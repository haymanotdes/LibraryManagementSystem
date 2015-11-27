<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<body>
<jsp:include page="menu.jsp"></jsp:include>
   <h1>Library Management System Book copy</h1>
	<form action="addCopy" commandName="bookCopy" method="Post">
	<table>	
		  <tr>
               <td>Book: </td>
                <td>
                
                <form:select items="${books}" itemLabel="name" itemValue="id" path="bookCopy.book.id"/>
                <%-- 	<select  name="bookidjsp">
                	
                	 <c:forEach var="book" items="${books}">
           			 	<option value="${book.id}" path="book">${book.name}</option>
          			</c:forEach>
          			</select> --%>
 						
                </td>
                 
		</tr> 
		<tr>
			<td>Condtion:</td>
			<td><select name="condtion">
					<option value="EXCELENT">EXCELENT</option>
					<option value="GOOD">GOOD</option>
					<option value="VERY_GOOD">VERY_GOOD</option>
					<option value="BAD">BAD</option>
													
			</select>
			 </td>
		</tr>
	</table>
	<input type="submit"/>
	
	</form>
</body>