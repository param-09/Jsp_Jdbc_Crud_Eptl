<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: darkolivegreen">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Department
					Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_department"
					class="nav-link">Departments</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Departments</h3>
			<hr>
			<div class="container text-right">

				<a href="<%=request.getContextPath()%>/new_department" class="btn btn-success">Add
					New Department</a>
			</div>
			<br>
			<table class="table table-striped">
				<thead>
					<tr align="center" class="table-success">
						
						<th>Department Id</th>
						<th>Department Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="department" items="${listDepartment}">

						<tr align="center">
							<td><c:out value="${department.dept_id}" /></td>
							<td><c:out value="${department.dept_name}" /></td>
							<td><a href="edit_department?dept_id=<c:out value='${department.dept_id}'/>" class="btn btn-primary" >Update</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								
								<a href="delete_department?dept_id=<c:out value='${department.dept_id}' />" class="btn btn-warning	">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
