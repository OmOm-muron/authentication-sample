<%@ page contentType="text/html;charset=shift-jis" pageEncoding="shift-jis" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=shift-jis">
		<title>���O�C���y�[�W</title>
	</head>
	<body>
		<h1>���O�C�����</h1>
		<p><c:out value="${message}"/></p>
		<form method="POST" action="login-check" name="loginform">
			<table>
				<tr>
					<td>���[�U��</td>
					<td><input type="test" name="user" size="32"></td>
				</tr>
				<tr>
					<td>�p�X���[�h</td>
					<td><input type="password" name="password" size="32"></td>
				</tr>
				<tr>
					<td><input type="submit" value="���O�C��"></td>
					<td><input type="reset" value="���Z�b�g"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
