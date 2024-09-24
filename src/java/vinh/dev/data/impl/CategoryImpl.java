package vinh.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vinh.dev.data.dao.CategoryDao;
import vinh.dev.data.driver.MySQLDriver;
import vinh.dev.data.model.Category;

public class CategoryImpl implements CategoryDao {

    Connection con = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(Category category) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO CATEGORIES VALUES(NULL, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getThumbnail());

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        // TODO Auto-generated method stub
        String sql = "UPDATE CATEGORIES SET name = ?, thumbnail = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getThumbnail());
            stmt.setInt(3, category.getId());
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");

                return new Category(id, name, thumbnail);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        List<Category> cateList = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");

                cateList.add(new Category(id, name, thumbnail));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cateList;
    }

    @Override
    public List<Category> hotCategory() {
        List<Category> cateList = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES LIMIT 4";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String thumbnail = rs.getString("thumbnail");

                cateList.add(new Category(id, name, thumbnail));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cateList;
    }

    @Override
    public List<Category> fiFndAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
