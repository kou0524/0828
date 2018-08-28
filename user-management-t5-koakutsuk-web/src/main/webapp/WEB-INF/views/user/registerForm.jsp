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

			<table>
				<tr>
					<td><form:label path="userID" cssErrorClass="error-label">ユーザID</form:label></td>
					<td><form:input path="userID" cssErrorClass="error-input"
							value="0022" /></td>
					<td><form:errors path="userID" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="userName" cssErrorClass="error-label">名前</form:label></td>
					<td><form:input path="userName" cssErrorClass="error-input"
							value="koakutsu" /></td>
					<td><form:errors path="userName" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="password" cssErrorClass="error-label">パスワード</form:label></td>
					<td><form:password path="password" cssErrorClass="error-input"
							value="123456" /></td>
					<td><form:errors path="password" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="confirmPassword"
							cssErrorClass="error-label">パスワード(確認)</form:label></td>
					<td><form:password path="confirmPassword"
							cssErrorClass="error-input" value="123456" /></td>
					<td><form:errors path="confirmPassword"
							cssClass="error-messages" /></td>
				</tr>

				<tr>
					<td><form:label path="birthday" cssErrorClass="error-label">生年月日</form:label></td>
					<td><fmt:formatDate value="${accountCreateForm.birthday}"
							pattern="yyyy/MM/dd" var="formattedBirthday" /><input
						type="date" id="birthday" name="birthday"
						 /> (yyyy/MM/dd 形式)</td>
					<td><form:errors path="birthday" cssClass="error-messages" /></td>
				</tr>


				<tr>
					<td><form:label path="address" cssErrorClass="error-label">住所</form:label></td>
					<td><form:input path="address" value="東京都江東区1丁目"
							cssErrorClass="error-input" /></td>
					<td><form:errors path="address" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="phoneNumber" cssErrorClass="error-label">電話番号</form:label></td>
					<td><form:input path="phoneNumber" cssErrorClass="error-input"
							value="09087654321" /></td>
					<td><form:errors path="phoneNumber" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><label for="roles"> 権限：</label></td>
					<td><form:checkboxes path="roles" items="${CL_ROLESSTATUS}"
							delimiter="　 " /></td>
					<td><form:errors path="roles" cssClass="error-messages" /></td>

				</tr>


				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="confirm" id="confirm"
						value="確認" /></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>