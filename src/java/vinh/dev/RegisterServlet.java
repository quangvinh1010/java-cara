/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vinh.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vinh.dev.data.dao.DatabaseDao;
import vinh.dev.data.dao.UserDao;
import vinh.dev.data.model.User;

/**
 *
 * @author 22 STORE
 */
public class RegisterServlet extends BaseServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);

        // Forward to the registration page
        request.getRequestDispatcher("register.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve the email and password from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Get or create the current session
        HttpSession session = request.getSession();

        // Get the UserDao instance to interact with the database
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email);

        // Check if the user already exists in the database
        if (user != null) {
            // Set error message in session if the email already exists
            session.setAttribute("error", "Email already exists");

            // Reload the registration page
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            // Create a new user if the email does not exist
            user = new User(email, password, "user");  // Create a new user object
            userDao.insert(user);  // Insert the new user into the database

            // Redirect to the login page after successful registration
            response.sendRedirect("LoginServlet");
        }
    }
}