<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>削除完了画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div class="container">

		<h3>ユーザ削除が完了しました。</h3>

		<tr>
			<td><form:form
					action="${pageContext.request.contextPath}/logout" method="post">
					<button type="submit" name="ログアウト">Logout</button>
				</form:form></td>
		</tr>

		<form method="get" action="${pageContext.request.contextPath}/top">
			<input type="submit" value="トップページへ戻る" />
		</form>
	</div>
</body>
</html>