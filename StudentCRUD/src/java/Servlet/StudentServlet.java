package Servlet;

import dao.StudentDao;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            StudentDao.delete(id);
            response.sendRedirect("home.jsp");

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            Student s = StudentDao.getStudentById(id);

            request.setAttribute("s", s);
            request.getRequestDispatcher("edit.jsp").forward(request, response);

        } else if ("addForm".equals(action)) {

            request.getRequestDispatcher("add.jsp").forward(request, response);

        } else {

            request.setAttribute("list", StudentDao.getAllStudents());
            request.getRequestDispatcher("all.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            Student s = new Student();

            s.setName(request.getParameter("name"));
            s.setSubject(request.getParameter("subject"));
            s.setMarks(request.getParameter("marks"));
            s.setDepartment(request.getParameter("department"));

            StudentDao.save(s);

            response.sendRedirect("home.jsp");

        } else if ("update".equals(action)) {

            Student s = new Student();

            s.setId(Integer.parseInt(request.getParameter("id")));
            s.setName(request.getParameter("name"));
            s.setSubject(request.getParameter("subject"));
            s.setMarks(request.getParameter("marks"));
            s.setDepartment(request.getParameter("department"));

            StudentDao.update(s);

            response.sendRedirect("home.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}