<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<form action="empCtlr" method="post">
		<table>
		<tr>
			<td><b>Name</b></td>
			<td><input name="name" type="text" placeholder="enter employee name" /></td>
		</tr>
		<tr>
			<td><b>Age</b></td>
			<td><input name="age" type="text" placeholder="enter employee age"/></td>
		</tr>
		<tr>
			<td><b>Gender</b></td>
			<td><input name="gender" type="text" placeholder="enter employee gender"/></td>
		</tr>
		<tr>
			<td><b>Salary</b></td>
			<td><input name="salary" type="text" placeholder="enter employee salary"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="Save" /></td>
			<td><input type="submit" name="submit" value="Cancel" /></td>
		</tr>
		</table>
	</form>
</body>
</html>