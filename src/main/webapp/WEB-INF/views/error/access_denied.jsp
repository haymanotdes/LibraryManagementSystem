<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Access denied</h2>
	<c:if test="${not empty errCode}">
		<h1>${errCode} : Access denied</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>Access denied</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
	
</body>
</html>