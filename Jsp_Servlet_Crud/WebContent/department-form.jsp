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
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_department"
					class="nav-link">Departments</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${department != null}">
					<form action="update_department" method="post">
				</c:if>
				<c:if test="${department == null}">
					<form action="insert_department" method="post">
				</c:if>

				<caption>
					<h2 align="center">
						<c:if test="${department != null}">
            			Update Department
            		</c:if>
						<c:if test="${department == null}">
            			Add New Department
            		</c:if>
					</h2>
				</caption>

				<c:if test="${department != null}">
					<input type="hidden" name="dept_id" value="<c:out value='${department.dept_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Department Name</label> <input type="text"
						value="<c:out value='${department.dept_name}' />" class="form-control"
						name="dept_name" required="required"  placeholder=" Enter Name">
				</fieldset>&nbsp;&nbsp;&nbsp;

				<div align="center"><button type="submit" class="btn btn-success btn-lg" >Save</button></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
