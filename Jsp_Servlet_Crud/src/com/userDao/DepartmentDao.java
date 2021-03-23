package com.userDao;
import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Department;

public class DepartmentDao 
{

	private String jdbcURL = "jdbc:mysql://192.168.100.55/practical";
	private String jdbcUsername = "javauser";
	private String jdbcPassword = "java@123";

	private static final String INSERT_DEPARTMENT_SQL = "INSERT INTO DEPARTMENT" + "  (dept_name) VALUES " + " (?);";

	private static final String SELECT_DEPARTMENT_BY_ID = "select dept_id,dept_name from Department where dept_id =?";
	private static final String SELECT_ALL_DEPARTMENT = "select * from Department";
	private static final String DELETE_DEPARTMENT_SQL = "delete from Department where dept_id = ?;";
	private static final String UPDATE_DEPARTMENT_SQL = "update Department set dept_name = ? where dept_id = ?;";


	public DepartmentDao() 
	{
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertDepartment(Department department) throws SQLException {
		System.out.println(INSERT_DEPARTMENT_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT_SQL)) {
			preparedStatement.setString(1, department.getDept_name());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Department selectDepartment(int dept_id) {
		Department department = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_BY_ID);) {
			preparedStatement.setInt(1,dept_id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String dept_name = rs.getString("dept_name");
				
				department = new Department(dept_id,dept_name);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return department;
	}

	public List<Department> selectAllDepartment() {
		List<Department> department = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENT);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int dept_id = rs.getInt("dept_id");
				String dept_name = rs.getString("dept_name");
				department.add(new Department(dept_id,dept_name));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return department;
	}

	public boolean deleteDepartment(int dept_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DEPARTMENT_SQL);) {
			statement.setInt(1, dept_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateDepartment(Department department) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DEPARTMENT_SQL);) {
			statement.setString(1, department.getDept_name());
			statement.setInt(2, department.getDept_id());

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
