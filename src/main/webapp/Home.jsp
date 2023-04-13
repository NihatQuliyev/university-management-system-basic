<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h1 {text-align: center;}
    </style>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
        <nav class="navbar navbar-expand-md navbar-dark"
             style="background-color: #0080ff">

            <div>
                <b class="navbar-brand"> University
                    Management App </b>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listStudent" style="color: aliceblue"
                       class="nav-link">Student List </a> </li>
                <li><a href="<%=request.getContextPath()%>/listTeacher " style="color: aliceblue"
                       class="nav-link">Teacher List</a></li>
            </ul>

        </nav>

    <div>
        <br>
        <h1>University Management System</h1>
        <br><br>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <img src="https://png.pngtree.com/png-vector/20190425/ourlarge/pngtree-vector-male-student-icon-png-image_992053.jpg" width="200" height="400" class="card-img-top" alt="Student Logo">
                        <h5 class="card-title mt-3">Student List</h5>
                        <a href="<%=request.getContextPath()%>/listStudent" class="btn btn-primary">Go to Student List</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <img src="https://thumbs.dreamstime.com/b/teacher-chalkboard-icon-white-background-teacher-chalkboard-icon-145987774.jpg" width="200" height="400" class="card-img-top" alt="Teacher Logo">
                        <h5 class="card-title mt-3">Teacher List</h5>
                        <a href="<%=request.getContextPath()%>/listTeacher" class="btn btn-primary">Go to Teacher List</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>

</body>
</html>
