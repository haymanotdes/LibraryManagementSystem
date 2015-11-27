<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style style="text/css">
  	.hoverTable{
		width:100%; 
		border-collapse:collapse; 
	}
	.hoverTable td{ 
		padding:7px; border:#4e95f4 1px solid;
	}
	/* Define the default color for all the table rows */
	.hoverTable tr{
		background: #8C6A3D;
	}
	/* Define the hover highlight color for the table row */
    .hoverTable tr:hover {
          background-color: white;
    }
</style>
<link rel="stylesheet" href="<spring:url value="/resources/css/menu.css" htmlEscape="true"/>" type="text/css"/>

<script type="text/javascript" src="<spring:url value="/resources/js/menu1.js" htmlEscape="true"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/menu2.js" htmlEscape="true"/>"></script>
<body>
<div style="background-image: url('<%=request.getContextPath()%>/resources/images/bookLibrary2.jpg');">
<br>
<br>
<br>
<h1 style="color: white;">Library Management System</h1>
<br>
<br>
</div>
<div id="sse3">
  <div id="sses3">
    <ul>
     <li><a href="<spring:url value="/book/search" htmlEscape="true"/>">Configuration</a></li>
      <li><a href="<spring:url value="/book/addBook" htmlEscape="true"/>">Add Book</a></li>
     <li><a href="<spring:url value="/book/booklist" htmlEscape="true"/>">List Book</a></li>
      <li><a href="<spring:url value="/bookcopy/addCopy" htmlEscape="true"/>">Add Copy</a></li>
      <li><a href="<spring:url value="/author/addAuthor" htmlEscape="true"/>">Add Author</a></li>
      <li><a href="<spring:url value="/author/authorlist" htmlEscape="true"/>">List Author</a></li>
       <li><a href="<spring:url value="/publisher/addPublisher" htmlEscape="true"/>">Add Publisher</a></li>
      <li><a href="<spring:url value="/publisher/publisherlist" htmlEscape="true"/>">List Publisher</a></li>
       <li><a href="<spring:url value="/category/addCategory" htmlEscape="true"/>">Add Category</a></li>
      <li><a href="<spring:url value="/category/categorylist" htmlEscape="true"/>">List Category</a></li>
    </ul>
  </div>
</div>
<div id="sse2">
  <div id="sses2">
    <ul>
     <li><a href="<spring:url value="/book/search" htmlEscape="true"/>">Service & Administration</a></li>
      <li><a href="<spring:url value="/book/search" htmlEscape="true"/>">Search Books</a></li>
     <li><a href="<spring:url value="/borrowfine/list" htmlEscape="true"/>">List Fines</a></li>
      <li><a href="<spring:url value="/bookborrow/search" htmlEscape="true"/>">List Borrows</a></li>
      <li><a href="<spring:url value="/user/addUser" htmlEscape="true"/>">Add User</a></li>
      <li><a href="<spring:url value="/user/userlist" htmlEscape="true"/>">List Users</a></li>
       <li><a href="<spring:url value="/role/addRole" htmlEscape="true"/>">Add Role</a></li>
      <li><a href="<spring:url value="/role/rolelist" htmlEscape="true"/>">List Roles</a></li>
    </ul>
  </div>
</div>
<div>


<sec:authorize var="loggedIn" access="isAuthenticated()" />
<c:choose>
    <c:when test="${loggedIn}">
        <a href='<c:url value='/j_spring_security_logout'/>'>Logout</a>
    </c:when>
    <c:otherwise>
       <a href='<c:url value='/spring_security_login'/>'>Login</a> 
    </c:otherwise>
</c:choose>
</div>
</body>
</html>