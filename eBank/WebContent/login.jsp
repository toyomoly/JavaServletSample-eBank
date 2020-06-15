<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Sample</title>
</head>
<body>
	<div class="log_wrap">
		<h1 class="log_h1">ログイン認証</h1>
		<c:if test="${loginError}">
			<p class="error-message"><c:out value="${message}" /></p>
		</c:if>
		<div>
			<form action="./login" method="post">
				<table class="login_table">
					<tr>
						<td>ユーザー名</td>
						<td class="login_box"><input type="text" name="user-id"
							placeholder="ユーザー名を入力" /></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td class="login_box"><input type="password" name="password"
							placeholder="パスワードを入力" /></td>
					</tr>
				</table>
				<div class="login_btn">
					<input class="btn" type="submit" value="送信" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>