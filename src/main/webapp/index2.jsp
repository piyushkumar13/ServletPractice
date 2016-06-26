<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="httpservlet" method="get">

		<table>
			<tr>
				<td>Enter your name :</td>
				<td><input type="text" name="http_input_name" /></td>
			</tr>
			<tr>
				<td>Enter your password :</td>
				<td><input type="password" name="http_input_password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit to http servlet"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>