<!DOCTYPE html>
<html>
<head>
<title>検索フォーム表示</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div id="wrapper">
		<p>
			ログインユーザ：
			<sec:authentication property="principal.account.UserName" />
		</p>
		<c:if test="${param.containsKey('error')}">
			<t:messagesPanel messagesType="error"
				messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION" />
			<%-- (2) --%>
		</c:if>

		<table>
			<tr>
				<td><form:form
						action="${pageContext.request.contextPath}/logout" method="post">
						<button type="submit" name="logout">Logout</button>
					</form:form></td>
			</tr>
			<form:form action="${pageContext.request.contextPath}/user/search"
				method="post">
				<%-- (3) --%>
				<tr>
					<td><label for="username">ユーザID</label></td>
					<td><input type="text" id="username" name="username"></td>


				</tr>
				<tr>
					<td><label for="name">名前</label></td>
					<td><input type="text" id="name" name="name" /></td>
				</tr>
				<tr>
					<td><label for="birthday">生年月日</label></td>
					<td><input type="text" id="birthday" name="birthday" />
						(yyyy/MM/dd 形式)</td>
				</tr>
				<tr>
					<td><label for="address">住所</label></td>
					<td><input type="text" id="address" name="address" /></td>
				</tr>
				<tr>
					<td><label for="role">権限</label></td>
					<td><select id="role" name="role" />
						<option value="ADMIN">ADMIN</option>
						<option value="USER">USER</option> </select></td>

				</tr>
				<tr>
					<td><label for="state">状態</label></td>
					<td><select id="state" name="state" />
						<option value="ADMIN">ACTV(有効状態)</option>
						<option value="USER">INIT(初期状態)</option>
						<option value="USER">RMVD(削除済み)</option> </select></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input name="submit" type="submit" id="検索" value="検索" /></td>
				</tr>
			</form:form>
		</table>

	</div>
</body>
</html>