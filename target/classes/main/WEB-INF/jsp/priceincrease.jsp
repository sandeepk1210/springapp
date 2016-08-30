<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>
		<fmt:message key="priceIncrease.heading" />
	</h1>

	<form:form method="post" modelAttribute="priceModify">
		<table width="95%" border="0" cellpadding="5" cellspacing="0"
			dir="ltr">
			<tbody>
				<tr>
					<td width="20%" align="right">Increase (%)</td>
					<td width="20%"><form:input path="percentage" maxlength="2"
							size="20" type="text" tabindex="1" onfocus="true" /></td>
					<td width="60%"><form:errors path="percentage"
							cssClass="error" /></td>
				</tr>
			</tbody>
		</table>
		<br>
		<div style="text-align: center">
			<input type="submit" value="Execute" />
		</div>
	</form:form>
	<a href="<c:url value="home" />">Home</a>
</body>
</html>




