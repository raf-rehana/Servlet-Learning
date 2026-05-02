<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>

    <!-- Bootstrap (optional) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-primary">Add Student</h2>

    <form action="StudentServlet" method="post">

        <input type="hidden" name="action" value="add">

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Class</label>
            <input type="text" name="studentClass" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Roll</label>
            <input type="text" name="roll" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="StudentServlet" class="btn btn-secondary">Back</a>

    </form>
</div>

</body>
</html>
<%@include file="footer.jsp" %>