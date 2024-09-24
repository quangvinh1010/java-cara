/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vinh.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import vinh.dev.data.dao.DatabaseDao;
import vinh.dev.data.dao.ProductDao;
import vinh.dev.data.model.Product;
import vinh.dev.util.Constants;

/**
 *
 * @author 22 STORE
 */
public class ShopServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> hotProductList = productDao.hot(Constants.NUMBER_LIMIT);
        List<Product> productList = productDao.findAll();

        String pageParam = request.getParameter("page");
        int page = 1; // Default to page 1 if no valid "page" parameter is provided
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1; // Default to page 1 in case of invalid input
            }
        }

        int total = productList.size();
        int numberPage = (int) Math.ceil((double) total / Constants.PER_PAGE); // Use Math.ceil for proper pagination
        page = Math.max(1, Math.min(page, numberPage)); // Ensure page is within valid range

        productList = productDao.getProducts((page - 1) * Constants.PER_PAGE, Constants.PER_PAGE); // Fetch products for the correct page

        request.setAttribute("page", page);
        request.setAttribute("total", total);
        request.setAttribute("numberPage", numberPage);

        request.setAttribute("productList", productList);
        request.setAttribute("hotProductList", hotProductList);
        request.getRequestDispatcher("shop.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
