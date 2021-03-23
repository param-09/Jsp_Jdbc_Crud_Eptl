package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Department;
import com.model.Employee;
import com.model.User;
import com.userDao.DepartmentDao;
import com.userDao.EmployeeDao;
import com.userDao.UserDao;

@WebServlet("/")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;

	public void init() {
		userDao = new UserDao();
		employeeDao = new EmployeeDao();
		departmentDao = new DepartmentDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/new_employee":
				showNewEmployeeForm(request, response);
				break;
			case "/insert_employee":
				insertEmployee(request, response);
				break;
			case "/delete_employee":
				deleteEmployee(request, response);
				break;
			case "/edit_employee":
				showEditEmployeeForm(request, response);
				break;
			case "/update_employee":
				updateEmployee(request, response);
				break;
			case "/list_employee":
				listEmployee(request, response);
				break;

			case "/new_department":
				showNewDepartmentForm(request, response);
				break;
			case "/insert_department":
				insertDepartment(request, response);
				break;
			case "/delete_department":
				deleteDepartment(request, response);
				break;
			case "/edit_department":
				showEditDepartmentForm(request, response);
				break;
			case "/update_department":
				updateDepartment(request, response);
				break;
			case "/list_department":
				listDepartment(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		User newUser = new User(name, contact, email);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");

		User user = new User(id, name, contact, email);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");

	}
	///////////////////////////////////////////////////////////////////////////////////////

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employeeDao.selectAllEmployee();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		Employee existingEmployee = employeeDao.selectEmployee(emp_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}                                           

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emp_name = request.getParameter("emp_name");
		int dept_id = Integer.parseInt(request.getParameter(("dept_id")));
		String emp_gender = request.getParameter("emp_gender");
		Employee newEmployee = new Employee(emp_name, dept_id, emp_gender);
		employeeDao.insertEmployee(newEmployee);
		response.sendRedirect("list_employee");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String emp_name = request.getParameter("emp_name");
		int dept_id = Integer.parseInt(request.getParameter(("dept_id")));
		String emp_gender = request.getParameter("emp_gender");

		Employee employee = new Employee(emp_id, emp_name, dept_id, emp_gender);

		employeeDao.updateEmployee(employee);
		response.sendRedirect("list_employee");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		employeeDao.deleteEmployee(emp_id);
		response.sendRedirect("list_employee");

	}
	////////////////////////////////////////////////////////////////////////////

	private void listDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Department> listDepartment = departmentDao.selectAllDepartment();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewDepartmentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditDepartmentForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		Department existingDepartment = departmentDao.selectDepartment(dept_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("department-form.jsp");
		request.setAttribute("department", existingDepartment);
		dispatcher.forward(request, response);

	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String dept_name = request.getParameter("dept_name");
		Department newDepartment = new Department(dept_name);
		departmentDao.insertDepartment(newDepartment);
		response.sendRedirect("list_department");
	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		String dept_name = request.getParameter("dept_name");

		Department department = new Department(dept_id, dept_name);
		departmentDao.updateDepartment(department);
		response.sendRedirect("list_department");
	}

	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		departmentDao.deleteDepartment(dept_id);
		response.sendRedirect("list_department");

	}

}
