<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@include file="header.jsp" %>

<div class="container my-5">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="text-primary">All Employees</h1>

        <a href="EmployeeServlet?action=addForm" class="btn btn-success">
            + Add Employee
        </a>
    </div>

    <table class="table table-bordered table-hover">

        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Join Date</th>
                <th>Designation</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>

            <c:choose>

                <c:when test="${empty list}">
                    <tr>
                        <td colspan="6" class="text-center text-danger">
                            No Employees Found
                        </td>
                    </tr>
                </c:when>

                <c:otherwise>

                    <c:forEach items="${list}" var="s">
                        <tr>
                            <td>${s.id}</td>
                            <td>${s.name}</td>

                            <td>
                                <fmt:formatDate value="${s.joindate}" pattern="yyyy-MM-dd"/>
                            </td>

                            <td>${s.designation}</td>
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