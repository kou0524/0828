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
			<sec:authentication property="principal.account.userName" />
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
				modelAttribute="searchForm" method="post">
				<%-- (3) --%>
				<tr>
					<td><form:label path="userID">ユーザID:</form:label></td>
					<td><form:input path="userID"  /></td>
					<td><form:errors path="userID" /></td>


				</tr>
				<tr>
					<td><form:label path="userName">名前:</form:label></td>
					<td><form:input path="userName"  /></td>
					<td><form:errors path="userName" /></td>
				</tr>
				<tr>
					<td><form:label path="birthday">生年月日:</form:label></td>
					<td><form:input path="birthday" />(yyyy/MM/dd
						形式)</td>
					<td><form:errors path="birthday" /></td>
				</tr>
				<tr>
					<td><form:label path="address">住所:</form:label></td>
					<td><form:input path="address"/></td>
					<td><form:errors path="address" /></td>
				</tr>
				<tr>
					<td><form:label path="phoneNumber">電話番号:</form:label></td>
					<td><form:input path="phoneNumber"/></td>
					<td><form:errors path="phoneNumber" /></td>

				</tr>
				<tr>
					<td><form:label path="role" cssErrorClass="error-label">権限：</form:label></td>
					<td><form:select path="role">
							<form:option value="" label="選択してください" />
							<form:options items="${CL_ROLESSTATUS}" />
						</form:select></td>
					<td><form:errors path="role" cssClass="error-messages" /></td>
				</tr>
				<tr>
					<td><form:label path="state" cssErrorClass="error-label">状態：</form:label></td>
					<td><form:select path="state">
							<form:option value="" label="選択してください" />
							<form:options items="${CL_USERSTATE}" />
						</form:select></td>
					<td><form:errors path="state" cssClass="error-messages" /></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input name="confirm" type="submit" id="confirm"
						value="検索" /></td>

				
			</form:form>
		</table>

	</div>
</body>
</html>