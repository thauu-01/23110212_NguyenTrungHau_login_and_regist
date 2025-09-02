package chucnangdangnhap;

public interface UserDao {

    User get(String username);

  
    void insert(User user);
    boolean checkExistUsername(String username);
    User findByEmail(String email);
    boolean resetPassword(String email, String newPassword);
}