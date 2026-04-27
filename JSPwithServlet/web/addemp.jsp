<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@include file="header.jsp" %>

<div class="container my-4">

    <h2 class="text-success mb-3">Add Employee</h2>

    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="add">

        <div class="row">

            <div class="col-md-6 mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="col-md-6 mb-3">
                <label>Join Date</label>
                <input type="date" name="joindate" class="form-control" required >
            </div>

        </div>

        <div class="row">

            <div class="col-md-6 mb-3">
                <label>Designation</label>
                <input type="text" name="designation" class="form-control" required>
            </div>

            <div class="col-md-6 mb-3">
                <label>Salary</label>
                <input type="number" name="salary" step="0.01" class="form-control" required>
            </div>

        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="EmployeeServlet" class="btn btn-secondary">Back</a>

    </form>

</div>

<%@include file="footer.jsp" %>