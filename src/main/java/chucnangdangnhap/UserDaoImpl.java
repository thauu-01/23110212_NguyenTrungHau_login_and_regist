package chucnangdangnhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class UserDaoImpl implements UserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

   
    @Override
    public User get(String username) {
       
        String sql = "SELECT * FROM [User] WHERE username = ? ";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(Integer.parseInt(rs.getString("roleid")));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   
    @Override
    public void insert(User user) {
        String sql = "INSERT INTO [User] (email, username, fullname, password, avatar, roleid, phone, createdDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setString(5, user.getAvatar()); // Có thể set null nếu không có avatar
            ps.setInt(6, user.getRoleid()); // Mặc định roleid = 3 cho user thường
            ps.setString(7, user.getPhone());
            ps.setDate(8, new java.sql.Date(new Date().getTime())); // Ngày tạo hiện tại
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String sql = "SELECT * FROM [User] WHERE username = ? ";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duplicate;
    }
}