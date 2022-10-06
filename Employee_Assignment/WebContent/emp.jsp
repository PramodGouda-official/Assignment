<%@page import="com.valtech.dao.Employee"%>
<%@page import="com.valtech.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
<style>
body {
	text-align: left;
}

table, th, td {
	border: 1.5px solid black;
}
</style>
</head>
<body>
	<!-- <h2>http://localhost:8080/valtechWeb3/empCtlr?empid=3</h2> -->
	<%
		EmployeeDAO dao = new EmployeeDAO();
		int id = Integer.parseInt(request.getParameter("empid"));
		Employee e = dao.getEmployee(id);
		String prev = "empCtlr?empId=" + dao.getPreviousId(id);
		String next = "empCtlr?empId=" + dao.getNextId(id);
		String first = "empCtlr?empId="+ dao.getFirstId();
		String last = "empCtlr?empId=" + dao.getLastId();
		String home = "empCtlr";
	%>
	<table>
		<tr>
			<td>Id</td>
			<td><%=e.getId()%></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=e.getName()%></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><%=e.getAge()%></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><%=e.getGender()%></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><%=e.getSalary()%></td>
		</tr>
		<tr>
			<td><a href=<%=prev%>> Previous </a></td>
			<td><a href=<%=next%>> Next </a></td>
			<td><a href=<%=first%>> First </a></td>
			<td><a href=<%=last%>> Last </a></td>
			<td><a href=<%=home%>> Home </a></td>
		</tr>
	</table>
</body>
</html>