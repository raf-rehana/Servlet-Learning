package servlet;

import dao.EmployeeDao;
import entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDao.delete(id);
            response.sendRedirect("EmployeeServlet");

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            Employee e = EmployeeDao.getEmployeeById(id);

            request.setAttribute("e", e);
            request.getRequestDispatcher("edit.jsp").forward(request, response);

        } else if ("addForm".equals(action)) {

            request.getRequestDispatcher("add.jsp").forward(request, response);

        } else {

            request.setAttribute("list", EmployeeDao.getAllEmployees());
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            Employee e = new Employee();
            e.setName(request.getParameter("name"));
            e.setDesignation(request.getParameter("designation"));
            e.setSalary(request.getParameter("salary")); 

            EmployeeDao.save(e);

            response.sendRedirect("home.jsp");

        } else if ("update".equals(action)) {

            Employee e = new Employee();
            e.setId(Integer.parseInt(request.getParameter("id")));
            e.setName(request.getParameter("name"));
            e.setDesignation(request.getParameter("designation"));
            e.setSalary(request.getParameter("salary")); 

            EmployeeDao.update(e);

            response.sendRedirect("home.jsp");
        }
    }
}