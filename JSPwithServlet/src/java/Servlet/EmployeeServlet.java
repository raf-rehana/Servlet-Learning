package Servlet;

import dao.EmployeeDao;
import entity.Employee;
import java.io.IOException;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDao.deleteEmp(id);
            response.sendRedirect("EmployeeServlet");

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            Employee e = EmployeeDao.getById(id);

            request.setAttribute("emp", e);
            request.getRequestDispatcher("editemp.jsp").forward(request, response);

        } else if ("addForm".equals(action)) {

            request.getRequestDispatcher("addemp.jsp").forward(request, response);

        } else {

            request.setAttribute("list", EmployeeDao.getAllEmp());
            request.getRequestDispatcher("allemp.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            Employee emp = new Employee();

            emp.setName(request.getParameter("name"));

            emp.setJoindate(Date.valueOf(request.getParameter("joindate")));

            emp.setDesignation(request.getParameter("designation"));

            emp.setSalary(Double.parseDouble(request.getParameter("salary")));

            EmployeeDao.saveEmp(emp);

            response.sendRedirect("EmployeeServlet");

        } else if ("update".equals(action)) {

            Employee emp = new Employee();

            emp.setId(Integer.parseInt(request.getParameter("id")));
            emp.setName(request.getParameter("name"));
            emp.setJoindate(Date.valueOf(request.getParameter("joindate")));
            emp.setDesignation(request.getParameter("designation"));
            emp.setSalary(Double.parseDouble(request.getParameter("salary")));

            EmployeeDao.updateEmp(emp);

            response.sendRedirect("EmployeeServlet");
        }
    }
}
