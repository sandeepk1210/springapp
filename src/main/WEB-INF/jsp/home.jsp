<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${now}" />
	</p>
	<h3>Products</h3>
	<c:forEach items="${products}" var="prod">
		<c:out value="${prod.description}" />
		<i>$<c:out value="${prod.price}" /></i>
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="priceincrease" />">Increase Price</a>
</body>
</html>