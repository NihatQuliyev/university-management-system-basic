<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
       style="background-color: #0080ff;display:flex;justify-content: space-between;">
    <div>
      <a href="Home.jsp" class="navbar-brand"> University
        Management App </a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/listStudent"
             class="nav-link">Student List</a></li>
      <li><a href="<%=request.getContextPath()%>/listTeacher"
             class="nav-link">Teacher List</a></li>
    </ul>
    <div>
      <form action="<%=request.getContextPath()%>/searchStudent" method="get">
      <input type="text" name="sc" placeholder="Search">
        <input type="submit">
      </form>
    </div>
  </nav>
</header>
<br>

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">List of Students</h3>
    <hr>
    <div class="container text-left">
      <form action="<%=request.getContextPath()%>/newStudent" method="post">
        <button type="submit" class="btn btn-success">Add New Student</button>
      </form>
    </div>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <!--   for (Todo todo: todos) {  -->
      <c:forEach var="student" items="${studentList}">

        <tr>
          <td><c:out value="${student.id}" /></td>
          <td><c:out value="${student.name}" /></td>
          <td><c:out value="${student.email}" /></td>
          <td><c:out value="${student.country}" /></td>
          <td>
            <a href="editStudent?id=<c:out value='${student.id}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;

            <a href="deleteStudent?id=<c:out value='${student.id}' />">Delete</a></td>
          </td>
        </tr>
      </c:forEach>
      <!-- } -->
      </tbody>

    </table>
  </div>
</div>
</body>
</html>