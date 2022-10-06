package com.valtech.training.corejava.Employee_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeeDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static final String TABLE_NAME = "employee";

	public List<Employee> getEmployees()throws Exception{
		Connection conc = getConnection();
		PreparedStatement pstmt = conc.prepareStatement("select id,name,age,gender,salary from "+TABLE_NAME);
		ResultSet rs = pstmt.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(EmployeeFromResultSet(rs));	
		}
		conc.close();
		return employees;
	}

	public Employee getEmployee(int id)throws Exception {
		Connection conc = getConnection();
		PreparedStatement pstmt = conc.prepareStatement("select id,name,age,gender,salary from "+TABLE_NAME+" where id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			Employee e = EmployeeFromResultSet(rs);
			conc.close();
			return e;
		}
		else {
			return null;
		}
	}

	public void deleteEmployee(int id)throws Exception {
		Connection conc = getConnection();
		PreparedStatement pstmt = conc.prepareStatement("delete from "+TABLE_NAME+" where id = ?");
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		conc.close();
	}
	
	public void updateEmployee(Employee e)throws Exception {
		Connection conc = getConnection();
		PreparedStatement pstmt = conc.prepareStatement("update "+TABLE_NAME+" set name= ?, age =?, gender=?, salary=? where id = ?");
		pstmt.setInt(5, e.getId());
		pstmt.setString(1, e.getName());
		pstmt.setInt(2, e.getAge());
		pstmt.setString(3, e.getGender());
		pstmt.setFloat(4, e.getSalary());
		pstmt.executeUpdate();
		conc.close();
	}

	private Employee EmployeeFromResultSet(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getString(4));
		e.setSalary(rs.getFloat(5));
		return e;
	}


	public void saveEmployee(Employee e)throws Exception {
		Connection conc = getConnection();
		PreparedStatement pstmt = conc.prepareStatement("insert into "+TABLE_NAME+" (id,name,age,gender,salary) values (?,?,?,?,?)");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getAge());
		pstmt.setString(4, e.getGender());
		pstmt.setFloat(5, e.getSalary());
		int rowsAffected = pstmt.executeUpdate();
		conc.close();
	}
	
	public List<Employee> getEmployeeByAge(int age) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" where age = ?");
		ps.setInt(1, age);
		ResultSet sq = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(sq.next()) {
			emp.add(EmployeeFromResultSet(sq));
		}
		con.close();
		return emp;		
	}
	
	public List<Employee> getEmployeeByMale(String gender) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" where gender = ?");
		ps.setString(1, gender);
		ResultSet gm = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(gm.next()) {
			emp.add(EmployeeFromResultSet(gm));
		}
		con.close();
		return emp;
	}
	public List<Employee> getEmployeeByFemale(String gender) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" where gender = ?");
		ps.setString(1, gender);
		ResultSet mp = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(mp.next()) {
			emp.add(EmployeeFromResultSet(mp));
		}
		con.close();
		return emp;
	}
	public List<Employee> getEmployeeByOthers(String gender) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" where gender = ?");
		ps.setString(1, gender);
		ResultSet ot = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(ot.next()) {
			emp.add(EmployeeFromResultSet(ot));
		}
		con.close();
		return emp;
	}
	
	public List<Employee> getEmployeeByAgeBetween(int minage,int maxage) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" WHERE age BETWEEN ? and ? ");
		ps.setInt(1, minage);
		ps.setInt(2, maxage);
		ResultSet abt = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(abt.next()) {
			emp.add(EmployeeFromResultSet(abt));
		}
		con.close();
		return emp;
	}
	public List<Employee> getEmployeeBySalaryGreaterThan(float sal) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" WHERE salary > ? ");
		ps.setFloat(1, sal);
		ResultSet slgt = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(slgt.next()) {
			emp.add(EmployeeFromResultSet(slgt));
		}
		con.close();
		return emp;
	}
	
	public List<Employee> getEmployeeBySalaryLessThan(float sal) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT id,name,age,gender,salary FROM "+TABLE_NAME+" WHERE salary < ? ");
		ps.setFloat(1, sal);
		ResultSet sllt = ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(sllt.next()) {
			emp.add(EmployeeFromResultSet(sllt));
		}
		con.close();
		return emp;
	}

	public int count()throws Exception{
		Connection conc = getConnection();
		Statement stmt = conc.createStatement();
		ResultSet rs = stmt.executeQuery("select count(id) from "+TABLE_NAME);
		if(rs.next()) {
			int count = rs.getInt(1);
			conc.close();
			return count;
		}
		else {
			conc.close();
			return -1;
		}
	}

	public Connection getConnection()throws Exception {

		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.35:1521/xe","valtrg3","valtrg3");
	}
}
