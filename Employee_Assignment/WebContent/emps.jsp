<%@page import="com.valtech.dao.Employee"%>
<%@page import="com.valtech.dao.EmployeeDAO"%>
<%@page import="java.util.List"%>
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
	<%
		List<Employee> emps = (List<Employee>) request.getAttribute("emps");
	%>
	<table>
		<thead>
			<tr>
				<td><b>Id</b></td>
				<td><b>Name</b></td>
				<td><b>Age</b></td>
				<td><b>Gender</b></td>
				<td><b>Salary</b></td>
				<td><b>Operations</b></td>
			</tr>
		</thead>
		<tbody>
			<%
				for (Employee e : emps) {
			%>
			<tr>
				<td><%=e.getId()%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getAge()%></td>
				<td><%=e.getGender()%></td>
				<td><%=e.getSalary()%></td>
				<td>
				<a href="empCtlr?empid=<%=e.getId() %>"><button>ViewDetails</button></a>
					<form action="empCtlr?empid=<%= e.getId() %>" method="post">
						<input name="submit" type="submit" value="updateEmp" />
					</form> 
					<a href="empCtlr?submit=delete&empid=<%=e.getId() %>"><button>Delete</button></a>
				</td>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
	<form action="empCtlr" method="post">
		<input type="submit" name="submit" value="New Employee" />
	</form>
</body>
</html>