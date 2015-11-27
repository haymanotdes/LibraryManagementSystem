<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<body>
<jsp:include page="menu.jsp"></jsp:include>
   <h1>Library Management System Book copy</h1>
	<form action="addBookCategory" commandName="bookCategory" method="Post">
	<table>	
		  <tr>
		  		<td>Book name: </td> <td>${book.name}</td>
               <td>Book category: </td>
                <td>
                
                
                <%-- <form:select items="${categories}" itemLabel="name" itemValue="id" path="" /> --%>
                <%-- 	<select  name="bookidjsp">
                	
                	 <c:forEach var="book" items="${books}">
           			 	<option value="${book.id}" path="book">${book.name}</option>
          			</c:forEach>
          			</select> --%>
 						
                </td>
                 
		</tr> 
	</table>
	<input type="submit"/>
	
	</form>
</body>