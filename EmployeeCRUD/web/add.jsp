<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div class="container mt-5">
    <h2 class="text-primary">Add Employee</h2>

    <!-- Error Message -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form action="EmployeeServlet" method="post">

        <input type="hidden" name="action" value="add">

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Designation</label>
            <input type="text" name="designation" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Salary</label>
            <input type="text" name="salary" class="form-control"
                   pattern="^[0-9]+(\\.[0-9]+)?$"
                   title="Enter a valid number"
                   required>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="EmployeeServlet" class="btn btn-secondary">Back</a>

    </form>
</div>

<%@include file="footer.jsp" %>