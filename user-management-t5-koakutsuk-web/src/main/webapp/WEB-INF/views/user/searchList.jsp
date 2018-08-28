<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>検索フォーム表示</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.0.0/css/bootstrap.css"
	media="screen, projection">
</head>
<body>
	<div id="wrapper">

		<p>
			<form:form action="${pageContext.request.contextPath}/logout"
				method="post">
				<button type="submit">Logout</button>
			</form:form>
		</p>
		<p>
			ログインユーザ：
			<sec:authentication property="principal.account.UserName" />
		</p>

		<t:messagesPanel />

		<div>
			<p>
				<fmt:formatNumber value="${(page.number * page.size) + 1}" />
				-
				<fmt:formatNumber
					value="${(page.number * page.size) + page.numberOfElements}" />
				<!-- 全件数 -->
				<br>
				<fmt:formatNumber value="${page.totalElements}" />
				results <br> ${f:h(page.number + 1) } / ${f:h(page.totalPages)}
				Pages

			</p>
		</div>
		<table class="maintable">
			<thead>
				<tr>
					<th class="select">選択</th>
					<th class="userID">ユーザID</th>
					<th class="userName">名前</th>
					<th class="birthday">生年月日</th>
					<th class="address">住所</th>
					<th class="phoneNumber">電話番号</th>
					<th class="state">状態</th>
					<th class="role">権限</th>
				</tr>
			</thead>
			<form:form action="${pageContext.request.contextPath}/user/delete"
				method="GET">
				<c:forEach items="${page.content}" var="search">
					<tr>
						<td><input id="userID" type="radio" name="userID"
							value="${search.userID}" /></td>

						<td class="userID">${search.userID}</td>
						<td class="userName">${search.userName}</td>
						<td class="birthday"><fmt:formatDate
								value="${search.birthday}" pattern="yyyy/MM/dd" /></td>
						<td class="address">${search.address}</td>
						<td class="phoneNumber">${search.phoneNumber}</td>
						<td class="state">${search.state}</td>
						<td class="role">${search.role}</td>
					</tr>
				</c:forEach>
				<div style="float: left;">
					<button class="small"
						formaction="${pageContext.request.contextPath}/user/delete"
						type="submit" id="userID" value="delete">削除</button>
				</div>

			</form:form>
		</table>
		<t:pagination page="${page}" outerElementClass="pagination" />

	</div>
</body>
</html>