/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vinh.dev.admin;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import vinh.dev.data.dao.Database;
import vinh.dev.data.dao.DatabaseDao;

/**
 *
 * @author 22 STORE
 */
public class BaseAdminServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {      
        DatabaseDao.init(new Database());
    }
    
}
