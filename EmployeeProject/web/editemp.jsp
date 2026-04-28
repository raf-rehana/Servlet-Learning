<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="header.jsp" %>

<div class="container my-4">

    <h2 class="text-primary mb-3">Edit Employee</h2>

    <!-- format date first -->
    <fmt:formatDate value="${emp.joindate}" pattern="yyyy-MM-dd" var="jdate"/>

    <form action="EmployeeServlet" method="post">

        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${emp.id}">

        <div class="row">

            <div class="col-md-6 mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control"
                       value="${emp.name}" required>
            </div>

            <div class="col-md-6 mb-3">
                <label>Join Date</label>

                <input type="date" name="joindate" class="form-control"
                       value="${jdate}" required>
            </div>

        </div>

        <div class="row">

            <div class="col-md-6 mb-3">
                <label>Designation</label>
                <input type="text" name="designation" class="form-control"
                       value="${emp.designation}" required>
            </div>

            <div class="col-md-6 mb-3">
                <label>Salary</label>
                <input type="number" name="salary" step="0.01" class="form-control"
                       value="${emp.salary}" required>
            </div>

        </div>

        <button type="submit" class="btn btn-primary">Update</button>
        <a href="EmployeeServlet" class="btn btn-secondary">Back</a>

    </form>

</div>

<%@include file="footer.jsp" %>