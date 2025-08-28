package chucnangdangnhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [Users] WHERE username = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBConnection().getConnectionW();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO [Users] (email, username, password) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBConnection().getConnectionW();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassWord());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}