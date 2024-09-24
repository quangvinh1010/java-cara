/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vinh.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vinh.dev.admin.BaseAdminServlet;
import vinh.dev.data.dao.DatabaseDao;
import vinh.dev.data.dao.UserDao;
import vinh.dev.data.model.User;

/**
 *
 * @author 22 STORE
 */
public class CreateUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("admin/user/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String repassword = request.getParameter("repassword");
    String role = request.getParameter("role");
    HttpSession session = request.getSession();
    UserDao userDao = DatabaseDao.getInstance().getUserDao();
    User user = userDao.find(email);

    // Check for null values before checking if they are empty
    if (email == null || password == null || repassword == null || role == null ||
        email.isEmpty() || password.isEmpty() || repassword.isEmpty() || role.isEmpty()) {
        session.setAttribute("error", "Vui Long Dien Day Du Thong Tin");
        request.getRequestDispatcher("/admin/user/create.jsp").forward(request, response);
        return;
    } else if (user != null) {
        session.setAttribute("error", "Email Da Ton Tai");
        request.getRequestDispatcher("/admin/user/create.jsp").forward(request, response);
        return;
    } else if (!password.equals(repassword)) {
        session.setAttribute("error", "Mat Khau Khong Khop");
        request.getRequestDispatcher("/admin/user/create.jsp").forward(request, response);
        return;
    } else {
        user = new User(email, password, role);
        userDao.insert(user);
        response.sendRedirect("IndexUserServlet");
    }
}


}
