package chucnangdangnhap;

public interface UserDao {
    User get(String username);
    void insert(User user); 
}