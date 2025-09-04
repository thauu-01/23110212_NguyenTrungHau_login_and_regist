package chucnangdangnhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category (cate_name, user_id) VALUES (?, ?)";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCateName());
            ps.setInt(2, category.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Category SET cate_name = ? WHERE cate_id = ? AND user_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCateName());
            ps.setInt(2, category.getCateId());
            ps.setInt(3, category.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void delete(int cateId) {
        String sql = "DELETE FROM Category WHERE cate_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cateId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public Category get(int cateId) {
        String sql = "SELECT * FROM Category WHERE cate_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cateId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setCateId(rs.getInt("cate_id"));
                category.setCateName(rs.getString("cate_name"));
                category.setUserId(rs.getInt("user_id"));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public List<Category> getAllByUser(int userId) {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM Category WHERE user_id = ?";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCateId(rs.getInt("cate_id"));
                category.setCateName(rs.getString("cate_name"));
                category.setUserId(rs.getInt("user_id"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return categories;
    }

    private void closeResources() {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
}