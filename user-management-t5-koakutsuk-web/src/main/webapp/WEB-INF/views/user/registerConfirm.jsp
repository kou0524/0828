<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Account Create Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div class="container">

		<form:form action="${pageContext.request.contextPath}/user/register"
			method="post" modelAttribute="accountCreateForm">

			<h3>以下の内容でアカウントを登録します。内容に誤りがなければ、OKボタンを押下してください。</h3>
			<table>
				<tr>
					<td><label for="userID">ユーザID</label></td>
					<td><span id="userID">${accountCreateForm.userID}</span></td>
				</tr>
				<tr>
					<td><label for="userName">名前</label></td>
					<td><span id="userName">${accountCreateForm.userName}</span></td>
				</tr>
				<tr>
					<td><label for="password">パスワード</label></td>
					<td><span id="password">${accountCreateForm.password}</span></td>
				</tr>
				<tr>
					<td><label for="birthday">生年月日</label></td>
					<td><span id="birthday"><fmt:formatDate
								value="${accountCreateForm.birthday}" pattern="yyyy/MM/dd" /></span></td>
				</tr>
				<tr>
					<td><label for="address">住所</label></td>
					<td><span id="address">${accountCreateForm.address}</span></td>
				</tr>
				<tr>
					<td><label for="phoneNumber">電話番号</label></td>
					<td><span id="phoneNumber">${accountCreateForm.phoneNumber}</span></td>
				</tr>
				<tr>
					<td><label for="role">権限</label></td>
					<td><span id="role">${f:h(accountCreateForm.roles)}</span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" id="finish" name="finish" value="OK" /></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>