<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ情報削除画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div class="container">
	

			<h2>以下のユーザ情報を削除します。</h2>
			<table>
				<tr>
					<td><label for="userID">ユーザID:</label></td>
					<td id="userID">${f:h(account.userID)}</td>
				</tr>
				<tr>
					<td><label for="userName">名前:</label></td>
					<td id="userName">${f:h(account.userName)}</td>
				</tr>
				<tr>
					<td><label for="birthday">生年月日:</label></td>
					<td><span id="birthday"> <fmt:formatDate
								value="${account.birthday}" pattern="yyyy/MM/dd" />
					</span></td>
				</tr>
				<tr>
					<td><label for="address">住所:</label></td>
					<td id="address">${f:h(account.address)}</td>
				</tr>
				<tr>
					<td><label for="phoneNumber">電話番号:</label></td>
					<td id="phoneNumber">${f:h(account.phoneNumber)}</td>
				</tr>
				<tr>
					<td><label for="role">権限:</label></td>
					<td id="role">${f:h(account.role)}</td>
				</tr>
				<tr>

					<td><form method="get"
							action="${pageContext.request.contextPath}/user/delete">
							<input type="submit" id="finish" name="finish" value="削除" />
						</form></td>
				</tr>
			</table>
	
		<form method="get"
			action="${pageContext.request.contextPath}/user/search">
			<input type="submit" name="form" value="検索画面へ戻る" />
		</form>
	</div>

</body>
</html>