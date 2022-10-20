<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Addresses of Authors</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<body>
	<form action="newAddress" method="post">
		<table class="table table-bordered table-striped text-center">
			<tr>
				<td>Street</td>
				<td><input type="text" name="street" />
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" />
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" />
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><input type="text" name="zipcode" />
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Save" /></td>
				<td><input type="submit" name="submit" value="Cancel" /></td>
			</tr>
		</table>
	</form>
</body>
</html>