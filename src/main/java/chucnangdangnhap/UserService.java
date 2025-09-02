package chucnangdangnhap;

public interface UserService {
   
    User login(String username, String password);
    User get(String username);
    void register(User user);
    boolean checkExistUsername(String username);

  
    User findByEmail(String email); 
    boolean resetPassword(String email, String newPassword); 
}