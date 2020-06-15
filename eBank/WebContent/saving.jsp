<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Sample</title>
</head>
<body class="body_bg">
	<div class="wrap">
		<div class="clearfix">
			<h1 class="items">預金残高・入出金</h1>
			<p class="welcomname">ようこそ<c:out value="${loginUser.userName}" />さん</p>
		</div>

		<p class="total">残高:<c:out value="${loginUser.saving}" />円</p>
		<form id="savingForm" action="./saving" method="post">
			<div class="saving-form">
				金額
				<input type="text" name="price" placeholder="金額を入力" />
				<input id="hiddenStatus" type="hidden" name="status" value="0" />
				<input class="btn" type="button" value="入金" onclick="sendForm(1)" />
				<input class="btn" type="button" value="出金" onclick="sendForm(2)" />
			</div>
		</form>

		<table class="item_table">
			<tr>
				<th>日時</th>
				<th class="cart_prise">区分</th>
				<th class="cart_count">入金</th>
			</tr>
			<c:forEach var="history" items="${histories}">
				<tr>
					<td><c:out value="${history.createdAtDisplayString}" /></td>
					<td><c:out value="${history.statusName}" /></td>
					<td><c:out value="${history.price} 円" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function sendForm(status){
			// type="hidden" のinputにstatusを設定
			// 1:入金, 2:出金
			document.querySelector("#hiddenStatus").value = status;
			// フォーム送信
			document.querySelector("#savingForm").submit();
		}
	</script>
</body>
</html>