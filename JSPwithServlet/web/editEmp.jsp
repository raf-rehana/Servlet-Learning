<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<div class="container my-5">
    <div class="bg-primary text-center text-white p-2">
        <h2>Edit Employee</h2>
    </div>

    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${emp.id}">

        <div class="row mt-3">
            <div class="col-md-6">
                <label class="form-label">Name</label>
                <input type="text" class="form-control"
                       name="name"
                       value="${emp.name}"
                       required>
            </div>

            <div class="col-md-6">
                <label class="form-label">Salary</label>
                <input type="number" step="0.01"
                       class="form-control"
                       name="salary"
                       value="${emp.salary}"
                       required>
            </div>
        </div>

        <div class="row mt-4 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success">
                    Update
                </button>
            </div>

            <div class="col-md-6">
                <a href="EmployeeServlet" class="btn btn-secondary">
                    Back
                </a>
            </div>
        </div>
    </form>
</div>

<%@include file="footer.jsp" %>