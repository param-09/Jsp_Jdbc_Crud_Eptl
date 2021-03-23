package com.userDao;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDao 
{

	private String jdbcURL = "jdbc:mysql://192.168.100.55/practical";
	private String jdbcUsername = "javauser";
	private String jdbcPassword = "java@123";

	
	private static final String SELECT_EMPLOYEE_BY_ID = "select emp_id,emp_name,dept_id from Employee where emp_id =?";
	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO Employee" + "  (emp_name , dept_id, emp_gender) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_ALL_EMPLOYEE = "select * from Employee";
	private static final String DELETE_EMPLOYEE_SQL = "delete from Employee where emp_id = ?;";
	private static final String UPDATE_EMPLOYEE_SQL = "update Employee set emp_name = ?, dept_id =? ,emp_gender= ? where emp_id = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEE_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
			preparedStatement.setString(1, employee.getEmp_name());
			preparedStatement.setInt(2, employee.getDept_id());
			preparedStatement.setString(3,employee.getEmp_gender() );
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Employee selectEmployee(int emp_id) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
			preparedStatement.setInt(1, emp_id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String emp_name = rs.getString("emp_name");
				int dept_id = rs.getInt("dept_id");
				String emp_gender = rs.getString("emp_gender");
				employee = new Employee(emp_id, emp_name, dept_id,emp_gender);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}

	public List<Employee> selectAllEmployee() {
		List<Employee> employee = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				int dept_id = rs.getInt("dept_id");
				String emp_gender = rs.getString("emp_gender");
				employee.add(new Employee(emp_id, emp_name,dept_id ,emp_gender));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}

	public boolean deleteEmployee(int emp_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
			statement.setInt(1, emp_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
			statement.setString(1, employee.getEmp_name());
			statement.setInt(2, employee.getDept_id());
			statement.setString(3, employee.getEmp_gender());
			statement.setInt(4, employee.getEmp_id());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) 
	{
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
