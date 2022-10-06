package com.valtech.training.corejava.Employee_Assignment;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;
import org.junit.internal.Throwables;
import org.omg.CORBA.PUBLIC_MEMBER;

public class EmployeeDAOTest {

	@Test
	public void test()throws Exception {
		EmployeeDAO  dao = new EmployeeDAO();
		Connection conc = dao.getConnection();
		conc.close();
	}

	@Test
	public void testCount()throws Exception {
		EmployeeDAO  dao = new EmployeeDAO();
		int count = dao.count();
		assertEquals(count, dao.count());
	}
	
	@Test
	public void testGetEmployee()throws Exception {
		EmployeeDAO  dao = new EmployeeDAO();
		Employee e=dao.getEmployee(1);
		assertEquals(1, e.getId());
		assertEquals(25, e.getAge());
	}
	
	@Test
	public void testGetEmployees()throws Exception {
		EmployeeDAO  dao = new EmployeeDAO();
		assertEquals(dao.count(),dao.getEmployees().size());
	}
	@Test
	public void testSaveEmployee()throws Exception {
		EmployeeDAO  dao = new EmployeeDAO();
		int count = dao.count();
		dao.saveEmployee(new Employee(5,"Five",28,"Male",(float)(45000.00)));
		assertEquals(count+1, dao.count());
		dao.deleteEmployee(5);
		assertEquals(count, dao.count());
	}
		
	@Test
	public void testUpdateEmployee()throws Exception{
		EmployeeDAO  dao = new EmployeeDAO();
		dao.updateEmployee(new Employee(3,"New Three",27,"Male",(float)(45000.00)));
		Employee e=dao.getEmployee(3);
		assertEquals(e.getId(),3);
		assertEquals(e.getName(),"New Three");
		assertEquals(27,e.getAge());
		assertEquals("Male", e.getGender());
		assertEquals(45000.00, e.getSalary(),0.000001);
	}
	
	@Test
	public void testGetEmployeesByage() throws Exception{
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByAge(25);
		assertEquals(1,e.size());
		for(int i=0;i<e.size();i++) {
			System.out.println(e.get(i));
		}
		
	}
	@Test
	public void testGetEmployeesByMale() throws Exception{
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByMale("Male");
		assertEquals(2,e.size());
		for(int i=0;i<e.size();i++) {
			System.out.println(e.get(i));
		}
		
	}
	
	@Test
	public void testGetEmployeesByFemale() throws Exception{
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByFemale("Female");
		assertEquals(2,e.size());
		for(int i=0;i<e.size();i++) {
			System.out.println(e.get(i));
		}
		
	}
	@Test
	public void testGetEmployeesByOthers() throws Exception{
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> e=dao.getEmployeeByOthers("");
		assertEquals(0,e.size());
		if(e.size()==0){
			System.out.println("No such employee exist");
		}
		else {
			for(int i=0;i<e.size();i++) {
				System.out.println(e.get(i));
			}
		}
		
		
	}
	@Test
	public void testGetEmployeesByAgeBetween() throws Exception{
		EmployeeDAO daop=new EmployeeDAO();
		List<Employee> e=daop.getEmployeeByAgeBetween(24,30);
		assertEquals(3,e.size());
		for(int i=0;i<e.size();i++) {
			System.out.println(e.get(i));
		}
		
	}
	@Test
	public void testGetEmployeesBySalaryGreaterThan() throws Exception{
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> e=dao.getEmployeeBySalaryGreaterThan((float) 30000.00);
		assertEquals(2,e.size());
		for(int i=0;i<e.size();i++) {
			System.out.println(e.get(i));
		}
		
	}
	
	
	@Test
	public void testGetEmployeesBySalaryLessThan() throws Exception{
		EmployeeDAO dao=new EmployeeDAO();
		List<Employee> e=dao.getEmployeeBySalaryLessThan((float) 30000.00);
		assertEquals(2,e.size());
		for(int i=0;i<e.size();i++) {
			System.out.println(e.get(i));
		}
		
		
	}

}
