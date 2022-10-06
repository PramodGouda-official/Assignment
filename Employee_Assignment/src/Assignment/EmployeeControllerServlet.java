package Assignment;

import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;

@WebServlet(urlPatterns = {"/empCtlr"})
public class EmployeeControllerServlet extends HttpServlet {

	private EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login here and fwd to jsp page
		try {
			String empid = req.getParameter("empid");
			String submit = req.getParameter("submit");

			if(empid==null){
				loadEmpsAndGoToEmpsPage(req, resp);
				return;
			}
			int id = Integer.parseInt(req.getParameter("empid"));

			if("delete".equals(submit)) {
				dao.deleteEmployee(id);
				loadEmpsAndGoToEmpsPage(req, resp);
				return;
			}
			
			Employee e = dao.getEmployee(id);
			req.setAttribute("e", e);
			req.getRequestDispatcher("emp.jsp").forward(req,resp);
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	private void loadEmpsAndGoToEmpsPage(HttpServletRequest req, HttpServletResponse resp)
			throws Exception, ServletException, IOException {
		List<Employee> emps = dao.getEmployees();
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("emps.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String submit = req.getParameter("submit");
		try {
			if("New Employee".equals(submit)){
				req.getRequestDispatcher("createEmployee.jsp").forward(req,resp);
				return;
			}
			
			if("updateEmp".equals(submit)) {
                req.getRequestDispatcher("updateEmployee.jsp").forward(req, resp);
                return;
	        }
			
			if("Save".equals(submit)) {
				Employee e = new Employee();
				e.setId(dao.getNextValidId());
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(req.getParameter("gender"));
				e.setSalary(Float.parseFloat(req.getParameter("salary")));
				dao.saveEmployee(e);
			}
			
	        if("update".equals(submit)) {
	        	String empid =req.getParameter("empid");
	        	
	            Employee e=new Employee();
	            e.setId(Integer.parseInt(req.getParameter("id")));
	            e.setName(req.getParameter("name"));
	            e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(req.getParameter("gender"));
	            e.setSalary(Float.parseFloat(req.getParameter("salary")));
	            dao.updateEmployee(e);
	        }
			
			loadEmpsAndGoToEmpsPage(req, resp);
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
