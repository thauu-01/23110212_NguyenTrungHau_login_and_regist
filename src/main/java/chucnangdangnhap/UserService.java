package chucnangdangnhap;

public interface UserService {
    User login(String username, String password);
    User get(String username);
    void register(String username, String password, String email); 
}