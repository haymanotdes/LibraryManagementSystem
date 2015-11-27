<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Resource not found</h2>
	<c:if test="${not empty errCode}">
		<h1>${errCode} : Resource not found</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>Resource not found</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
	
</body>
</html>