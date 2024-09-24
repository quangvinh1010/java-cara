/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vinh.dev.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vinh.dev.admin.BaseAdminServlet;
import vinh.dev.data.dao.CategoryDao;
import vinh.dev.data.dao.DatabaseDao;
import vinh.dev.data.model.Category;

/**
 *
 * @author 22 STORE
 */
public class CreateCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");

        HttpSession session = request.getSession();
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();

        // Check for null values before checking if they are empty
        if (name == null || thumbnail == null 
                || name.isEmpty() || thumbnail.isEmpty() ) {
            session.setAttribute("error", "Vui Long Dien Day Du Thong Tin");
            request.getRequestDispatcher("/admin/category/create.jsp").forward(request, response);
        } else {
            Category category = new Category(name, thumbnail);
            categoryDao.insert(category);
            response.sendRedirect("IndexCategoryServlet");
        }
    }

}
