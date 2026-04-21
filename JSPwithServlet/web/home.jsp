<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="header.jsp" %>

<div class="container my-5">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="text-primary">All Employees</h1>

        <a href="addemp.jsp" class="btn btn-success">
            + Add Employee
        </a>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>

            <c:choose>
                <c:when test="${empty list}">
                    <tr>
                        <td colspan="4" class="text-center text-danger">
                            No Employees Found
                        </td>
                    </tr>
                </c:when>

                <c:otherwise>
                    <c:forEach items="${list}" var="s">
                        <tr>
                            <td>${s.id}</td>
                            <td>${s.name}</td>
                            <td>${s.salary}</td>
                            <td>
                                <a href="EmployeeServlet?action=edit&id=${s.id}" 
                                   class="btn btn-sm btn-primary">
                                   Edit
                                </a>

                                <a href="EmployeeServlet?action=delete&id=${s.id}" 
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('Are you sure?');">
                                   Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </tbody>
    </table>
</div>

<%@include file="footer.jsp" %>