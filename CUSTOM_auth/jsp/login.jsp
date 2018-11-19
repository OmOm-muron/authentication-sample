<%@ page contentType="text/html;charset=shift-jis" pageEncoding="shift-jis" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=shift-jis">
		<title>ログインページ</title>
	</head>
	<body>
		<h1>ログイン画面</h1>
		<p><c:out value="${message}"/></p>
		<form method="POST" action="login-check" name="loginform">
			<table>
				<tr>
					<td>ユーザ名</td>
					<td><input type="test" name="user" size="32"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="password" size="32"></td>
				</tr>
				<tr>
					<td><input type="submit" value="ログイン"></td>
					<td><input type="reset" value="リセット"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
