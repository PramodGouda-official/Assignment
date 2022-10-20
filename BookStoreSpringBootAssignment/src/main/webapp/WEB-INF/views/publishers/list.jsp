<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publishers</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body class="w-50">
	<div align="center">
		<h2>List of Publishers</h2>
		<table class="table table-bordered table-striped text-center">
			<thead>
				<tr>
					<td>Publisher Id</td>
					<td>Publisher Name</td>
					<td>Address</td>
					<td>Phone Number</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${publishers}" var="publisher">
					<tr>
						<td><a href="/publishers/updatePublisher/${publisher.id}">${publisher.id}</a></td>
						<td>${publisher.name}</td>
						<td>${publisher.address}</td>
						<td>${publisher.phoneNum}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>