<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Application</title>
<style>
h1 {
	text-align: center;
}

p {
	text-align: left;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body>
   
   <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color:teal">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> 
					Manage -></a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
					<li><a href="<%=request.getContextPath()%>/list_employee"
					class="nav-link">Employees</a></li>
					<li><a href="<%=request.getContextPath()%>/list_department"
					class="nav-link">Departments</a></li>
			</ul>
		</nav>
	</header>

        <h2>

<div align="center"><font color="tomato"><h1>WELCOME TO MANAGEMENT APP</h1></font></div>
			<div align="right" class="container my-2">
		<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
				<a href="<%=request.getContextPath()%>/new_employee" class="btn btn-success">Add
					New Employee</a>
							<a href="<%=request.getContextPath()%>/new_department" class="btn btn-success">Add
					New Department</a>
			
            <!--  <a href="/new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All User</a>
             -->
        </h2>
</body>
</html>
<!-- <div align="center" class="container">
        <table border="1" class="table table-bordered">
            <tr align="center">
                <th>ID</th>
                <th>Name</th>
                <th>Contact</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.contact}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    
                
                    <td>
                        <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> -->