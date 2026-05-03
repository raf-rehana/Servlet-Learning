<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="header.jsp" %>
<%@page import="dao.EmployeeDao" %>
<%@page import="entity.Employee" %>
<%@page import="java.util.*" %>
<% 
    List<Employee> list = EmployeeDao.getAllEmployees();
    request.setAttribute("list", list);
%>
<h1 class="text-primary">All Employees</h1>

<div class="d-flex justify-content-between align-items-center mb-3">

    <a href="EmployeeServlet?action=addForm" class="btn btn-success">
        + Add Employee
    </a>

</div>

<table class="table table-bordered table-hover">

    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Salary</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

        <c:choose>

            <c:when test="${empty list}">
                <tr>
                    <td colspan="5" class="text-center text-danger">
                        No Employee Found
                    </td>
                </tr>
            </c:when>

            <c:otherwise>

                <c:forEach items="${list}" var="e">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td>${e.designation}</td>
                        <td>${e.salary}</td>

                        <td>
                            <a href="EmployeeServlet?action=edit&id=${e.id}" 
                               class="btn btn-sm btn-primary">
                                Edit
                            </a>

                            <a href="EmployeeServlet?action=delete&id=${e.id}" 
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

<%@include file="footer.jsp" %>