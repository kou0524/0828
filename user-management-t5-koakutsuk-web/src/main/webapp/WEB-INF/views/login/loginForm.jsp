<!DOCTYPE html>
<html>
<head>
<title>ログイン画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div id="wrapper">

		<c:if test="${param.containsKey('error')}">
			<t:messagesPanel messagesType="error"
				messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION" />
			<%-- (2) --%>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/login"
			method="post">
			<%-- (3) --%>
			<table>
				<tr>
					<td><label for="username">ユーザID</label></td>
					<td><label for="password">パスワード</label></td>

				</tr>
				<tr>
					<td><input type="text" id="j_username" name="username" value="0001"></td>
					<td><input type="password" id="j_password" name="password" value="demo"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input name="submit" type="submit" id="login"
						value="Login" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>