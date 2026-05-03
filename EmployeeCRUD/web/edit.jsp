<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>

    <!-- Bootstrap (optional) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-primary">Edit Employee</h2>

    <form action="EmployeeServlet" method="post">

        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${e.id}">

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" class="form-control" value="${e.name}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Class</label>
            <input type="text" name="designation" class="form-control" value="${e.designation}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Salary</label>
            <input type="text" name="salary" class="form-control" value="${e.salary}" required>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
        <a href="EmployeeServlet" class="btn btn-secondary">Back</a>

    </form>
</div>

</body>
</html>
<%@include file="footer.jsp" %>