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
       style="background-color: tomato">

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
  </nav>
</header>
<br>
<div class="container col-md-5">
  <div class="card">
    <div class="card-body">
      <c:if test="${teacher != null}">
      <form action="<%=request.getContextPath()%>/updateTeacher" method="post">
        </c:if>
        <c:if test="${teacher == null}">
        <form action="<%=request.getContextPath()%>/registerTeacher" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${teacher != null}">
                Edit Teacher
              </c:if>
              <c:if test="${teacher == null}">
                Add New Teacher
              </c:if>
            </h2>
          </caption>

          <c:if test="${teacher != null}">
            <input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
          </c:if>

          <fieldset class="form-group">
            <label>Teacher Name</label> <input type="text"
                                               value="<c:out value='${teacher.name}' />" class="form-control"
                                               name="name" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>Teacher Email</label> <input type="text"
                                                value="<c:out value='${teacher.email}' />" class="form-control"
                                                name="email">
          </fieldset>

          <fieldset class="form-group">
            <label>Teacher Subject</label> <input type="text"
                                                  value="<c:out value='${teacher.subject}' />" class="form-control"
                                                  name="subject">
          </fieldset>

          <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
  </div>
</div>
</body>
</html>