<html>
<head>
<title>トップ画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>


<body>
	<div id="wrapper">
		<p> ログインユーザ：<sec:authentication property="principal.account.userName"/></p>
		<table>
			<tr>
				<td><form:form
						action="${pageContext.request.contextPath}/logout" method="post">
						<button type="submit" name="logout">Logout</button>
					</form:form></td>
			</tr>
			<tr>
				<td><form:form
						action="${pageContext.request.contextPath}/user/register"
						method="GET">
						<p>
							<button type="submit" name="form"
								style="WIDTH: 100px; HEIGHT: 40px">
								<big>登録</big>
							</button>
						</p>
					</form:form></td>

				<td><form:form
						action="${pageContext.request.contextPath}/user/search"
						method="GET">
						<p>
							<button type="submit" name="form"
								style="WIDTH: 100px; HEIGHT: 40px">
								<big>検索</big>
							</button>
						</p>
					</form:form></td>
			</tr>
		</table>
	</div>
</body>
</html>