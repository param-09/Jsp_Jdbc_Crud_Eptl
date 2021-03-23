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
			style="background-color: chocolate">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Emlployee Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listEmployee"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update_employee" method="post">
				</c:if>
				<c:if test="${employee == null}">
					<form action="insert_employee" method="post">
				</c:if>

				<caption>
					<h2 align="center">
						<c:if test="${employee != null}">
            			Update Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="emp_id" value="<c:out value='${employee.emp_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${employee.emp_name}' />" class="form-control"
						name="emp_name" required="required"  placeholder=" Enter Name">
				</fieldset>&nbsp;&nbsp;&nbsp;

				
				<fieldset>  		
							<label for="dept_name">Choose a department:&nbsp;&nbsp;&nbsp;</label> 
						<select  name="dept_id" id="dept_id">
						  <c:forEach items="${listDepartment}" var="employee">
						  	<option value="${department.dept_id}">${department.dept_name}</option>
						  </c:forEach>
						 <c:forEach items="${listDepartment}" var="department">${department.dept_name}<br></c:forEach>
						</select>
						
				</fieldset>&nbsp;&nbsp;&nbsp;
					<fieldset class="form-group">
					<label>Employee Gender:&nbsp;&nbsp;&nbsp;</label>
					&nbsp;&nbsp;&nbsp;<input type="radio" id="male" name="emp_gender" value="male" checked="checked">Male
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="female" name="emp_gender" value="female">Female
				<br></fieldset>
				
				<div align="center"><button type="submit" class="btn btn-success btn-lg" >Save</button></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
