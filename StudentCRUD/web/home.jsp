<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@include file="header.jsp" %>
<%@page import="dao.StudentDao" %>
<%@page import="entity.Student" %>
<%@page import="java.util.*" %>
<% 
    List<Student> list = StudentDao.getAllStudents();
    request.setAttribute("list", list);
%>
<h1 class="text-primary">All Students</h1>

<div class="d-flex justify-content-between align-items-center mb-3">

    <a href="StudentServlet?action=addForm" class="btn btn-success">
        + Add Student
    </a>

</div>

<table class="table table-bordered table-hover">

    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Class</th>
            <th>Roll</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

        <c:choose>

            <c:when test="${empty list}">
                <tr>
                    <td colspan="5" class="text-center text-danger">
                        No Students Found
                    </td>
                </tr>
            </c:when>

            <c:otherwise>

                <c:forEach items="${list}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.studentClass}</td>
                        <td>${s.roll}</td>

                        <td>
                            <a href="StudentServlet?action=edit&id=${s.id}" 
                               class="btn btn-sm btn-primary">
                                Edit
                            </a>

                            <a href="StudentServlet?action=delete&id=${s.id}" 
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